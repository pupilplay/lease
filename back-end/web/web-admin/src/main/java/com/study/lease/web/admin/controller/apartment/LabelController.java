package com.study.lease.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.lease.common.result.Result;
import com.study.lease.model.entity.LabelInfo;
import com.study.lease.model.enums.ItemType;
import com.study.lease.web.admin.service.LabelInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "标签管理")
@RestController
@RequestMapping("/admin/label")
public class LabelController {

    @Autowired
    private LabelInfoService service;

    @Operation(summary = "（根据类型）查询标签列表")
    @GetMapping("list")
    public Result<List<LabelInfo>> labelList(@RequestParam(required = false) ItemType type) {
        return Result.ok(service.list(new LambdaQueryWrapper<LabelInfo>().eq(type!=null,LabelInfo::getType,type)));
    }

    @Operation(summary = "新增或修改标签信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdateLabel(@RequestBody LabelInfo labelInfo) {
        service.saveOrUpdate(labelInfo);
        return Result.ok();
    }

    @Operation(summary = "根据id删除标签信息")
    @DeleteMapping("deleteById")
    public Result deleteLabelById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }
}
