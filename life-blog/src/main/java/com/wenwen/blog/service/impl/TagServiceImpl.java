package com.wenwen.blog.service.impl;

import com.wenwen.blog.entity.Tag;
import com.wenwen.blog.mapper.TagMapper;
import com.wenwen.blog.service.ITagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
