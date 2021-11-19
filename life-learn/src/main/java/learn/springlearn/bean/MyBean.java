package learn.springlearn.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author WangWenLei
 * @DATE: 2021/6/15
 **/
//@Component
@ConfigurationProperties("hello")
public class MyBean {
//    @Value("${hello.msg}")
    String name = "{\"code\":\"100\",\"message\":\"获取成功\",\"data\":[{\"userDataScopeID\":2809817,\"userID\":null,\"userBCID\":19850890,\"userPassportID\":123410546,\"roleID\":9,\"deptID\":512506,\"deptBCID\":18752955,\"companyID\":180761,\"companyBCID\":450309,\"bizType\":0,\"realName\":\"詹俊佶\",\"mobile\":\"158****9205\",\"displayMobile\":\"15827129205\",\"deptName\":\"武汉链家地产\",\"companyName\":\"武汉链家宏业房地产经纪有限公司\",\"companySimpleName\":\"武汉链家地产\",\"cityName\":\"武汉\",\"deptCityName\":\"武汉\",\"deptTreePath\":\"180761-512506-\",\"companyCityName\":\"武汉\",\"userPhoneEditType\":null,\"certifiedStatus\":null,\"sfbDeptID\":null,\"companyIntroduction\":null}],\"total\":null,\"success\":true}";
    String msg;
    public MyBean(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

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
