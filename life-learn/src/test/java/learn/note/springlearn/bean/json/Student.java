package learn.note.springlearn.bean.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author Wang WenLei
 * @Date 2022/1/24 21:52
 * @Version 1.0
 **/
@ToString
@Data
public class Student {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    private Integer age;
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;
//    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private LocalDateTime astart;
}
