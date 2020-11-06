package com.wenwen.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blog_article_interaction")
public class ArticleInteraction implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 点赞
     */
    @TableId(value = "heat_id", type = IdType.AUTO)
    private Integer heatId;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 点赞数量
     */
    private Integer starNum;

    /**
     * 评论数量
     */
    private Integer commentNum;

    /**
     * 收藏数量
     */
    private Integer collectNum;

    private LocalDateTime addTime;

    private LocalDateTime updateTime;

    private Boolean deleted;

    /**
     * 是否开启点赞
     */
    private Boolean starStatus;

    /**
     * 是否开启评论
     */
    private Boolean commentStatus;

    /**
     * 是否开启收藏
     */
    private Boolean collectStatus;

    /**
     * 首图
     */
    private String articleImgUrl;
}
