package learn.note.springlearn.annoconfappcontext.register;

import learn.note.springlearn.annoconfappcontext.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过编程方式构建容器
 * @author WangWenLei
 * @DATE: 2020/11/4
 **/
public class MainTest {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.wenwen.life_blog.service.learn.note.springlearn");
        ctx.refresh();
        MyService myService = ctx.getBean(MyService.class);
        myService.helloSpring();
    }
}
