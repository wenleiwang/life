package com.wenwen.blog.entity.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
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

    @ApiModelProperty(value = "点赞数量")
    private Integer starNum;

    @ApiModelProperty(value = "评论数量")
    private Integer commentNum;

    @ApiModelProperty(value = "收藏数量")
    private Integer collectNum;

    @ApiModelProperty(value = "浏览数量")
    private Integer viewNum;

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

    @ApiModelProperty(value = "文章分类ID")
    private String classifyId;
    @ApiModelProperty(value = "文章分类")
    private String classifyName;

    @ApiModelProperty(value = "文章标签ID列表")
    private List<Integer> tagIdList;

    @ApiModelProperty(value = "0-发布；1-删除；2-草稿")
    private Integer deleted;

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
}
