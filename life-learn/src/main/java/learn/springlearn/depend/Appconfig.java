//package com.wenwen.life_blog.service.learn.springlearn.depend;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//
///**
// * @author WangWenLei
// * @DATE: 2020/11/4
// **/
//@Configuration(value = "appconfig1")
////@ComponentScan("com.wenwen.life_blg.service")
////@Import({ServiceConfig.class,RepositoryConfig.class})
//public class Appconfig {
//
//
//    @Bean(initMethod = "init")
//    public BeanOne beanOne(){
//        return new BeanOne();
//    }
//
//    @Bean(destroyMethod = "cleanup")
//    public BeanTwo beanTwo(){
//        return new BeanTwo();
//    }
//
//    @Bean
//    public DataSource dataSource(){
//        return new DataSource();
//    }
//
//}
