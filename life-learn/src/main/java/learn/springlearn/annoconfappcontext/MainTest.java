package learn.springlearn.annoconfappcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author WangWenLei
 * @DATE: 2020/11/4
 **/
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class,Dependency1.class);
        MyService myService = cxt.getBean(MyService.class);
        myService.helloSpring();
    }
}
