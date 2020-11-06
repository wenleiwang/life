package com.wenwen.common.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 根据学习，自己编写JSON工具类
 * @author WangWenLei
 * @DATE: 2020/11/6
 **/
public class ToolJson {
    private static ObjectMapper mapper = new ObjectMapper();
    private static JsonFactory jsonF = new JsonFactory();


    static {
        //意思是一旦名字字符串从输入（字节或字符流）被解码，它将被添加到一个符号表中，以减少在下次看到同一名字时被解码的开销（由同一工厂构造的任何解析器）
        jsonF.enable(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES);
    }

    /**
     * 传入对象变成JSON的String类型
     * 这里用了一个泛型哎，在返回类型之前，我就可以使用这个泛型作为虚参的类型了。
     * @param mode 对象
     * @return String类型的
     */
    public static <T> String writeValue(T mode){
        if(mode == null){
            return "{}";
        }
        try {
            return mapper.writeValueAsString(mode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
