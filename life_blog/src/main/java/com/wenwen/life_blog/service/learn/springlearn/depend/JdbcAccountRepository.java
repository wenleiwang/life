package com.wenwen.life_blog.service.learn.springlearn.depend;

import org.springframework.stereotype.Service;

/**
 * @author WangWenLei
 * @DATE: 2020/11/4
 **/
@Service
public class JdbcAccountRepository implements AccountRepository {

    public JdbcAccountRepository(DataSource dataSource) {

    }
}
