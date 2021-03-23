package com.wenwen.blog.util.ThreadPoolConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 项目公用线程池
 * @author WangWenLei
 * @DATE: 2021/3/22
 **/
@Configuration
public class ThreadPoolUtil {

    @Autowired
    ThreadPoolConfig config;
    @Bean
    public ThreadPoolTaskExecutor threadPool(){
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        // 核心个数
        threadPool.setCorePoolSize(config.getCorePoolSize());
        // 最大线程数
        threadPool.setMaxPoolSize(config.getMaxPoolSize());
        // 队列容量
        threadPool.setQueueCapacity(config.getQueueCapacity());
        // 活跃时间
        threadPool.setKeepAliveSeconds(config.getKeepAliveSeconds());

        // 回收策略，这里使用CallerRunsPolicy:主线程直接执行该任务，执行完之后尝试添加下一个任务到线程池中，可以有效降低向线程池内添加任务的速度
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        threadPool.initialize();

        return threadPool;
    }
}
