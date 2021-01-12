package com.wenwen.blog.controller.admin;


import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.Classify;
import com.wenwen.blog.entity.Tag;
import com.wenwen.blog.service.impl.BlogResArticleTagServiceImpl;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseListBase;
import com.wenwen.common.context.UserContext;
import com.wenwen.common.context.UserInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WenleiWang
 * @since 2021-01-12
 */
@RestController
@RequestMapping("/admin")
public class BlogResArticleTagController {
    @Autowired
    BlogResArticleTagServiceImpl blogResArticleTagService;

    @ApiOperation(value = "通过分类ID查用户文章 @author 王文磊",notes = "通过分类ID查用户文章")
    @PostMapping("/listTagNameByTagId")
    public ResponseListBase<Tag> listArticleFromClassifyId(@RequestBody List<Integer> listTagId){
        UserInfo userInfo= UserContext.getUserContext();
        return blogResArticleTagService.listTagNameByTagId(listTagId,userInfo.getUserId());
    }

    @ApiOperation(value = "获取该用户全部分类")
    @GetMapping("/listTag")
    public ResponseListBase<Tag> listClassify(){
        final UserInfo userContext = UserContext.getUserContext();
        if(userContext == null){
            ResponseListBase<Tag> response = new ResponseListBase<>();
            response.fail("请重新登录");
            return response;
        }
        return blogResArticleTagService.listTag(userContext.getUserId());
    }

    @ApiOperation(value = "用户更新/添加分类")
    @GetMapping("/updateTag")
    public ResponseBase updateTag(@RequestParam("tagName") String tagName, @RequestParam(name = "tagId", required = false) Integer tagId){
        final UserInfo userContext = UserContext.getUserContext();
        if(userContext == null){
            ResponseBase response = new ResponseBase();
            response.fail("请重新登录");
            return response;
        }
        return blogResArticleTagService.updateTag(tagId, userContext.getUserId(),tagName);
    }
}
