package com.wenwen.blog.entity.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangWenLei
 * @DATE: 2020/11/6
 **/
@Data
public class ArticleRequest {

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
