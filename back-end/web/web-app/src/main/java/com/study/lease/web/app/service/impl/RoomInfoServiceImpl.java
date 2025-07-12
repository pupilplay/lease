package com.study.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.lease.common.constant.RedisConstant;
import com.study.lease.common.login.LoginUserHolder;
import com.study.lease.model.entity.ApartmentInfo;
import com.study.lease.model.entity.FacilityInfo;
import com.study.lease.model.entity.LabelInfo;
import com.study.lease.model.entity.RoomInfo;
import com.study.lease.model.enums.ItemType;
import com.study.lease.web.app.mapper.*;
import com.study.lease.web.app.service.ApartmentInfoService;
import com.study.lease.web.app.service.BrowsingHistoryService;
import com.study.lease.web.app.service.RoomInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.lease.web.app.vo.apartment.ApartmentDetailVo;
import com.study.lease.web.app.vo.graph.GraphVo;
import com.study.lease.web.app.vo.room.RoomDetailVo;
import com.study.lease.web.app.vo.room.RoomItemVo;
import com.study.lease.web.app.vo.room.RoomQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liubo
 * @description 针对表【room_info(房间信息表)】的数据库操作Service实现
 * @createDate 2023-07-26 11:12:39
 */
@Service
@Slf4j
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RoomInfoMapper roomInfoMapper;
    @Autowired
    private ApartmentInfoService apartmentInfoService;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    private AttrValueMapper attrValueMapper;
    @Autowired
    private FacilityInfoMapper facilityInfoMapper;
    @Autowired
    private LabelInfoMapper labelInfoMapper;
    @Autowired
    private PaymentTypeMapper paymentTypeMapper;
    @Autowired
    private FeeValueMapper feeValueMapper;
    @Autowired
    private LeaseTermMapper leaseTermMapper;
    @Autowired
    BrowsingHistoryService browsingHistoryService;

    @Override
    public IPage<RoomItemVo> pageItem(Page<RoomItemVo> page, RoomQueryVo queryVo) {
        return roomInfoMapper.pageItem(page, queryVo);
    }

    @Override
    public IPage<RoomItemVo> pageItemByApartmentId(Page<RoomItemVo> page, Long id) {
        return roomInfoMapper.pageItemByApartmentId(page, id);
    }

    @Override
    public RoomDetailVo getDetailById(Long id) {
        String key = RedisConstant.APP_LOGIN_PREFIX + id;
        RoomDetailVo roomDetailVo = (RoomDetailVo) redisTemplate.opsForValue().get(key);
        if (roomDetailVo == null) {
            RoomInfo roomInfo = roomInfoMapper.selectById(id);
            if (roomInfo == null) {
                return null;
            }
            roomDetailVo = new RoomDetailVo();
            BeanUtils.copyProperties(roomInfo, roomDetailVo);
            roomDetailVo.setApartmentItemVo(apartmentInfoService.selectApartmentItemVoById(roomInfo.getApartmentId()));
            roomDetailVo.setGraphVoList(graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, id));
            roomDetailVo.setAttrValueVoList(attrValueMapper.selectByRoomId(id));
            roomDetailVo.setFacilityInfoList(facilityInfoMapper.selectByRoomId(id));
            roomDetailVo.setLabelInfoList(labelInfoMapper.selectByRoomId(id));
            roomDetailVo.setPaymentTypeList(paymentTypeMapper.selectByRoomId(id));
            roomDetailVo.setFeeValueVoList(feeValueMapper.selectListByApartmentId(roomInfo.getApartmentId()));
            roomDetailVo.setLeaseTermList(leaseTermMapper.selectListByRoomId(id));

        }
        //Async method
        browsingHistoryService.saveHistory(LoginUserHolder.getLoginUser().getUserId(), id);
        return roomDetailVo;
    }
}




