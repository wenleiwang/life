package com.wenwen.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
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


}
