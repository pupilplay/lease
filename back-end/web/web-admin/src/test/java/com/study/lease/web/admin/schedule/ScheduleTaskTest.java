package com.study.lease.web.admin.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: ScheduleTaskTest
 * Package: com.study.lease.web.admin.schedule
 * Description:
 *
 * @Author pupil
 * @Create 2025/5/4 12:44
 * @Version 1.0
 */
@SpringBootTest
class ScheduleTaskTest {
    @Autowired
    private ScheduleTask scheduleTask;
    @Test
    public void test(){
        scheduleTask.checkLeaseStatus();
    }
}