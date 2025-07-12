package com.study.lease.web.admin.schedule;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.study.lease.model.entity.LeaseAgreement;
import com.study.lease.model.enums.LeaseStatus;
import com.study.lease.web.admin.service.LeaseAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Date;

/**
 * ClassName: ScheduleTask
 * Package: com.study.lease.web.admin.schedule
 * Description:
 *
 * @Author pupil
 * @Create 2025/5/4 12:34
 * @Version 1.0
 */
@Component
public class ScheduleTask {

    @Autowired
    private LeaseAgreementService leaseAgreementService;
//    @Scheduled(cron="* * * * * *")
//    public void test(){
//        System.out.println("test");
//    }

    @Scheduled(cron="0 0 0 * * *")
    public void checkLeaseStatus(){
        leaseAgreementService.update(new LambdaUpdateWrapper<LeaseAgreement>()
                .lt(LeaseAgreement::getLeaseEndDate,new Date())
                .in(LeaseAgreement::getStatus,LeaseStatus.SIGNED, LeaseStatus.WITHDRAWING)
                .set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED));
    }
}
