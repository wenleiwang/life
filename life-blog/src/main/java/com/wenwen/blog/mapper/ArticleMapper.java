package com.wenwen.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.response.ArticleResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-05
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    List<ArticleResponse> listSearchOfName(@Param("userId")Integer userId, @Param("search") String search, @Param("classifyId") Integer classifyId, @Param("offset") int offset, @Param("pageSize") Integer pageSize);

    int countForSearchOfName(@Param("userId")Integer userId, @Param("classifyId") Integer classifyId, @Param("search") String search);

    /**
     * 逻辑删除文章
     * @param articledId 文章主键ID
     * @return 删除状态
     */
    int deleteOne(Integer articledId);

    /**
     * 热门文章标题，TOP9，按照点赞个数star_num倒叙取前9
     * @return 热门文章标题
     */
    List<String> listTop9ArticleName();

    /**
     * 添加一条文章数据，返回主键ID
     * @param blog 文章数据
     * @return 主键ID
     */
    int addArticle(Article blog);

    /**
     * 通过文章ID获取文章详情
     * @param articledId 文章ID
     * @return 文章详情
     */
    ArticleResponse getArticle(Integer articledId);

    /**
     * 定时同步任务，每5分钟获取一次全量文章ID，去Redis同步浏览量
     * @return 所有的文章ID
     */
    List<Integer> listAllArticleId();

    /**
     * 新增浏览数
     * @param articledId 文章ID
     * @param viewCount 新增数量
     * @return 操作条数
     */
    int addView(@Param("articledId") Integer articledId, @Param("viewCount") int viewCount);
}
