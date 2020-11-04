package com.wenwen.life_blog.service.learn.springbootw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangWenLei
 * @DATE: 2020/10/30
 **/
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(Hello.class)
@ConditionalOnProperty(prefix = "hello",value = "enabled",matchIfMissing = true)
public class HelloAutoConfiguration {
    @Autowired
    private HelloProperties helloProperties;

    @Bean
    @ConditionalOnMissingBean(Hello.class)
    public Hello hello(){
        Hello hello = new Hello();
        hello.setMsg(helloProperties.getMsg());
        return hello;
    }
}
