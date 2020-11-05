package com.wenwen.blog.util.response;



import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/
public class ResponseBaseTest {
    @Test
    @DisplayName("测试断言，是否相等")
    public void responseBaseTest(){
        ResponseBase response = new ResponseBase();
        final ResponseBase successful = response.successful();

//        assertTrue("{\"Result\":1,\"Message\":\"SUCCESS\"}".equals(json));
        try {
            //第三个字段的含义是是否是严格的
            //虽然设置了不严格，但是key还是要相等的
            JSONAssert.assertEquals("{\"result\":1,\"message\":\"SUCCESS\"}","{\"Result\":1,\"Message\":\"SUCCESS\"}",false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
