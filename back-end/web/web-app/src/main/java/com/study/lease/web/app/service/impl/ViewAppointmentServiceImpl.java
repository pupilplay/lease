package com.study.lease.web.app.service.impl;

import com.study.lease.model.entity.ViewAppointment;
import com.study.lease.web.app.mapper.ApartmentInfoMapper;
import com.study.lease.web.app.mapper.ViewAppointmentMapper;
import com.study.lease.web.app.service.ViewAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.lease.web.app.vo.apartment.ApartmentItemVo;
import com.study.lease.web.app.vo.appointment.AppointmentDetailVo;
import com.study.lease.web.app.vo.appointment.AppointmentItemVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liubo
 * @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
 * @createDate 2023-07-26 11:12:39
 */
@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
        implements ViewAppointmentService {
    @Autowired
    private ViewAppointmentMapper viewAppointmentMapper;
    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;

    @Override
    public List<AppointmentItemVo> listItem(Long id) {
        return viewAppointmentMapper.listItem(id);
    }

    @Override
    public AppointmentDetailVo getDetailById(Long id) {
        AppointmentDetailVo appointmentDetailVo=new AppointmentDetailVo();

        ViewAppointment viewAppointment= viewAppointmentMapper.selectById(id);
        BeanUtils.copyProperties(viewAppointment,appointmentDetailVo);

        ApartmentItemVo apartmentItemVo=apartmentInfoMapper.selectApartmentItemVoById(viewAppointment.getApartmentId());

        return appointmentDetailVo;
    }
}




