package com.wenwen.blog.service;

import com.wenwen.blog.entity.BlogResArticleTag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wenwen.blog.entity.Tag;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseListBase;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WenleiWang
 * @since 2021-01-12
 */
public interface IBlogResArticleTagService extends IService<BlogResArticleTag> {

    /**
     * 通过ID获取标签名数组
     * @param listTagId 标签列表
     * @param userId 标签用户
     * @return 标签名数组
     */
    ResponseListBase<Tag> listTagNameByTagId(List<Integer> listTagId,Integer userId);

    /**
     * 获取该用户的全部标签
     * @param userId 用户ID
     * @return 全部标签
     */
    ResponseListBase<Tag> listTag(Integer userId);

    /**
     * 添加更新标签
     * @param tagId 标签ID
     * @param userId 标签所属用户
     * @param tagName 标签名
     * @return 更新状态
     */
    ResponseBase updateTag(Integer tagId, Integer userId, String tagName);
}
