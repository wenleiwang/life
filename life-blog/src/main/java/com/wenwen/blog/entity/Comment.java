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
@TableName("blog_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论ID
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    /**
     * 评论内容
     */
    private String commentBody;

    /**
     * 父级评论ID，0-表示1级评论
     */
    private Integer commentParent;

    /**
     * 评论用户
     */
    private Integer userId;

    /**
     * 被评论文章
     */
    private Integer articleId;

    /**
     * 评论添加时间
     */
    private Date addTime;

    /**
     * 评论修改时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Boolean deleted;


}
