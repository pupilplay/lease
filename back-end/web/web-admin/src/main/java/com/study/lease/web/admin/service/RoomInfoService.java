package com.study.lease.web.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.lease.model.entity.RoomInfo;
import com.study.lease.web.admin.vo.room.RoomDetailVo;
import com.study.lease.web.admin.vo.room.RoomItemVo;
import com.study.lease.web.admin.vo.room.RoomQueryVo;
import com.study.lease.web.admin.vo.room.RoomSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liubo
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2023-07-24 15:48:00
*/
public interface RoomInfoService extends IService<RoomInfo> {

    IPage<RoomItemVo> pageItem(Page<RoomItemVo> page, RoomQueryVo queryVo);

    void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo);

    RoomDetailVo geteDetailById(Long id);

    void removeRoomById(Long id);
}
