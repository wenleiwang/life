package com.wenwen.blog.service.impl;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.request.ArticleRequest;
import com.wenwen.blog.mapper.ArticleMapper;
import com.wenwen.blog.service.IAdminArticleService;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseListBase;
import com.wenwen.common.context.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author WangWenLei
 * @DATE: 2020/11/6
 **/
@Service
public class AdminArticleService implements IAdminArticleService {
    @Autowired
    ArticleMapper articleMapper;

    /**
     * 添加或更新文章，如果有id则更新文章，如果没有id则添加新建文章
     * @param article 文章对象
     * @param userContext
     * @return 是否成功
     */
    @Override
    public ResponseBase updateArticle(ArticleRequest article, UserInfo userContext) {
        Article blog = new Article();
        Date date = new Date();
        blog.setArticleName(article.getArticleName());
        blog.setArticleBody(article.getArticleBody());
        blog.setArticleDescription(article.getArticleDescription());
        blog.setArticleFlag(article.getArticleFlag());
        blog.setArticleImgUrl(article.getArticleImgUrl());
        blog.setCollectNum(article.getArticleFlag());
        blog.setStarStatus(article.getStarStatus());
        blog.setCollectStatus(article.getCollectStatus());
        blog.setCommentStatus(article.getCommentStatus());
        blog.setUserId(userContext.getUserId());
        if(article.getArticleId() == null ){
            // 插入文章
            blog.setAddTime(date);
            blog.setUpdateTime(date);
            blog.setCommentNum(0);
            blog.setCollectNum(0);
            blog.setStarNum(0);
            blog.setDeleted(false);
            int insert = articleMapper.insert(blog);
            if(insert > 0){
                return new ResponseBase().successful("插入文章成功！");
            }else{
                return new ResponseBase().fail("插入文章异常，操作数据库失败！");
            }
        }else{
            // 修改文章
            blog.setArticleId(article.getArticleId());
            blog.setUpdateTime(date);
            int insert = articleMapper.updateById(blog);
            if(insert > 0){
                return new ResponseBase().successful("更新文章成功！");
            }else{
                return new ResponseBase().fail("更新文章异常，操作数据库失败！");
            }
        }
    }

    @Override
    public ResponseListBase<Article> listArticle(String search, Integer pageNum, Integer pageSize, Integer userId) {
        ResponseListBase<Article> response = new ResponseListBase<>();

        if(pageSize == null || pageSize <= 0) pageSize = 10;
        if(pageNum == null || pageNum <= 0) pageNum = 1;
        if(StringUtils.isBlank(search)){
            //分页数量的全部列表
            response.setData(articleMapper.listSearchOfName(userId,null,(pageNum - 1) * pageSize, pageSize));
            response.setTotalCount(articleMapper.countForSearchOfName(userId,null));
        }else{
            //
            response.setData(articleMapper.listSearchOfName(userId,"%" + search.trim() + "%",(pageNum - 1) * pageSize, pageSize));
            response.setTotalCount(articleMapper.countForSearchOfName(userId,"%" + search.trim() + "%"));
        }
        response.successful("查询成功！");
        return response;
    }

    @Override
    public ResponseBase deleteArticle(Integer articledId) {
        ResponseBase response = new ResponseBase();
        if(articleMapper.selectById(articledId) != null){
            int flag = articleMapper.deleteOne(articledId);
            if(flag > 0){
                return response.successful("删除文章成功！");
            }else{
                return response.fail("文章删除失败，请联系管理员或重试！");
            }
        }else{
            return response.fail("此篇文章不存在！");
        }
    }
}