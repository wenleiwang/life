package com.wenwen.blog.controller.admin;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.Classify;
import com.wenwen.blog.service.IClassifyService;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseListBase;
import com.wenwen.common.context.UserContext;
import com.wenwen.common.context.UserInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分类的增删改查
 * @author WangWenLei
 * @DATE: 2020/11/9
 **/
@RestController
@RequestMapping("/admin")
public class AdminClassifyController {
    @Autowired
    IClassifyService classifyService;

    @ApiOperation(value = "获取该用户全部分类")
    @GetMapping("/listClassify")
    public ResponseListBase<Classify> listClassify(){
        final UserInfo userContext = UserContext.getUserContext();
        if(userContext == null){
            ResponseListBase<Classify> response = new ResponseListBase<>();
            response.fail("请重新登录");
            return response;
        }
        return classifyService.listClassify(userContext.getUserId());
    }

    @ApiOperation(value = "用户更新/添加分类")
    @GetMapping("/updateClassify")
    public ResponseBase updateClassify(@RequestParam("classifyName") String classifyName,@RequestParam(name = "classifyId", required = false) Integer classifyId){
        final UserInfo userContext = UserContext.getUserContext();
        if(userContext == null){
            ResponseBase response = new ResponseBase();
            response.fail("请重新登录");
            return response;
        }
        return classifyService.updateClassify(classifyId, userContext.getUserId(),classifyName);
    }

    @ApiOperation(value = "用户删除分类")
    @GetMapping("/deleteClassify")
    public ResponseBase deleteClassify(@RequestParam(name = "classifyId", required = false) Integer classifyId){
        final UserInfo userContext = UserContext.getUserContext();
        if(userContext == null){
            ResponseBase response = new ResponseBase();
            response.fail("请重新登录");
            return response;
        }
        return classifyService.deleteClassify(classifyId);
    }
}
