package com.wenwen.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //确保后台任务执行被创建
@MapperScan("com.wenwen")//开启Mybatis-plus注解,需要扫描Service和Mapper才行
public class LifeBlogApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeBlogApplication.class, args);
	}
}
