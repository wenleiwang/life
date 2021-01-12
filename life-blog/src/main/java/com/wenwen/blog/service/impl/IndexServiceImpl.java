package com.wenwen.blog.service.impl;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.Classify;
import com.wenwen.blog.entity.response.ArticleResponse;
import com.wenwen.blog.mapper.ArticleMapper;
import com.wenwen.blog.mapper.BlogResArticleTagMapper;
import com.wenwen.blog.mapper.ClassifyMapper;
import com.wenwen.blog.service.IIndexService;
import com.wenwen.blog.util.response.ResponseDataBase;
import com.wenwen.blog.util.response.ResponseListBase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页服务类
 * @author WangWenLei
 * @DATE: 2020/11/9
 **/
@Service
@Primary
public class IndexServiceImpl implements IIndexService {
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ClassifyMapper classifyMapper;

    @Autowired
    BlogResArticleTagMapper blogResArticleTagMapper;

    /**
     * 分页获取文章列表数据
     * @param search 查询条件
     * @param pageNum 当前页
     * @param pageSize 页大小
     * @return 符合条件的列表
     */
    @Override
    public ResponseListBase<ArticleResponse> listArticle(String search, Integer pageNum, Integer pageSize) {
        ResponseListBase<ArticleResponse> response = new ResponseListBase<>();

        if(pageSize == null || pageSize <= 0) pageSize = 10;
        if(pageNum == null || pageNum <= 0) pageNum = 1;

        List<ArticleResponse> articles = new ArrayList<>();
        int total = 0;
        if(StringUtils.isBlank(search)){
            //分页数量的全部列表
            articles = articleMapper.listSearchOfName(null, null, (pageNum - 1) * pageSize, pageSize);
            total =  articleMapper.countForSearchOfName(null, null);

        }else{
            articles = articleMapper.listSearchOfName(null,"%" + search.trim() + "%",(pageNum - 1) * pageSize, pageSize);
            total =  articleMapper.countForSearchOfName(null,"%" + search.trim() + "%");
        }
        for(ArticleResponse item : articles){
            List<Integer> oldClassifyList = blogResArticleTagMapper.listTagByArticleId(item.getArticleId());
            item.setTagIdList(oldClassifyList);
        }
        response.setData(articles);
        response.setTotalCount(total);
        response.successful("查询成功！");
        return response;
    }

    @Override
    public ResponseListBase<String> listHostArticle() {
        ResponseListBase<String> response = new ResponseListBase<>();
        List<String> list = articleMapper.listTop9ArticleName();
        if(list != null){
            response.setData(list);
            response.successful("获取数据成功！");
        }else{
            response.setData(new ArrayList<>());
            response.successful("数据库获取数据失败！");
        }
        return response;
    }

    @Override
    public ResponseListBase<Classify> listClassify(Integer userId) {
        ResponseListBase<Classify> response = new ResponseListBase<>();
        List<Classify> list = classifyMapper.listClassifyByUserId(userId);
        if(list != null){
            response.setData(list);
            response.successful("获取数据成功！");
        }else{
            response.setData(new ArrayList<>());
            response.successful("数据库获取数据失败！");
        }
        return response;
    }

    @Override
    public ResponseDataBase<ArticleResponse> getArticle(Integer articledId) {
        ResponseDataBase<ArticleResponse> response = new ResponseDataBase<>();
        if(articledId <= 0 ){
            response.fail("文章ID非法！");
            return response;
        }
        ArticleResponse article = articleMapper.getArticle(articledId);
        article.setTagIdList(blogResArticleTagMapper.listTagByArticleId(article.getArticleId()));
        response.setData(article);
        response.successful("获取文章成功！");
        return response;
    }
}
