package com.wenwen.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwen.blog.entity.BlogResArticleTag;
import com.wenwen.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WenleiWang
 * @since 2021-01-12
 */
@Repository
public interface BlogResArticleTagMapper extends BaseMapper<BlogResArticleTag> {

    void insertList(@Param("resList") List<BlogResArticleTag> resList);

    List<Integer> listTagByArticleId(@Param("articleId") Integer articleId);

    List<Tag> listTagNameByTagId(@Param("sqlIdList") String sqlIdList,@Param("userId") Integer userId);

    /**
     * 获取该用户的全部标签
     * @param userId 用户ID
     * @return 全部标签
     */
    List<Tag> listTag(@Param("userId") Integer userId);
}
