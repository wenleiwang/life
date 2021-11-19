package learn.springlearn.bean.userxmlbean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用XML文件配置Spring Bean 文件
 * @author WangWenLei
 * @DATE: 2021/4/9
 **/
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("service-learn.xml");
        // 使用getBean方法可以检索bean的实例
        final FirstBeanXml firstXml = context.getBean("firstXml", FirstBeanXml.class);
        // 因为已经配置了值，取出后直接使用
        System.out.println(firstXml.getName());
        // 试下对象里依赖另一个Bean
        System.out.println(firstXml.getSex().getSex());
    }
}
