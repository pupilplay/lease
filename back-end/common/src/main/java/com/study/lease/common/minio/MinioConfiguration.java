package com.study.lease.common.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MinioConfiguration
 * Package: com.study.lease.common.minio
 * Description:
 *
 * @Author pupil
 * @Create 2025/4/28 17:19
 * @Version 1.0
 */
@EnableConfigurationProperties(MinioProperties.class)
//@ConfigurationPropertiesScan("com.study.lease.common.minio")
@ConditionalOnProperty(name="minio.endpoint")
@Configuration
public class MinioConfiguration {
    @Autowired
    private MinioProperties properties;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(properties.getEndpoint())
                .credentials(properties.getAccessKey(), properties.getSecretKey())
                .build();
    }
}
