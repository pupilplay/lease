package com.study.lease.web.app.controller.history;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.lease.common.login.LoginUserHolder;
import com.study.lease.common.result.Result;
import com.study.lease.web.app.service.BrowsingHistoryService;
import com.study.lease.web.app.vo.history.HistoryItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "浏览历史管理")
@RequestMapping("/app/history")
public class BrowsingHistoryController {

    @Autowired
    private BrowsingHistoryService service;

    @Operation(summary = "获取浏览历史")
    @GetMapping("pageItem")
    private Result<IPage<HistoryItemVo>> page(@RequestParam long current, @RequestParam long size) {
        Page<HistoryItemVo> page = new Page<HistoryItemVo>(current, size);
        return Result.ok(service.pageItemByUserId(page, LoginUserHolder.getLoginUser().getUserId()));
    }
}
