package com.study.lease.web.admin.mapper;

import com.study.lease.model.entity.GraphInfo;
import com.study.lease.model.enums.ItemType;
import com.study.lease.web.admin.vo.graph.GraphVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author liubo
* @description 针对表【graph_info(图片信息表)】的数据库操作Mapper
* @createDate 2023-07-24 15:48:00
* @Entity com.study.lease.model.GraphInfo
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long id);
}




