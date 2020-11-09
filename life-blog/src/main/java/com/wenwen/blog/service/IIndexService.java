package com.wenwen.blog.service;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.util.response.ResponseListBase;

import java.util.List;

public interface IIndexService {
    /**
     * 分页获取文章列表数据
     * @param search 查询条件
     * @param pageNum 当前页
     * @param pageSize 页大小
     * @return 符合条件的列表
     */
    ResponseListBase<Article> listArticle(String search, Integer pageNum, Integer pageSize);

    /**
     * 获取TOP9的文章标题
     * @return 文章标题TOP9
     */
    ResponseListBase<String> listHostArticle();

    /**
     * 通过用户ID获取分类列表
     * @param userId 用户ID
     * @return 对应用户的分类列表
     */
    ResponseListBase<String> listClassify(Integer userId);
}
