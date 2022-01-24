package learn.note.springlearn.bean.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author Wang WenLei
 * @Date 2022/1/24 21:55
 * @Version 1.0
 **/
public class JasksonTest {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        // 设置JSON包含
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        objectMapper.findAndRegisterModules();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")));
//        // 反序列化时使用
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")));
//        // 序列化时使用

        objectMapper.registerModule(javaTimeModule);
        // 美化输出
//        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        // 反序列化时忽略不存在的key
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);
        // 蛇形命名法
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }
    @Test
    void jasksonTest() throws JsonProcessingException {
        Student student = new Student();
        student.setAge(20);
        student.setBirthday(new Date());
        student.setAstart(LocalDateTime.now());
        ResponseDataBase<Student> response = new ResponseDataBase<>();
        response.setData(student);
        response.successful();
        String data = objectMapper.writeValueAsString(response);
        System.out.println(data);
        ResponseDataBase<Student> dataResult = objectMapper.readValue(data, new TypeReference<ResponseDataBase<Student>>() {
        });
        System.out.println(dataResult.getData().toString());
    }
    @Test
    void jasksonTest2() throws JsonProcessingException {
        Student orgUser = new Student();
        orgUser.setName("user1");
        orgUser.setAge(20);
        orgUser.setBirthday(new Date());

        Student newUser = new Student();
        newUser.setName("user1");
        newUser.setAge(22);

        Student student = objectMapper.updateValue(orgUser, newUser);
        System.out.println(student.toString());
    }
}
