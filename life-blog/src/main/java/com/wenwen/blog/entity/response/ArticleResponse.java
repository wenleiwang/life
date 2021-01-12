package com.wenwen.blog.entity.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author WangWenLei
 * @DATE: 2020/11/6
 **/
@Data
public class ArticleResponse {

    /**
     * 文章ID
     */
    @ApiModelProperty(value = "文章ID")
    private Integer articleId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "文章名称")
    private String articleName;

    /**
     * 描述
     */
    @ApiModelProperty(value = "文章描述")
    private String articleDescription;

    /**
     * 内容
     */
    @ApiModelProperty(value = "文章内容")
    private String articleBody;

    /**
     * 是否开启点赞
     */
    @ApiModelProperty(value = "是否开启点赞")
    private Boolean starStatus;

    /**
     * 是否开启评论
     */
    @ApiModelProperty(value = "是否开启评论")
    private Boolean commentStatus;

    /**
     * 是否开启收藏
     */
    @ApiModelProperty(value = "是否开启收藏")
    private Boolean collectStatus;

    /**
     * 首图
     */
    @ApiModelProperty(value = "首图地址")
    private String articleImgUrl;

    /**
     * 文章标志
     */
    @ApiModelProperty(value = "文章标志")
    private Integer articleFlag;

    @ApiModelProperty(value = "文章分类")
    private String classifyName;

    @ApiModelProperty(value = "文章标签ID列表")
    private List<Integer> tagIdList;

    @ApiModelProperty(value = "0-发布；1-删除；2-草稿")
    private Integer deleted;
}
