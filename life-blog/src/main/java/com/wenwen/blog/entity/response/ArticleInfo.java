package com.wenwen.blog.entity.response;

import lombok.Data;

import java.util.Date;

/**
 * @Author wwl
 * @Date 2021/3/28 13:46
 * @Version 1.0
 **/
@Data
public class ArticleInfo {
    private Integer articleId;
    private String articleName;
    private Date updateTime;
    private String index;
}
