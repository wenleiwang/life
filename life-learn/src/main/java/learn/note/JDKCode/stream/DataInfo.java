package learn.note.JDKCode.stream;

import lombok.Data;

/**
 * @author WangWenLei
 * @DATE: 2021/3/1
 **/
@Data
public class DataInfo {
    private String city;
    private String company;
    private int count;


    @Override
    public String toString() {
        return "DataInfo{" +
                "city='" + city + '\'' +
                ", company='" + company + '\'' +
                ", count=" + count +
                '}' + "\n";
    }
}
