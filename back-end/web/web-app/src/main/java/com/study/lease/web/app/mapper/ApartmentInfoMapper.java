package com.study.lease.web.app.mapper;

import com.study.lease.model.entity.ApartmentInfo;
import com.study.lease.web.app.vo.apartment.ApartmentItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author liubo
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Mapper
* @createDate 2023-07-26 11:12:39
* @Entity com.study.lease.model.entity.ApartmentInfo
*/
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    ApartmentItemVo selectApartmentItemVoById(Long id);
}




