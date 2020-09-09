package ink.poesy.life.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ink.poesy.life.pojo.User;
import org.springframework.stereotype.Repository;

/**
  * 使用mybatis-plus来增强
  * @Author wwl
  * @Date 23:27 2020/9/9
  * @Param
  * @return
 **/
public interface UserDao extends BaseMapper<User> {
}
