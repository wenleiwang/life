package com.wenwen.blog.service.learn.springlearn.depend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangWenLei
 * @DATE: 2020/11/4
 **/
@Configuration
public class RepositoryConfig {

    @Bean
    public AccountRepository accountRepository(DataSource dataSource){
        return new JdbcAccountRepository(dataSource);
    }
}
