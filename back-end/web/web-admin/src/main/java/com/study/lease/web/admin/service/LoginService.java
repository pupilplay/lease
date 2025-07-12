package com.study.lease.web.admin.service;

import com.study.lease.web.admin.vo.login.CaptchaVo;
import com.study.lease.web.admin.vo.login.LoginVo;
import com.study.lease.web.admin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getLoginUserInfoById(Long id);
}
