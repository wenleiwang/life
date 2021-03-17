package com.wenwen.blog.mapper;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.Classify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-06
 */
@Mapper
public interface ClassifyMapper extends BaseMapper<Classify> {

    /**
     * 通过用户ID获取分类
     * @param userId
     * @return
     */
    List<Classify> listClassifyByUserId(@Param("userId") Integer userId);

    /**
     * 删除传入类中没有的类
     * @param inClassify 传入类
     * @param userId 用户
     * @return 删除状态
     */
    int deleteOverClassify(String inClassify, Integer userId);

    /**
     * 获取分类名对应的信息
     * @param classifyName 分类名
     * @param userId 用户ID
     * @return 这个用户这个分类的信息
     */
    Classify getClassifyInfoByNameAndUserId(@Param("classifyName") String classifyName, @Param("userId") Integer userId);

    /**
     * 根据用户分类获取该用户文章列表
     * @param classifyId 分类ID
     * @param userId 用户ID
     * @return 符合条件文章
     */
    List<Article> listArticleFromClassifyId(@RequestParam("classifyId") Integer classifyId, @RequestParam("userId") Integer userId);
}
