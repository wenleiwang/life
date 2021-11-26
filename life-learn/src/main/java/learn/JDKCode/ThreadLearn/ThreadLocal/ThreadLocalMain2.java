package learn.JDKCode.ThreadLearn.ThreadLocal;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 正确使用姿势
 * @Author Wang WenLei
 * @Date 2021/11/24 23:15
 * @Version 1.0
 **/
public class ThreadLocalMain2 {
    private static final ThreadLocal<DateFormat> DATA_FORMAT_THREAD_LOCAL = new InheritableThreadLocal<DateFormat>(){

        /**
         * 返回此线程局部变量的当前线程的“初始值”。 该方法将在线程第一次使用get方法访问变量时被调用，
         * 除非线程之前调用了set方法，在这种情况下，将不会为线程调用initialValue方法。
         * 通常，每个线程最多调用此方法一次，但在后续调用remove后跟get情况下可能会再次调用它。
         */
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) throws InterruptedException {
//        setDate();
        Thread t1 = new Thread(ThreadLocalMain1::getAndPrintData);
        Thread t2 = new Thread(ThreadLocalMain1::getAndPrintData);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        getAndPrintData();
    }

    private static DateFormat getAndPrintData() {
        DateFormat dateFormat = DATA_FORMAT_THREAD_LOCAL.get();
        System.out.println("get数据，线程名称：" + Thread.currentThread().getName()
                + "数据为：" + dateFormat.format(new Date()));
        return dateFormat;
    }

    private static void setDate(){
        System.out.println("set数据，线程名："+Thread.currentThread().getName());
        DATA_FORMAT_THREAD_LOCAL.set(new SimpleDateFormat("yyyyMMdd"));
    }
}
