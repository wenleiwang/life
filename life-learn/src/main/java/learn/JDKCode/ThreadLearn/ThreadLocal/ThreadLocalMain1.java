package learn.JDKCode.ThreadLearn.ThreadLocal;

/**
 * 展示 ThreadLocal不能解决共享变量的线程安全问题
 * 打印结果
 *  set数据，线程名：main
 *  get数据，线程名称：Thread-0数据为：Student{name='wCode'}
 *  get数据，线程名称：Thread-1数据为：Student{name='www'}
 *  get数据，线程名称：main数据为：Student{name='www'}
 * @Author Wang WenLei
 * @Date 2021/11/24 23:01
 * @Version 1.0
 **/
public class ThreadLocalMain1 {
    private static final ThreadLocal<String> THREAD_LOCAL = new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        setDate(new Student());
        Thread t1 = new Thread(() -> {
            String st = getAndPrintData();
            st = "name";
            THREAD_LOCAL.set(st);
            getAndPrintData();
        });
        Thread t2 = new Thread(ThreadLocalMain1::getAndPrintData);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        getAndPrintData();
    }

    static String getAndPrintData() {
        String student = THREAD_LOCAL.get();
        System.out.println("get数据，线程名称：" + Thread.currentThread().getName()
                + "数据为：" + student);
        return student;
    }

    private static void setDate(Student student){
        System.out.println("set数据，线程名："+Thread.currentThread().getName());
        THREAD_LOCAL.set("student");
    }

}
