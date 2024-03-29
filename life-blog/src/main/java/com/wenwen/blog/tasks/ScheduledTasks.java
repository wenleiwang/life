package com.wenwen.blog.tasks;

import com.wenwen.blog.tasks.Service.SyncArticleViewCountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author WangWenLei
 * @DATE: 2020/11/2
 **/
@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    SyncArticleViewCountService syncArticleViewCountService;

    /**
     * 开启第一个定时任务，5000ms一次=5s一次
     *
     * 本示例使用fixedRate，它指定方法调用之间的间隔，从每次调用的开始时间开始计算。
     * 还有其他选项，例如fixedDelay，它指定从任务完成开始测量的两次调用之间的间隔。
     * 还可以使用@Scheduled(cron=". . .")表达式进行更复杂的任务调度。
     */
//    @Scheduled(cron = "0 0/5 * * * ? ")
    public void reportCurrentTime(){
        syncArticleViewCountService.syncArticleViewCountService();
    }


}
