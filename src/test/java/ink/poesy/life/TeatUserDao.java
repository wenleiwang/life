package ink.poesy.life;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ink.poesy.life.dao.UserDao;
import ink.poesy.life.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName TeatUserDao
 * @Author wwl
 * @Date 2020/9/9 23:31
 * @Version 1.0
 **/
@SpringBootTest
public class TeatUserDao {

    @Autowired
    UserDao userDao;

    /**
     * 查询列表：
     */
    @Test
    public void test(){
        userDao.selectList(null).forEach(user -> System.out.println(user.toString()));
    }
    @Test
    void test1(){
        QueryWrapper<User> wapper = new QueryWrapper<>();
        wapper.ge("age",23);
        userDao.selectList(wapper).forEach(user -> System.out.println(user.toString()));
    }
}
