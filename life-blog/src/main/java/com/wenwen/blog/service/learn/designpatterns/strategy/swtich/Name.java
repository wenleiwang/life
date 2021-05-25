package com.wenwen.blog.service.learn.designpatterns.strategy.swtich;

/**
 * 名字和策略
 * @author WangWenLei
 */
public enum Name {
    /**
     * 全部的策略枚举
     */
    LI_SI("lisi","com.wenwen.blog.service.learn.designpatterns.strategy.swtich.LiSiDo"),
    WANG_WU("wangwu","com.wenwen.blog.service.learn.designpatterns.strategy.swtich.WangWuDo"),
    ZHANG_SAN("zhangsan","com.wenwen.blog.service.learn.designpatterns.strategy.swtich.ZhangSanDo");

    /**
     * 姓名
     */
    private String name;
    /**
     * 策略对应全限定名
     */
    private String packageName;

    Name(String name, String packageName) {
        this.name = name;
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
