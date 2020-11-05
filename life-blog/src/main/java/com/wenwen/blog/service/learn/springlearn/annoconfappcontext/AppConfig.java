package com.wenwen.blog.service.learn.springlearn.annoconfappcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangWenLei
 * @DATE: 2020/11/4
 **/
@Configuration
@ComponentScan(basePackages = "ink")
public class AppConfig {

    /**
     * 为了这个@Bean需要编写MySvice和MyserviceImpl
     * @return bean对象
     */
    @Bean
    public MyService myService(){
        return new MyServiceImpl();
    }
}
