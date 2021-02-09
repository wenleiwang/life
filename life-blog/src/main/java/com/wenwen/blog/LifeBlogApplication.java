package com.wenwen.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//苟不记之笔墨,未免有辜彼苍之厚
@SpringBootApplication
@EnableScheduling //确保后台任务执行被创建
@MapperScan("com.wenwen.blog.mapper")//开启Mybatis-plus注解,需要扫描Service和Mapper才行
public class LifeBlogApplication {
	public static void main(String[] args) {
		System.out.println(new LifeBlogApplication().getClass().getClassLoader().getResource("").getPath());
		SpringApplication.run(LifeBlogApplication.class, args);
	}
}
