package com.wenwen.blog.controller.admin;

import com.wenwen.blog.entity.request.ArticleRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/test")
    public String test(){
        return "测试拦截器！";
    }

    @ApiOperation(value = "管理员添加或修改文章 @author 王文磊",notes = "添加和修改使用一个接口")
    @PostMapping("/updateArticle")
    public String updateArticle(@RequestParam("article")ArticleRequest article){
        return "";
    }
}
