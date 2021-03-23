package com.wenwen.blog.util.ThreadPoolConfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author WangWenLei
 * @DATE: 2021/3/22
 **/
@Data
@ConfigurationProperties(prefix = "task.pool")
public class ThreadPoolConfig {
    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;
    private int keepAliveSeconds;
}
