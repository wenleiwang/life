package com.wenwen.blog.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author WenleiWang
 * @since 2021-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blog_res_article_tag")
public class BlogResArticleTag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 分类ID
     */
    private Integer tagId;

    /**
     * 是否删除
     */
    private Boolean deleted;

    /**
     * 添加数据时间
     */
    private Date addTime;

    /**
     * 修改数据时间
     */
    private Date updateTime;


}
