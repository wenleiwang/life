package com.wenwen.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

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
@TableName("blog_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    /**
     * 名称
     */
    private String articleName;

    /**
     * 描述
     */
    private String articleDescription;

    /**
     * 内容
     */
    private String articleBody;

    /**
     * 文章所属用户
     */
    private Integer userId;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

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

    /**
     * 文章标志
     */
    private Integer articleFlag;

}
