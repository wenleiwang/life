package com.wenwen.life_blog;

import com.wenwen.common.service.Hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.wenwen")
@RestController
@EnableScheduling //确保后台任务执行被创建
public class LifeBlogApplication {

	private final Hello hello;

	public LifeBlogApplication(Hello hello){
		this.hello = hello;
	}

	@GetMapping("/hello")
	public String home(){
		return hello.message();
	}

	public static void main(String[] args) {
		SpringApplication.run(LifeBlogApplication.class, args);
	}

}
