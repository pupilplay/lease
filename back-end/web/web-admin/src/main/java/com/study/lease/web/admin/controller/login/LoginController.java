package com.study.lease.web.admin.controller.login;


import com.study.lease.common.login.LoginUserHolder;
import com.study.lease.common.result.Result;
import com.study.lease.common.utils.JwtUtil;
import com.study.lease.web.admin.service.LoginService;
import com.study.lease.web.admin.vo.login.CaptchaVo;
import com.study.lease.web.admin.vo.login.LoginVo;
import com.study.lease.web.admin.vo.system.user.SystemUserInfoVo;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "后台管理系统登录管理")
@RestController
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private LoginService service;

    @Operation(summary = "获取图形验证码")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {
        return Result.ok(service.getCaptcha());
    }

    @Operation(summary = "登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        return Result.ok(service.login(loginVo));
    }

    @Operation(summary = "获取登陆用户个人信息")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info() {
        return Result.ok(service.getLoginUserInfoById(LoginUserHolder.getLoginUser().getUserId()));
    }
}