package com.wenwen.blog;

import com.wenwen.blog.entity.User;
import com.wenwen.blog.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest(classes = LifeBlogApplication.class)
class LifeBlogApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(new LifeBlogApplicationTests().getClass().getClassLoader().getResource("").getPath());
	}
}
