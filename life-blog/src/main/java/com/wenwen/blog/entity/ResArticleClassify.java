package com.wenwen.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blog_res_article_classify")
public class ResArticleClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 分类ID
     */
    private Integer classifyId;

    /**
     * 是否删除
     */
    private Boolean deleted;

    /**
     * 添加数据时间
     */
    private LocalDateTime addTime;

    /**
     * 修改数据时间
     */
    private LocalDateTime updateTime;


}
