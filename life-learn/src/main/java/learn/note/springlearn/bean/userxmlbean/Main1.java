package learn.note.springlearn.bean.userxmlbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangWenLei
 * @DATE: 2021/11/19
 **/
@Configuration
public class Main1 {
    @Bean
    public FirstBeanXml firstBeanXml(){
        FirstBeanXml data = new FirstBeanXml();
        data.setAge("25");
        data.setName("wwlBean");
        BelongToFirst boy = new BelongToFirst();
        boy.setSex("boy");
        data.setSex(boy);
        return data;
    }
}
