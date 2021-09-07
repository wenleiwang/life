package com.wenwen.blog.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.wenwen.blog.entity.Classify;
import com.wenwen.blog.entity.response.ArticleInClassifyResponse;
import com.wenwen.blog.entity.response.ArticleInfo;
import com.wenwen.blog.entity.response.ArticleResponse;
import com.wenwen.blog.mapper.ArticleMapper;
import com.wenwen.blog.mapper.BlogResArticleTagMapper;
import com.wenwen.blog.mapper.ClassifyMapper;
import com.wenwen.blog.service.IIndexService;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseDataBase;
import com.wenwen.blog.util.response.ResponseListBase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    ThreadPoolTaskExecutor threadPool;

    private final Cache<String, SoftReference<Object>> localCache = CacheBuilder.newBuilder()
            //设置cache的初始大小为10，要合理设置该值
            .initialCapacity(50)
            //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
            .concurrencyLevel(5)
            //设置cache中的数据在写入之后的存活时间为3
            .expireAfterWrite(60, TimeUnit.SECONDS)
            //构建cache实例
            .build();


    /**
     * 分页获取文章列表数据
     * @param search 查询条件
     * @param pageNum 当前页
     * @param pageSize 页大小
     * @return 符合条件的列表
     */
    @Override
    public ResponseListBase<ArticleResponse> listArticle(String search,Integer classifyId, Integer pageNum, Integer pageSize) {
        ResponseListBase<ArticleResponse> response = new ResponseListBase<>();

        if(pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        if(pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }

        List<ArticleResponse> articles = new ArrayList<>();
        int total = 0;
        if(StringUtils.isBlank(search)){
            //分页数量的全部列表
            articles = articleMapper.listSearchOfName(null, null,classifyId,
                    (pageNum - 1) * pageSize, pageSize);
            total =  articleMapper.countForSearchOfName(null,classifyId, null);

        }else{
            articles = articleMapper.listSearchOfName(null,"%" + search.trim() + "%",
                    classifyId,(pageNum - 1) * pageSize, pageSize);
            total =  articleMapper.countForSearchOfName(null,classifyId,"%" + search.trim() + "%");
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

    /**
     * 如果要满足高并发，那首先考虑用异步和缓存。
     * 暂时把增加的浏览量(假设某篇文章为n)放进Redis里，然后每隔一段时间刷新到Mysql数据库
     * @param articledId 文章ID
     * @return 响应状态
     */
    @Override
    public ResponseBase addView(Integer articledId,String ipAddress) {
        ResponseBase response = new ResponseBase();
        // 1.开启线程
        Runnable runnable = () -> {
            String ipInRedis = "isViewd:" + articledId + ":" + ipAddress;
            SoftReference<Object> ifPresent = localCache.getIfPresent(ipInRedis);
            if(ifPresent == null || ifPresent.get() != null){
                articleMapper.addView(articledId,1);
            }
        };
        threadPool.execute(runnable);
        response.successful("200");
        return response;
    }

    @Override
    public ResponseListBase<ArticleInClassifyResponse> listArticleInClassify(Integer userId) {
        ResponseListBase<ArticleInClassifyResponse> response = new ResponseListBase<>();
        List<Classify> list = classifyMapper.listClassifyByUserId(userId);
        List<ArticleInClassifyResponse> responseList = new ArrayList<>();
        list.forEach(item -> {
            ArticleInClassifyResponse info = new ArticleInClassifyResponse();
            info.setClassifyId(item.getClassifyId());
            info.setClassifyName(item.getClassifyName());
            info.setUpdateTime(item.getUpdateTime());
            info.setUserId(item.getUserId());
            List<ArticleInfo> articles = classifyMapper.listArticleFromClassifyId(item.getClassifyId());
            articles.forEach(aitem -> aitem.setIndex(item.getClassifyId() + "-" + aitem.getArticleId()));
            info.setListArticle(articles);
            responseList.add(info);
        });
        response.setData(responseList);
        response.successful("数据获取成功！");
        return response;
    }
}
