package com.wenwen.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.ResArticleClassify;
import com.wenwen.blog.entity.request.ArticleRequest;
import com.wenwen.blog.mapper.ArticleMapper;
import com.wenwen.blog.mapper.ClassifyMapper;
import com.wenwen.blog.mapper.ResArticleClassifyMapper;
import com.wenwen.blog.service.IAdminArticleService;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseDataBase;
import com.wenwen.blog.util.response.ResponseListBase;
import com.wenwen.common.context.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    ResArticleClassifyMapper resArticleClassifyMapper;

    @Autowired
    ClassifyMapper classifyMapper;

    /**
     * 添加或更新文章，如果有id则更新文章，如果没有id则添加新建文章
     * @param article 文章对象
     * @param userContext
     * @return 是否成功
     */
    @Override
    public ResponseDataBase<Integer> updateArticle(ArticleRequest article, UserInfo userContext) {
        ResponseDataBase<Integer> response = new ResponseDataBase<>();
        Article blog = new Article();
        Date date = new Date();
        //处理判断为空
        if(StringUtils.isBlank(article.getArticleBody())){
            response.fail("文章不能为空！");
            response.setData(0);
            return response;
        }
        if(StringUtils.isBlank(article.getArticleName())){
            response.fail("文章不能没有标题！");
            return response;
        }
        if(article.getArticleFlag() != null && article.getArticleFlag() != 0 && article.getArticleFlag() != 1 && article.getArticleFlag() != 2){
            response.fail("没给文章标志，原创、转载还是翻译啊？");
            return response;
        }
        if(StringUtils.isBlank(article.getArticleImgUrl())){
            article.setArticleImgUrl("");
        }
        blog.setArticleName(article.getArticleName());
        blog.setArticleBody(article.getArticleBody());
        if(StringUtils.isBlank(article.getArticleDescription())){
            if(article.getArticleBody().length() <= 100){
                blog.setArticleDescription(article.getArticleBody());
            }else{
                blog.setArticleDescription(article.getArticleBody().substring(0,100));
            }
        }
        blog.setArticleFlag(article.getArticleFlag());
        blog.setArticleImgUrl(article.getArticleImgUrl());
        blog.setStarStatus(article.getStarStatus());
        blog.setCollectStatus(article.getCollectStatus());
        blog.setCommentStatus(article.getCommentStatus());
        blog.setUserId(userContext.getUserId());
        if(article.getArticleId() == null || article.getArticleId() <= 0){
            if(article.getDeleted() != null && article.getDeleted() != 0 && article.getDeleted() != 1 && article.getDeleted() != 2){
                response.fail("文章状态不能为空！");
                return response;
            }
            // 插入文章
            blog.setAddTime(date);
            blog.setUpdateTime(date);
            blog.setCommentNum(0);
            blog.setCollectNum(0);
            blog.setStarNum(0);
            blog.setDeleted(article.getDeleted());
            int insert = articleMapper.addArticle(blog);
            // 插入分类
            if(article.getClassifyIdList() != null && article.getClassifyIdList().size() > 0){
                Date now = new Date();
                List<ResArticleClassify> resList = new ArrayList<>();
                for(Integer item : article.getClassifyIdList()){
                    ResArticleClassify res = new ResArticleClassify();
                    res.setAddTime(now);
                    res.setUpdateTime(now);
                    res.setArticleId(blog.getArticleId());
                    res.setClassifyId(item);
                    res.setDeleted(false);
                    resList.add(res);
                }
                resArticleClassifyMapper.insertList(resList);
            }

            if(insert > 0){
                response.successful("插入文章成功！");
                response.setData(blog.getArticleId());
                return response;
            }else{
                response.fail("插入文章异常，操作数据库失败！");
                return response;
            }
        }else{
            // TODO 判断是否存在
            //修改分类
            List<Integer> newClassifyList = article.getClassifyIdList();
            //得到现在的分类
            List<Integer> oldClassifyList = resArticleClassifyMapper.listClassifyByArticleId(article.getArticleId());
            List<Integer> deleteList = new ArrayList<>();
            List<Integer> addList = new ArrayList<>();

            if(oldClassifyList != null){
                for(Integer item : newClassifyList){
                    if(!oldClassifyList.contains(item)){
                        //新分类不在这个用户的分类中
                        addList.add(item);
                    }
                }
                for(Integer item : oldClassifyList){
                    if(!newClassifyList.contains(item)){
                        deleteList.add(item);
                    }
                }
            }
            if(deleteList.size() > 0){
                //删除，转换成(1,2,3)
                resArticleClassifyMapper.delete(new QueryWrapper<ResArticleClassify>().in("classify_id",deleteList));
            }
            if(addList.size() > 0){
                //批量新增，sql转换成(1,2,3)
                List<ResArticleClassify> resList = new ArrayList<>();
                Date now = new Date();
                for(Integer item : addList){
                    ResArticleClassify res = new ResArticleClassify();
                    res.setAddTime(now);
                    res.setUpdateTime(now);
                    res.setArticleId(article.getArticleId());
                    res.setClassifyId(item);
                    res.setDeleted(false);
                    resList.add(res);
                }
                resArticleClassifyMapper.insertList(resList);
            }

            // 修改文章
            blog.setArticleId(article.getArticleId());
            blog.setUpdateTime(date);
            int insert = articleMapper.updateById(blog);
            if(insert > 0){
                response.successful("更新文章成功！");
                response.setData(article.getArticleId());
                return response;
            }else{
                response.fail("更新文章异常，操作数据库失败！");
                return response;
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
            //同时要删除它分类的关联关系，所有
             QueryWrapper<ResArticleClassify> query = new QueryWrapper<>();
            query.eq("article_id",articledId);
            resArticleClassifyMapper.delete(query);
            if(flag > 0){
                return response.successful("删除文章成功！");
            }else{
                return response.fail("文章删除失败，请联系管理员或重试！");
            }
        }else{
            return response.fail("此篇文章不存在！");
        }
    }

    @Override
    public ResponseDataBase<Article> getArticle(Integer articledId) {
        ResponseDataBase<Article> response = new ResponseDataBase<>();
        if(articledId <= 0 ){
            response.fail("文章ID非法！");
            return response;
        }
        response.setData(articleMapper.getArticle(articledId));
        response.successful("获取文章成功！");
        return response;
    }
}
