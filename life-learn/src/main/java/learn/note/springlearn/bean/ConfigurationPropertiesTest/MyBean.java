package learn.note.springlearn.bean.ConfigurationPropertiesTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author WangWenLei
 * @DATE: 2021/6/15
 **/
@Component
@ConfigurationProperties("hello")
public class MyBean {
//    @Value("${hello.name}")
    private String name;
//    @Value("${hello.msg}")
    private String msg;
//    public MyBean(String name, String msg) {
//        this.name = name;
//        this.msg = msg;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
