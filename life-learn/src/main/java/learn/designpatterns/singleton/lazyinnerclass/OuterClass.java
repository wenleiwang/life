package learn.designpatterns.singleton.lazyinnerclass;

import java.util.Random;

/**
 * @author WangWenLei
 * @DATE: 2021/7/6
 **/
public class OuterClass {
    public static long OUTER_DATE = System.currentTimeMillis();
    static {
        System.out.println("外部类静态块加载时间：" + System.currentTimeMillis());
    }

    public static class InnerStaticClass{
        public static long INNER_STATIC_DATE = System.currentTimeMillis();
    }

    class InnerClass{
        public long INNER_DATE = 0;
        public InnerClass(){
            timeElapsed();
            INNER_DATE = System.currentTimeMillis();
        }
    }
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        System.out.println("外部类静态变量加载时间：" + OuterClass.OUTER_DATE);
        System.out.println("非静态内部类加载时间"+outer.new InnerClass().INNER_DATE);
        System.out.println("静态内部类加载时间："+InnerStaticClass.INNER_STATIC_DATE);
    }


    //单纯的为了耗时，来扩大时间差异
    private void timeElapsed() {
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
    }
}
