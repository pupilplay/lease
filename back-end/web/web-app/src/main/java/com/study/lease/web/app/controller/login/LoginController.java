package com.study.lease.web.app.controller.login;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.lease.common.login.LoginUser;
import com.study.lease.common.login.LoginUserHolder;
import com.study.lease.common.result.Result;
import com.study.lease.common.utils.JwtUtil;
import com.study.lease.model.entity.UserInfo;
import com.study.lease.model.enums.BaseStatus;
import com.study.lease.web.app.service.LoginService;
import com.study.lease.web.app.service.UserInfoService;
import com.study.lease.web.app.vo.user.LoginVo;
import com.study.lease.web.app.vo.user.UserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "登录管理")
@RestController
@RequestMapping("/app/")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserInfoService userInfoService;
    @GetMapping("login/getCode")
    @Operation(summary = "获取短信验证码")
    public Result getCode(@RequestParam String phone) {
        return Result.ok(loginService.getCode(phone));
    }

    @PostMapping("login")
    @Operation(summary = "登录")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        return Result.ok(loginService.login(loginVo));
    }

    @GetMapping("info")
    @Operation(summary = "获取登录用户信息")
    public Result<UserInfoVo> info() {
        Long userId= LoginUserHolder.getLoginUser().getUserId();
        return Result.ok(loginService.getLoginUserById(userId));
    }
}

