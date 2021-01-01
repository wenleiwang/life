package com.wenwen.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.ResArticleClassify;
import com.wenwen.blog.util.response.ResponseListBase;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-09
 */
public interface IResArticleClassifyService extends IService<ResArticleClassify> {

    /**
     * 通过分类ID获取该用户次分类的文章列表
     * @param classifyId 分类ID
     * @param userId 用户ID
     * @return 文章列表
     */
    ResponseListBase<Article> listArticleFromClassifyId(Integer classifyId, Integer userId);
}
