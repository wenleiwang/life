package com.wenwen.blog.service.impl;

import com.wenwen.blog.entity.Comment;
import com.wenwen.blog.mapper.CommentMapper;
import com.wenwen.blog.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-06
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
