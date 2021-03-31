package com.wenwen.blog.controller.home;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.Classify;
import com.wenwen.blog.entity.User;
import com.wenwen.blog.entity.response.ArticleInClassifyResponse;
import com.wenwen.blog.entity.response.ArticleResponse;
import com.wenwen.blog.mapper.UserMapper;
import com.wenwen.blog.service.IIndexService;
import com.wenwen.blog.util.response.ResponseBase;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
    public String user(HttpServletResponse response){
        final User user = userMapper.selectById(1);
//        Encode.forHtml("w偶尔金佛安加尔瓦");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write("w偶尔金佛安加尔瓦");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    @GetMapping("/test")
    public String test(){
        return "测试成功！";
    }

    @ApiOperation(value = "分页文章列表包含搜索 @author 王文磊",notes = "默认第一页，20条记录")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "搜索条件",dataType = "String", example = "北京",paramType = "query",name = "search"),
            @ApiImplicitParam(value = "classifyId",dataType = "int", example = "1",paramType = "query",name = "classifyId"),
            @ApiImplicitParam(value = "列表当前页",dataType = "int", example = "1",paramType = "query",name = "pageNum"),
            @ApiImplicitParam(value = "页大小",dataType = "int", example = "10",paramType = "query",name = "pageSize")
    })
    @GetMapping("/listArticle")
    public ResponseListBase<ArticleResponse> listArticle(@RequestParam(value = "search", required = false) String search,
                                                         @RequestParam(value = "classifyId", required = false) Integer classifyId,
                                                         @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                                         @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return indexService.listArticle(search,classifyId,pageNum,pageSize);
    }

    @ApiOperation(value = "热门文章标题列表")
    @GetMapping("/listHostArticle")
    public ResponseListBase<String> listHostArticle(){
        return indexService.listHostArticle();
    }

    @ApiOperation(value = "分类列表")
    @GetMapping("/listClassify")
    public ResponseListBase<Classify> listClassify(@RequestParam(value = "userId",required = false) Integer userId){
        return indexService.listClassify(userId);
    }

    @ApiOperation(value = "分类列表带文章列表")
    @GetMapping("/listArticleInClassify")
    public ResponseListBase<ArticleInClassifyResponse> listArticleInClassify(@RequestParam(value = "userId",required = false) Integer userId){
        return indexService.listArticleInClassify(userId);
    }

    @ApiOperation(value = "获取一条文章的详情 @author 王文磊",notes = "获取一条文章的详情")
    @ApiImplicitParams({@ApiImplicitParam(name = "文章ID", required = true, paramType = "query", value = "articledId",dataType = "int")})
    @GetMapping("/getArticle")
    public ResponseDataBase<ArticleResponse> getArticle(@RequestParam("articleId") Integer articledId){
        return indexService.getArticle(articledId);
    }

    @ApiOperation(value = "给一个文章添加浏览数 @author 王文磊",notes = "高并发给文章添加浏览数")
    @ApiImplicitParams({@ApiImplicitParam(name = "articledId", required = true, paramType = "query", value = "文章ID",dataType = "int")})
    @GetMapping("/addView")
    public ResponseBase addView(@RequestParam(value = "articledId") Integer articledId,HttpServletRequest request){
        String ipAddress = getIpAddress(request);
        return indexService.addView(articledId,ipAddress);
    }

    private static String getIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    ipAddress = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }

            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}
