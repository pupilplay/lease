package com.study.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Schema(description = "公寓&杂费关联表")
@TableName(value = "apartment_fee_value")
@Data
//@Builder
public class ApartmentFeeValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "公寓id")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "收费项value_id")
    @TableField(value = "fee_value_id")
    private Long feeValueId;

}