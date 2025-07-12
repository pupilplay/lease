package com.study.lease.common.utils;

import com.study.lease.common.exception.LeaseException;
import com.study.lease.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * ClassName: JwtUtil
 * Package: com.study.lease.common.utils
 * Description:
 *
 * @Author pupil
 * @Create 2025/5/5 13:19
 * @Version 1.0
 */
public class JwtUtil {
    private static SecretKey secretKey = Keys.hmacShaKeyFor("123456789123456789123456789123456789".getBytes());

    public static String createToken(Long userId,String username){
        return Jwts.builder().setExpiration(new Date(System.currentTimeMillis()+3600000))
                .setSubject("LOGIN_USER")
                .claim("userId",userId)
                .claim("username",username)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }
    public static Claims parseToken(String token){
        if(token==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return claimsJws.getBody();
        } catch (ExpiredJwtException e) {
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED);
        } catch (JwtException e){
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID);
        }
    }


    //test
//    public static void main(String[] args) {
//        System.out.println(createToken(1L,"zhangsan"));
//    }
}
