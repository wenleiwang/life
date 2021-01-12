package com.wenwen.blog.mapper;

import com.wenwen.blog.entity.Classify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
     * 通过文章ID得到这个文章对应的分类ID列表
     * @param articleId 文章ID
     * @return 文章对应的分类ID列表
     */
    List<Integer> listClassifyByArticleId(Integer articleId);
}
