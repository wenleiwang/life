package com.wenwen.common.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * 测试创建侧common
 * @author WangWenLei
 * @DATE: 2020/10/30
 **/
@Service
@EnableConfigurationProperties(ServiceProperties.class)
public class Hello {
    private final ServiceProperties serviceProperties;

    public Hello(ServiceProperties serviceProperties){
        this.serviceProperties = serviceProperties;
    }

    public String message(){
        return serviceProperties.getMessage();
    }

}
