package learn.note.springlearn.bean.redis;

import com.alibaba.fastjson.JSON;
import learn.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Wang WenLei
 * @Date 2022/1/22 11:47
 * @Version 1.0
 **/
@SpringBootTest
class SetString {
    @Autowired
    RedisUtil redisUtil;
    @Test
    void setString(){

//        Map<String,String> map = new HashMap<>();
//        map.put("jK1", "v1");
//        map.put("jK2", "v2");
//        map.put("jK3", "v3");
//        redisUtil.mSet(map);
//        redisUtil.del("jK1","jK2","jK3");
//        List<String> keys = new ArrayList<>();
//        keys.add("jK1");
//        keys.add("jK2");
//        keys.add("jK3");
//        List<Object> objects = redisUtil.mGet(keys);
//        for (int i = 0 ; i < objects.size() ; i++) {
//            System.out.println((String)objects.get(i));
//        }
        redisUtil.set("kk1","vv1",5L);
    }
}
