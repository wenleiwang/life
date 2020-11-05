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

    private LocalDateTime addTime;

    private LocalDateTime updateTime;

    private Boolean deteled;


}
