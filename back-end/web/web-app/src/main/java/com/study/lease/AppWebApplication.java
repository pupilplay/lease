package com.study.lease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * ClassName: AppWebApplication
 * Package: com.study.lease
 * Description:
 *
 * @Author pupil
 * @Create 2025/5/5 19:36
 * @Version 1.0
 */
@SpringBootApplication
@EnableAsync
public class AppWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppWebApplication.class);
    }
}