package com.study.lease.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.lease.common.result.Result;
import com.study.lease.model.entity.CityInfo;
import com.study.lease.model.entity.DistrictInfo;
import com.study.lease.model.entity.ProvinceInfo;
import com.study.lease.web.admin.service.CityInfoService;
import com.study.lease.web.admin.service.DistrictInfoService;
import com.study.lease.web.admin.service.ProvinceInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "地区信息管理")
@RestController
@RequestMapping("/admin/region")
public class RegionInfoController {

    @Autowired
    ProvinceInfoService provinceInfoService;
    @Autowired
    CityInfoService cityInfoService;
    @Autowired
    DistrictInfoService districtInfoService;
    @Operation(summary = "查询省份信息列表")
    @GetMapping("province/list")
    public Result<List<ProvinceInfo>> listProvince() {
        return Result.ok(provinceInfoService.list());
    }

    @Operation(summary = "根据省份id查询城市信息列表")
    @GetMapping("city/listByProvinceId")
    public Result<List<CityInfo>> listCityInfoByProvinceId(@RequestParam Long id) {
        return Result.ok(cityInfoService.list(new LambdaQueryWrapper<CityInfo>().eq(CityInfo::getProvinceId, id)));
    }

    @GetMapping("district/listByCityId")
    @Operation(summary = "根据城市id查询区县信息")
    public Result<List<DistrictInfo>> listDistrictInfoByCityId(@RequestParam Long id) {
        return Result.ok(districtInfoService.list(new LambdaQueryWrapper<DistrictInfo>().eq(DistrictInfo::getCityId, id)));
    }
}
