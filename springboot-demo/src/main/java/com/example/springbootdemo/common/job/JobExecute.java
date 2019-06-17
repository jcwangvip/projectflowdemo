package com.example.springbootdemo.common.job;

import com.example.springbootdemo.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务执行
 *
 * @author jiancheng
 * @date 2019-6-17
 */
@Component
@Slf4j
@PropertySource("classpath:quartz.properties")
public class JobExecute {

    @Scheduled(cron = "${dateValue}")
    public void execute() {
        log.info("开始执行任务{}", DateUtils.getDate(new Date()));
    }


}
