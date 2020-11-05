package com.wenwen.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1.文章列表
 * 2.添加文章
 * 3.
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/
@RestController
public class AdminArticleController {

    @GetMapping("/test")
    public String test(){
        return "测试拦截器！";
    }
}
