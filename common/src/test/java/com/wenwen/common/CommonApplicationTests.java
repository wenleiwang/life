package com.wenwen.common;

import com.wenwen.common.service.Hello;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("hello.message=wenwen")
class CommonApplicationTests {
	@Autowired
	Hello hello;

	@Test
	 void contextLoads() {
		System.out.println(hello.message());
	}

	@SpringBootApplication
	static class TestConfiguration {
	}

}
