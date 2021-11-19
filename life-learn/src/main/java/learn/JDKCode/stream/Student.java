package learn.JDKCode.stream;

import lombok.Data;

/**
 * @author WangWenLei
 * @DATE: 2021/3/1
 **/
@Data
public class Student {
    private String name;
    private String city;
    private String company;

    public Student(String name, String city, String company) {
        this.name = name;
        this.city = city;
        this.company = company;
    }
}
