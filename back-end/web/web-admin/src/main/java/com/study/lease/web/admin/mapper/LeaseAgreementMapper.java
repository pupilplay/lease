package com.study.lease.web.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.lease.model.entity.LeaseAgreement;
import com.study.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.study.lease.web.admin.vo.agreement.AgreementVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @author liubo
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2023-07-24 15:48:00
* @Entity com.study.lease.model.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> pageAgreement(Page<AgreementVo> page, AgreementQueryVo queryVo);
}




