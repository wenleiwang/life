package com.wenwen.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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

    //入参初始化，格式化成什么样入参就按格式传入,不能格式化入参，不然插入不了数据库了
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //出参格式化，jackson序列化按照国际事件GMT，格式正确，但早了8个小时。添加timezone = "GMT+8"
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date addTime;

    //入参初始化，格式化成什么样入参就按格式传入,不能格式化入参，不然插入不了数据库了
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //出参格式化，jackson序列化按照国际事件GMT，格式正确，但早了8个小时。添加timezone = "GMT+8"
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date updateTime;

    private Integer deleted;

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
