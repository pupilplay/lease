package com.study.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.lease.model.entity.BrowsingHistory;
import com.study.lease.web.app.mapper.BrowsingHistoryMapper;
import com.study.lease.web.app.service.BrowsingHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.lease.web.app.vo.history.HistoryItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author liubo
 * @description 针对表【browsing_history(浏览历史)】的数据库操作Service实现
 * @createDate 2023-07-26 11:12:39
 */
@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory>
        implements BrowsingHistoryService {
    @Autowired
    private BrowsingHistoryMapper mapper;
    @Override
    public IPage<HistoryItemVo> pageItemByUserId(Page<HistoryItemVo> page, Long userId) {
        return mapper.pageItemByUserId(page,userId);
    }

    @Override
    public void saveHistory(Long userId, Long id) {
        BrowsingHistory browsingHistory = mapper.selectOne(new LambdaQueryWrapper<BrowsingHistory>().eq(BrowsingHistory::getUserId, userId));
        if(browsingHistory!=null){
            browsingHistory.setBrowseTime(new Date());
            mapper.updateById(browsingHistory);
        }else{
            browsingHistory = new BrowsingHistory();
            browsingHistory.setUserId(userId);
            browsingHistory.setRoomId(id);
            browsingHistory.setBrowseTime(new Date());
            mapper.insert(browsingHistory);
        }
    }
}