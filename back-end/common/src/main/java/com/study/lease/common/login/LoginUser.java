package com.study.lease.common.login;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName: LoginUser
 * Package: com.study.lease.common.login
 * Description:
 *
 * @Author pupil
 * @Create 2025/5/5 18:27
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class LoginUser {
    private Long userId;
    private String username;
}
