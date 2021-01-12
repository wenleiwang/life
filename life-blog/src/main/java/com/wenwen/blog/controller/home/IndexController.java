package com.wenwen.blog.controller.home;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.Classify;
import com.wenwen.blog.entity.User;
import com.wenwen.blog.entity.response.ArticleResponse;
import com.wenwen.blog.mapper.UserMapper;
import com.wenwen.blog.service.IIndexService;
import com.wenwen.blog.util.response.ResponseDataBase;
import com.wenwen.blog.util.response.ResponseListBase;
import com.wenwen.common.context.UserContext;
import com.wenwen.common.context.UserInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/
@RestController
public class IndexController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    IIndexService indexService;

    @GetMapping("/user")
    public String user(){
        final User user = userMapper.selectById(1);
        return "";
    }

    @ApiOperation(value = "分页文章列表包含搜索 @author 王文磊",notes = "默认第一页，20条记录")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "搜索条件",dataType = "String", example = "北京",paramType = "query",name = "cityName"),
            @ApiImplicitParam(value = "列表当前页",dataType = "int", example = "1",paramType = "query",name = "pageNum"),
            @ApiImplicitParam(value = "页大小",dataType = "int", example = "10",paramType = "query",name = "pageSize")
    })
    @GetMapping("/listArticle")
    public ResponseListBase<ArticleResponse> listArticle(@RequestParam(value = "search", required = false) String search,
                                                         @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                                         @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return indexService.listArticle(search,pageNum,pageSize);
    }

    @ApiOperation(value = "热门文章标题列表")
    @GetMapping("/listHostArticle")
    public ResponseListBase<String> listHostArticle(){
        return indexService.listHostArticle();
    }

    @ApiOperation(value = "分类列表")
    @GetMapping("/listClassify")
    public ResponseListBase<Classify> listClassify(@RequestParam("userId") Integer userId){
        return indexService.listClassify(userId);
    }

    @ApiOperation(value = "获取一条文章的详情 @author 王文磊",notes = "获取一条文章的详情")
    @ApiImplicitParam(name = "articledId", required = true, paramType = "query", value = "文章ID")
    @GetMapping("/getArticle")
    public ResponseDataBase<ArticleResponse> getArticle(@RequestParam("articleId") Integer articledId){
        return indexService.getArticle(articledId);
    }
}
