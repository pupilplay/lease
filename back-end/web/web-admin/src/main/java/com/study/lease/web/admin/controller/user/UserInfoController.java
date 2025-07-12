package com.study.lease.web.admin.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.lease.common.result.Result;
import com.study.lease.model.entity.UserInfo;
import com.study.lease.model.enums.BaseStatus;
import com.study.lease.web.admin.service.UserInfoService;
import com.study.lease.web.admin.vo.user.UserInfoQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户信息管理")
@RestController
@RequestMapping("/admin/user")
public class UserInfoController {

    @Autowired
    private UserInfoService service;
    @Operation(summary = "分页查询用户信息")
    @GetMapping("page")
    public Result<IPage<UserInfo>> pageUserInfo(@RequestParam long current, @RequestParam long size, UserInfoQueryVo queryVo) {
        Page<UserInfo> page = new Page<>(current, size);
        return Result.ok(service.page(page,new LambdaQueryWrapper<UserInfo>()
                .like(queryVo.getPhone() != null,UserInfo::getPhone,queryVo.getPhone())
                .eq(queryVo.getStatus() != null,UserInfo::getStatus,queryVo.getStatus())));
    }

    @Operation(summary = "根据用户id更新账号状态")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam BaseStatus status) {
        service.update(new LambdaUpdateWrapper<UserInfo>().eq(UserInfo::getId,id).set(UserInfo::getStatus,status));
        return Result.ok();
    }
}
