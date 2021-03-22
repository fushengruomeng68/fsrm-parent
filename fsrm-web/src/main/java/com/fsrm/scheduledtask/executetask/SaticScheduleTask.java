package com.fsrm.scheduledtask.executetask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Slf4j
@Configuration
@EnableScheduling
public class SaticScheduleTask {

    @Scheduled(cron = "0 40/1 10-16 * * ? ")
    private void fullDataInfo() {
        log.info("定时时间:" + LocalDateTime.now());
    }

}
