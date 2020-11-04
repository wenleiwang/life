package com.wenwen.life_blog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author WangWenLei
 * @DATE: 2020/11/2
 **/
//public class RelationalDataAccess implements CommandLineRunner {
//    private static final Logger log = LoggerFactory.getLogger(RelationalDataAccess.class);
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        log.info("creating tables..");
//
//        jdbcTemplate.execute("DROP TABLE user IF EXISTS");
//        jdbcTemplate.execute("create TABLE user (id SERIAL,name varchar(50), password varchar (50),phone varchar(50),email varchar(50),vip_flag)");
//
//    }
//}
