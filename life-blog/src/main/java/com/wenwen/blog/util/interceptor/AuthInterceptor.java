package com.wenwen.blog.util.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(LOGGER.isDebugEnabled()){
            LOGGER.info("进入拦截器！");
        }
        return true;
    }
}
