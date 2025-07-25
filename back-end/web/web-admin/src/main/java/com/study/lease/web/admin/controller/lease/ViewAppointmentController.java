package com.study.lease.web.admin.controller.lease;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.lease.common.result.Result;
import com.study.lease.model.entity.ViewAppointment;
import com.study.lease.model.enums.AppointmentStatus;
import com.study.lease.web.admin.service.ViewAppointmentService;
import com.study.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.study.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "预约看房管理")
@RequestMapping("/admin/appointment")
@RestController
public class ViewAppointmentController {

    @Autowired
    ViewAppointmentService service;
    @Operation(summary = "分页查询预约信息")
    @GetMapping("page")
    public Result<IPage<AppointmentVo>> page(@RequestParam long current, @RequestParam long size, AppointmentQueryVo queryVo) {
        IPage<AppointmentVo> page = new Page<>(current,size);
        return Result.ok(service.pageAppointment(page,queryVo));
    }

    @Operation(summary = "根据id更新预约状态")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam AppointmentStatus status) {
        service.update(new LambdaUpdateWrapper<ViewAppointment>().eq(ViewAppointment::getId, id).set(ViewAppointment::getAppointmentStatus,status));
        return Result.ok();
    }

}
