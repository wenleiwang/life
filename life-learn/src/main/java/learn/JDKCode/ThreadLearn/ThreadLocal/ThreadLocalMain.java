package learn.JDKCode.ThreadLearn.ThreadLocal;

/**
 * 展示使用方法
 * @Author Wang WenLei
 * @Date 2021/11/24 21:34
 * @Version 1.0
 **/
public class ThreadLocalMain {
    private static final ThreadLocal<Student> THREAD_LOCAL = new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        setDate(new Student());
        Thread thread = new Thread(ThreadLocalMain::getAndPrintData);
        thread.start();
        thread.join();
        getAndPrintData();
    }

    private static void getAndPrintData() {
        Student student = THREAD_LOCAL.get();
        System.out.println("get数据，线程名称：" + Thread.currentThread().getName()
                + "数据为：" + student);
    }

    private static void setDate(Student student){
        System.out.println("set数据，线程名："+Thread.currentThread().getName());
        THREAD_LOCAL.set(student);
    }

}
