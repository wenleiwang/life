package com.wenwen.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.ResArticleClassify;
import com.wenwen.blog.mapper.ResArticleClassifyMapper;
import com.wenwen.blog.service.IResArticleClassifyService;
import com.wenwen.blog.util.response.ResponseListBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-09
 */
@Service
public class ResArticleClassifyServiceImpl extends ServiceImpl<ResArticleClassifyMapper, ResArticleClassify> implements IResArticleClassifyService {
    @Autowired
    ResArticleClassifyMapper resArticleClassifyMapper;

    @Override
    public ResponseListBase<Article> listArticleFromClassifyId(Integer classifyId, Integer userId) {
        ResponseListBase<Article> response = new ResponseListBase<>();

        resArticleClassifyMapper.listArticleFromClassifyId( classifyId, userId);
        return response;
    }
}
