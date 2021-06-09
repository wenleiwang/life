package com.wenwen.blog.tasks.Service;

import com.wenwen.blog.mapper.ArticleMapper;
import com.wenwen.blog.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangWenLei
 * @DATE: 2021/3/22
 **/
@Service
public class SyncArticleViewCountService {

    private final Logger logger = LoggerFactory.getLogger(SyncArticleViewCountService.class);
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    RedisUtil redisUtil;

    /**
     * 每5分钟同步一次浏览数
     */
    public void syncArticleViewCountService(){
        List<Integer> list = articleMapper.listAllArticleId();

        list.forEach(item -> {
            if(redisUtil.hasKey("viewCount:" + item)){
                int o =(int) redisUtil.get("viewCount:" + item);
                if(o != 0){
                    redisUtil.decr("viewCount:" + item ,o);
                    articleMapper.addView(item,o);
                }
            }
        });
        logger.info("完成一次浏览数据同步");
    }
}
