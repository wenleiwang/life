package com.wenwen.blog.controller.admin;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.request.ArticleRequest;
import com.wenwen.blog.service.IResArticleClassifyService;
import com.wenwen.blog.service.impl.AdminArticleService;
import com.wenwen.blog.service.impl.ResArticleClassifyServiceImpl;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseListBase;
import com.wenwen.common.context.UserContext;
import com.wenwen.common.context.UserInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 1.文章列表
 * 2.添加文章
 * 3.
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/

@RestController
@RequestMapping("/admin")
public class AdminArticleController {

    @Autowired
    AdminArticleService adminArticleService;

    @Autowired
    ResArticleClassifyServiceImpl resArticleClassifyService;

    @GetMapping("/test")
    public String test(){
        return "测试拦截器！";
    }

    @ApiOperation(value = "管理员添加或修改文章 @author 王文磊",notes = "添加和修改使用一个接口")
    @PostMapping("/updateArticle")
    public ResponseBase updateArticle(@RequestBody ArticleRequest article){
        UserInfo userContext = UserContext.getUserContext();
        if(userContext == null){
            return new ResponseBase().fail("用户登录失败，请重新登录！");
        }
        return adminArticleService.updateArticle(article,userContext);
    }

    @ApiOperation(value = "分页文章列表包含搜索 @author 王文磊",notes = "默认第一页，20条记录")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "搜索条件",dataType = "String", example = "北京",paramType = "query",name = "cityName"),
            @ApiImplicitParam(value = "列表当前页",dataType = "int", example = "1",paramType = "query",name = "pageNum"),
            @ApiImplicitParam(value = "页大小",dataType = "int", example = "10",paramType = "query",name = "pageSize")
    })
    @GetMapping("/listArticle")
    public ResponseListBase<Article> listArticle(@RequestParam(value = "search", required = false) String search,
                                                 @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                                 @RequestParam(value = "pageSize", required = false) Integer pageSize){
        UserInfo userInfo= UserContext.getUserContext();
        if(userInfo == null) {
            ResponseListBase<Article> response = new ResponseListBase<>();
            response.setData(null);
            response.fail("用户信息获取失败，请重新登录！");
            return response;
        }
        return adminArticleService.listArticle(search,pageNum,pageSize,userInfo.getUserId());
    }

    @ApiOperation(value = "删除一条文章 @author 王文磊",notes = "逻辑删除文章")
    @ApiImplicitParam(name = "articledId", required = true, paramType = "query", value = "文章ID")
    @GetMapping("/deleteArticle")
    public ResponseBase deleteArticle(@RequestParam("articleId") Integer articledId){
        UserInfo userInfo= UserContext.getUserContext();
        if(userInfo == null) {
            ResponseListBase<Article> response = new ResponseListBase<>();
            response.setData(null);
            response.fail("用户信息获取失败，请重新登录！");
            return response;
        }
        return adminArticleService.deleteArticle(articledId);
    }

    @ApiOperation(value = "通过分类ID查用户文章 @author 王文磊",notes = "通过分类ID查用户文章")
    @ApiImplicitParam(name = "classifyId", required = true, paramType = "query", value = "分类ID")
    @GetMapping("/listArticleFromClassifyId")
    public ResponseListBase<Article> listArticleFromClassifyId(@RequestParam("classifyId")Integer classifyId){
        UserInfo userInfo= UserContext.getUserContext();
        return resArticleClassifyService.listArticleFromClassifyId(classifyId,userInfo.getUserId());
    }
}
