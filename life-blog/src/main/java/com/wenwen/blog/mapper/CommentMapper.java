package com.wenwen.blog.mapper;

import com.wenwen.blog.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-06
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
