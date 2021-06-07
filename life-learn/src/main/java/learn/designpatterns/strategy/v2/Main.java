package learn.designpatterns.strategy.v2;

import java.util.Arrays;

/**
 * 策略模式：比较策略
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class Main {
    public static void main(String[] args) {
        // 现有个比较的数组
//        int [] data = {3,5,2,6,1};
        float [] data = {3.3f,5.2f,2.2f,6.1f,1.1f};
        // 声明实现排序类
        Sort sort = new Sort();
        // 排序
        float [] data2 = sort.compare(data);
        // 输出
        System.out.println(Arrays.toString(data2));
    }
}
