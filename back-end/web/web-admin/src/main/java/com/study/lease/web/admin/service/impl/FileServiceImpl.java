package com.study.lease.web.admin.service.impl;

import com.study.lease.web.admin.service.FileService;
import io.minio.*;
import com.study.lease.common.minio.MinioProperties;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MinioProperties minioProperties;
    @Autowired
    private MinioClient minioClient;

    @Override
    public String upload(MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
            if (!minioClient.bucketExists(BucketExistsArgs.builder()
                    .bucket(minioProperties.getBucketName())
                    .build())) {
                minioClient.makeBucket(MakeBucketArgs.builder()
                        .bucket(minioProperties.getBucketName())
                        .build());
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder()
                        .bucket(minioProperties.getBucketName())
                        .config(createBucketPolicyConfig(minioProperties.getBucketName()))
                        .build());
            }
            String filename = new SimpleDateFormat("yyyyMMdd").format(new Date())
                    + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(minioProperties.getBucketName())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .object(filename)
                    .contentType(file.getContentType())
                    .build());
            return String.join("/", minioProperties.getEndpoint(), minioProperties.getBucketName(), filename);
    }

    private String createBucketPolicyConfig(String bucketName) {
        return """
                {
                    "Statement" : [{
                        "Action" : "s3:GetObject",
                        "Effect" : "Allow",
                        "Principal" : "*",
                        "Resource" : "arn:aws:s3:::%s/*"
                    }],
                    "Version" : "2012-10-17"
                }
                """.formatted(bucketName);
    }
}
