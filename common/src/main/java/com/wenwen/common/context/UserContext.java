package com.wenwen.common.context;

/**
 * 用户上下文
 * @author WangWenLei
 * @DATE: 2020/11/6
 **/
public class UserContext {
    private static final ThreadLocal<UserInfo> userContext = new ThreadLocal<>();

    public static UserInfo getUserContext() {
        return userContext.get();
    }

    public static void setUserContext(UserInfo userInfo){
        userContext.set(userInfo);
    }

    public static void clear(){
        userContext.remove();
    }
}
