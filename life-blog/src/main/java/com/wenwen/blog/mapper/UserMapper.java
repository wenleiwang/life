package com.wenwen.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwen.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<Map<String,String>> listUser();
    Map<String,String> listUserOne();
}
