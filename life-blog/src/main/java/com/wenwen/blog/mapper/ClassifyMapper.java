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
    List<String> listClassifyByUserId(@Param("userId") Integer userId);
}
