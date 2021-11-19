package learn.JDKCode.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author WangWenLei
 * @DATE: 2021/3/1
 **/
public class GroupBy {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student("wwl","北京","公司1");
        Student s2 = new Student("wwl2","北京","公司2");
        Student s3 = new Student("wwl3","深圳","公司1");
        Student s4 = new Student("wwl4","深圳","公司3");
        Student s5 = new Student("wwl5","北京","公司1");
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        // 先按城市排序，再按公司排序
        Map<String, Long> collect = list.stream()
                // 中间用“_”隔开
                .collect(Collectors.groupingBy(o -> o.getCity() + "_" + o.getCompany(), Collectors.counting()));

        // 取数据
        List<DataInfo> countRecords = collect.keySet().stream().map(key -> {
            String[] temp = key.split("_");
            String cityName = temp[0];
            String company = temp[1];

            DataInfo record = new DataInfo();
            // 分组条件1
            record.setCity(cityName);
            // 分组条件2
            record.setCompany(company);
            // 统计的数量
            record.setCount(collect.get(key).intValue());
            return record;
        }).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(countRecords);
    }
}
