package com.wenwen.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.ResArticleClassify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-09
 */
@Mapper
public interface ResArticleClassifyMapper extends BaseMapper<ResArticleClassify> {

    /**
     * 根据用户分类获取该用户文章列表
     * @param classifyId 分类ID
     * @param userId 用户ID
     * @return 符合条件文章
     */
    List<Article> listArticleFromClassifyId(@RequestParam("classifyId") Integer classifyId,@RequestParam("userId") Integer userId);

    List<Integer> listClassifyByArticleId(Integer articleId);

    Integer insertList(List<ResArticleClassify> resList);
}
