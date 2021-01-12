package com.wenwen.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenwen.blog.entity.BlogResArticleTag;
import com.wenwen.blog.entity.Classify;
import com.wenwen.blog.entity.Tag;
import com.wenwen.blog.mapper.BlogResArticleTagMapper;
import com.wenwen.blog.mapper.TagMapper;
import com.wenwen.blog.service.IBlogResArticleTagService;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseListBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WenleiWang
 * @since 2021-01-12
 */
@Service
public class BlogResArticleTagServiceImpl extends ServiceImpl<BlogResArticleTagMapper, BlogResArticleTag> implements IBlogResArticleTagService {
    @Autowired
    BlogResArticleTagMapper blogResArticleTagMapper;

    @Autowired
    TagMapper tagMapper;

    @Override
    public ResponseListBase<Tag> listTagNameByTagId(List<Integer> listTagId,Integer userId) {
        ResponseListBase<Tag> response = new ResponseListBase<>();
        String sqlIdList = "";
        String collect = listTagId.stream().map(item -> sqlIdList + item.toString() + ",").collect(Collectors.joining());
        List <Tag> list = blogResArticleTagMapper.listTagNameByTagId(collect.substring(0,collect.length() - 1),userId);
        response.setData(list);
        response.successful();
        return response;
    }

    @Override
    public ResponseListBase<Tag> listTag(Integer userId) {
        ResponseListBase<Tag> response = new ResponseListBase<>();
        List<Tag> list = blogResArticleTagMapper.listTag(userId);
        if(list == null){
            response.fail("查询出错！");
            return response;
        }
        if(list.size() == 0){
            response.successful("查询成功，没有符合条件的数据！");
            return response;
        }
        response.setData(list);
        response.successful("查询成功！");
        return response;
    }

    @Override
    public ResponseBase updateTag(Integer tagId, Integer userId, String tagName) {
        ResponseBase response = new ResponseBase();
        Tag tag = new Tag();
        Date date = new Date();
        if(tagId == null){
            //插入
            tag.setTagName(tagName);
            tag.setAddTime(date);
            tag.setUpdateTime(date);
            tag.setUserId(userId);
            tag.setDeleted(false);
            final int insert = tagMapper.insert(tag);
            if(insert <= 0){
                response.fail("插入标签失败，操作数据库失败！");
            }else{
                response.successful("插入标签成功！");
            }
        }else{
            //修改
            tag.setTagId(tagId);
            tag.setTagName(tagName);
            tag.setUpdateTime(date);
            tag.setDeleted(false);
            final int update = tagMapper.updateById(tag);
            if(update <= 0){
                response.fail("更新标签失败，操作数据库失败！");
            }else{
                response.successful("更新标签成功！");
            }
        }

        return response;
    }
}
