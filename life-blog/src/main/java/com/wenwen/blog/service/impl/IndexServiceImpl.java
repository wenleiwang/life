package com.wenwen.blog.service.impl;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.mapper.ArticleMapper;
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

    /**
     * 分页获取文章列表数据
     * @param search 查询条件
     * @param pageNum 当前页
     * @param pageSize 页大小
     * @return 符合条件的列表
     */
    @Override
    public ResponseListBase<Article> listArticle(String search, Integer pageNum, Integer pageSize) {
        ResponseListBase<Article> response = new ResponseListBase<>();

        if(pageSize == null || pageSize <= 0) pageSize = 10;
        if(pageNum == null || pageNum <= 0) pageNum = 1;
        if(StringUtils.isBlank(search)){
            //分页数量的全部列表
            response.setData(articleMapper.listSearchOfName(null,null,(pageNum - 1) * pageSize, pageSize));
            response.setTotalCount(articleMapper.countForSearchOfName(null,null));
        }else{
            //
            response.setData(articleMapper.listSearchOfName(null,"%" + search.trim() + "%",(pageNum - 1) * pageSize, pageSize));
            response.setTotalCount(articleMapper.countForSearchOfName(null,"%" + search.trim() + "%"));
        }
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
    public ResponseListBase<String> listClassify(Integer userId) {
        ResponseListBase<String> response = new ResponseListBase<>();
        List<String> list = classifyMapper.listClassifyByUserId(userId);
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
