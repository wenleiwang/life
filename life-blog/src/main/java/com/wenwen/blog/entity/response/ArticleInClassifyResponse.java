package com.wenwen.blog.entity.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 页面头分类下拉，带分类下文章列表
 * @Author wwl
 * @Date 2021/3/28 13:42
 * @Version 1.0
 **/
@Data
public class ArticleInClassifyResponse {
    /**
     * 分类ID
     */
    private Integer classifyId;

    /**
     * 分类名
     */
    private String classifyName;

    /**
     * 分类所属用户
     */
    private Integer userId;
    /**
     * 修改时间
     */
    private Date updateTime;

    private List<ArticleInfo> listArticle;

}
