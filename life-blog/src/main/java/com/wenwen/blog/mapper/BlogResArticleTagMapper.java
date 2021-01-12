package com.wenwen.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.wenwen.blog.entity.BlogResArticleTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WenleiWang
 * @since 2021-01-12
 */
//@Mapper
public interface BlogResArticleTagMapper extends BaseMapper<BlogResArticleTag> {

    void insertList(List<BlogResArticleTag> resList);

    List<Integer> listTagByArticleId(@Param("articleId") Integer articleId);
}
