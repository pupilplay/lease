package com.study.lease.web.app.service;

import com.study.lease.web.app.vo.user.LoginVo;
import com.study.lease.web.app.vo.user.UserInfoVo;

public interface LoginService {
    String getCode(String phone);

    UserInfoVo getLoginUserById(Long userId);

    String login(LoginVo loginVo);
}
