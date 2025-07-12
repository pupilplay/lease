package com.study.lease.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.lease.model.entity.BrowsingHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.lease.web.app.vo.history.HistoryItemVo;
import org.springframework.scheduling.annotation.Async;

/**
* @author liubo
* @description 针对表【browsing_history(浏览历史)】的数据库操作Service
* @createDate 2023-07-26 11:12:39
*/
public interface BrowsingHistoryService extends IService<BrowsingHistory> {
    IPage<HistoryItemVo> pageItemByUserId(Page<HistoryItemVo> page, Long userId);

    @Async
    void saveHistory(Long userId, Long id);
}
