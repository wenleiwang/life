package com.wenwen.blog;

import com.wenwen.blog.uploadingfiles.storage.StorageProperties;
import com.wenwen.blog.uploadingfiles.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.wenwen")
@EnableScheduling //确保后台任务执行被创建
@EnableConfigurationProperties(StorageProperties.class)
public class LifeBlogApplication {


	public static void main(String[] args) {
		SpringApplication.run(LifeBlogApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
