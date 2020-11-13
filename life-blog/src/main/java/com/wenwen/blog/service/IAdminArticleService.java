package com.wenwen.blog.service;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.request.ArticleRequest;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseListBase;
import com.wenwen.common.context.UserInfo;

public interface IAdminArticleService {
    /**
     * 添加或更新文章，如果有id则更新文章，如果没有id则添加新建文章
     * @param article 文章对象
     * @param userContext
     * @return 是否成功
     */
    ResponseBase updateArticle(ArticleRequest article, UserInfo userContext);

    /**
     * 通过用户ID返回该用户博客列表，有搜索条件按搜索条件返回
     * @param search 搜索条件
     * @param pageNum 当前页
     * @param pageSize 页大小
     * @param userId 用户ID
     * @return 博客列表
     */
    ResponseListBase<Article> listArticle(String search, Integer pageNum, Integer pageSize, Integer userId);

    /**
     * 删除文章
     * @param articledId 文章主键ID
     * @return 删除状态
     */
    ResponseBase deleteArticle(Integer articledId);

}
