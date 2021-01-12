package com.wenwen.blog.service;

import com.wenwen.blog.entity.Classify;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseListBase;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-06
 */
public interface IClassifyService extends IService<Classify> {

    /**
     * 用户添加分类
     * @param userId 用户ID
     * @param classifyName 分类名称
     * @return 添加状态
     */
    ResponseBase updateClassify(Integer classifyId, Integer userId, String classifyName);

    ResponseBase deleteClassify(Integer classifyId);

    /**
     * 获取该用户全部分类
     * @param userId 用户ID
     * @return 该用户全部分类
     */
    ResponseListBase<Classify> listClassify(Integer userId);
}
