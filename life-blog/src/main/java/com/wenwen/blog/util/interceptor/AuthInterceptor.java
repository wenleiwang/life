package com.wenwen.blog.util.interceptor;


import com.wenwen.blog.entity.User;
import com.wenwen.blog.mapper.UserMapper;
import com.wenwen.blog.util.EnDecoderUtil;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.common.context.UserContext;
import com.wenwen.common.context.UserInfo;
import com.wenwen.common.util.ToolJson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 拦截器实现类
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);

    @Autowired
    UserMapper userMapper;

    /**
     * 拦截获取用户信息
     * @param request 请求
     * @param response 响应
     * @param handler 请求头
     * @return 是否继续
     * @throws Exception 错误
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(LOGGER.isDebugEnabled()){
            LOGGER.info("进入拦截器！");
        }

        //声明用户id
        final Cookie[] cookies = request.getCookies();
        String whyDoYouKnow = request.getHeader("Authorization");
        // 把cookie换成Authorization
//        for(Cookie item : cookies){
//            if("why_do_you_know".equals(item.getName())){
//                whyDoYouKnow = item.getValue();
//            }
//        }
        if(whyDoYouKnow == null){
            ResponseBase responseBase = new ResponseBase();
            responseBase.fail("用户未登录，请重新登录！");
            String sr = ToolJson.writeValue(responseBase);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(sr);
            writer.close();
            response.flushBuffer();
            return false;
        }
        UserInfo userInfo = null;
        if(StringUtils.isNotBlank(whyDoYouKnow)){
            String s = whyDoYouKnow.split("_")[0];
            String userId = EnDecoderUtil.AESDecrypt(s);
            final Integer integer = Integer.valueOf(userId);
            User user = userMapper.selectById(Integer.valueOf(userId));
           if(user == null){
               ResponseBase responseBase = new ResponseBase();
               responseBase.fail("用户不存在，请重新登录！");
               String sr = ToolJson.writeValue(responseBase);
               response.setContentType("application/json;charset=UTF-8");
               PrintWriter writer = response.getWriter();
               writer.print(sr);
               writer.close();
               response.flushBuffer();
               return false;
           }
           userInfo = new UserInfo();
           userInfo.setUserName(user.getUserName());
           userInfo.setUserPassword(user.getUserPassword());
           userInfo.setLoginName(user.getLoginName());
           userInfo.setRealName(user.getRealName());
           userInfo.setEmail(user.getEmail());
           userInfo.setUserAge(user.getUserAge());
           userInfo.setRealAge(user.getRealAge());
           userInfo.setUserImg(user.getUserImg());
           userInfo.setUserId(user.getUserId());
        }

        UserContext.setUserContext(userInfo);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.clear();
    }
}
