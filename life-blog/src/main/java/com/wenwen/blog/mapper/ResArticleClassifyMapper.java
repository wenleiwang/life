package com.wenwen.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.ResArticleClassify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
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
@Repository
public interface ResArticleClassifyMapper extends BaseMapper<ResArticleClassify> {



    List<Integer> listClassifyByArticleId(Integer articleId);

    Integer insertList(List<ResArticleClassify> resList);
}
