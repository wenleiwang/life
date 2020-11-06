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
@TableName("blog_tag")
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
    @TableId(value = "tag_id", type = IdType.AUTO)
    private Integer tagId;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 标签所属用户
     */
    private Integer userId;

    /**
     * 标签添加时间
     */
    private LocalDateTime addTime;

    /**
     * 标签修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Boolean deleted;


}
