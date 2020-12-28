package com.wenwen.blog.service.learn.ANNOTATIONS.start;

import lombok.var;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author WangWenLei
 * @DATE: 2020/12/14
 **/
public class InitProcessor {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.wenwen.blog.service.learn.ANNOTATIONS.start.InitDemo");
        Method[] methods = clazz.getMethods();
        if(methods != null){
            for(Method method : methods){
                boolean isInitMethod = method.isAnnotationPresent(InitMethod.class);
                if(isInitMethod){
                    method.invoke(clazz.newInstance(),null);
                }
            }
        }
    }
}
