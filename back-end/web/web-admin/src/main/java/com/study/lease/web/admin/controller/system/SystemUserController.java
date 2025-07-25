package com.study.lease.web.admin.controller.system;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.lease.common.result.Result;
import com.study.lease.model.entity.SystemUser;
import com.study.lease.model.enums.BaseStatus;
import com.study.lease.web.admin.service.SystemUserService;
import com.study.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.study.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "后台用户信息管理")
@RestController
@RequestMapping("/admin/system/user")
public class SystemUserController {
    @Autowired
    private SystemUserService service;

    @Operation(summary = "根据条件分页查询后台用户列表")
    @GetMapping("page")
    public Result<IPage<SystemUserItemVo>> page(@RequestParam long current, @RequestParam long size, SystemUserQueryVo queryVo) {
        Page<SystemUserItemVo> page = new Page<>(current, size);
        return Result.ok(service.pageBySystemUser(page,queryVo));
    }

    @Operation(summary = "根据ID查询后台用户信息")
    @GetMapping("getById")
    public Result<SystemUserItemVo> getById(@RequestParam Long id) {
        return Result.ok(service.getSystemUserById(id));
    }

    @Operation(summary = "保存或更新后台用户信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemUser systemUser) {
        if(systemUser.getPassword()!=null){
            systemUser.setPassword(DigestUtils.md5Hex(systemUser.getPassword()));
        }
        return Result.ok(service.saveOrUpdate(systemUser));
    }

    @Operation(summary = "判断后台用户名是否可用")
    @GetMapping("isUserNameAvailable")
    public Result<Boolean> isUsernameExists(@RequestParam String username) {
        return Result.ok(service.count(new LambdaQueryWrapper<SystemUser>().eq(SystemUser::getUsername,username))==0);
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "根据ID删除后台用户信息")
    public Result removeById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "根据ID修改后台用户状态")
    @PostMapping("updateStatusByUserId")
    public Result updateStatusByUserId(@RequestParam Long id, @RequestParam BaseStatus status) {
        service.update(new LambdaUpdateWrapper<SystemUser>().eq(SystemUser::getId,id).set(SystemUser::getStatus,status));
        return Result.ok();
    }
}
