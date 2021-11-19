package learn.springlearn.bean.userxmlbean;

/**
 * 第一个XML文件格式的Bean，要使用XML文件注册这个Bean
 * @author WangWenLei
 * @DATE: 2021/4/9
 **/
public class FirstBeanXml {
    private String name;
    private String age;

    private BelongToFirst sex;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public BelongToFirst getSex() {
        return sex;
    }

    public void setSex(BelongToFirst sex) {
        this.sex = sex;
    }
}
