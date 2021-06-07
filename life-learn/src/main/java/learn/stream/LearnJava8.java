package learn.stream;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author WangWenLei
 * @DATE: 2020/10/10
 **/
public class LearnJava8 {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().map(x->x*x).forEach(System.out::println);

        List<User> userList = new ArrayList<>();
        User user1 = new User(1L,"wenwen1","password","24","wenleiwang@126.com",true);
        User user2 = new User(2L,"wenwen2","password","25","wenleiwang@126.com",false);
        userList.add(user1);
        userList.add(user2);
        //去对象中的年龄
        userList.stream().map(item -> item.getEmail()).forEach(System.out::println);

        List<String> list0 = Arrays.asList("a","","b","","cc","x","dd");
        list0.stream().filter(item -> !item.trim().isEmpty()).forEach(System.out::println);
        System.out.println("过滤前个数："+list0.size());
        System.out.println("过滤后个数："+list0.stream().filter(item -> !item.trim().isEmpty()).count());

        List<String> list1 = Arrays.asList("a","","b","","cc","x","dd");
        list1.stream().limit(3).forEach(System.out::println);

        Random random2 = new Random();
        random2.ints().limit(10).sorted().forEach(System.out::println);


        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        //每个非空字符加一个a
        List<String> collect1 = strings2.stream().filter(item -> !item.isEmpty()).map(item -> item + 'a').collect(Collectors.toList());
        System.out.println(collect1.toString());
        String collect2 = strings2.stream().filter(item -> !item.isEmpty()).collect(Collectors.joining("#"));
        System.out.println(collect2);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5,12);
        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("列表中平均数 : " + intSummaryStatistics.getAverage());
        System.out.println("列表中个数 : " + intSummaryStatistics.getCount());
        System.out.println("列表中最大数 : " + intSummaryStatistics.getMax());
        System.out.println("列表中平均数 : " + intSummaryStatistics.getMin());
        System.out.println("列表中总数 : " + intSummaryStatistics.getSum());


    }
}
