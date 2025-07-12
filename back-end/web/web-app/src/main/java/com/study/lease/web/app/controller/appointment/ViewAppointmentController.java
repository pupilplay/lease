package com.study.lease.web.app.controller.appointment;


import com.study.lease.common.login.LoginUserHolder;
import com.study.lease.common.result.Result;
import com.study.lease.model.entity.ViewAppointment;
import com.study.lease.web.app.service.ViewAppointmentService;
import com.study.lease.web.app.vo.appointment.AppointmentDetailVo;
import com.study.lease.web.app.vo.appointment.AppointmentItemVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "看房预约信息")
@RestController
@RequestMapping("/app/appointment")
public class ViewAppointmentController {
    @Autowired
    private ViewAppointmentService service;

    @Operation(summary = "保存或更新看房预约")
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ViewAppointment viewAppointment) {
        return Result.ok(service.saveOrUpdate(viewAppointment));
    }

    @Operation(summary = "查询个人预约看房列表")
    @GetMapping("listItem")
    public Result<List<AppointmentItemVo>> listItem() {
        return Result.ok(service.listItem(LoginUserHolder.getLoginUser().getUserId()));
    }

    @GetMapping("getDetailById")
    @Operation(summary = "根据ID查询预约详情信息")
    public Result<AppointmentDetailVo> getDetailById(Long id) {
        return Result.ok(service.getDetailById(id));
    }

}

