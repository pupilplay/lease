package com.study.lease.web.admin.mapper;

import com.study.lease.model.entity.ViewAppointment;
import com.study.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.study.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @author liubo
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Mapper
* @createDate 2023-07-24 15:48:00
* @Entity com.study.lease.model.ViewAppointment
*/
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    IPage<AppointmentVo> pageAppointment(IPage<AppointmentVo> page, AppointmentQueryVo queryVo);
}




