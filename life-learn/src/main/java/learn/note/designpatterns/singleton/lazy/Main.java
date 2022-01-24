package learn.note.designpatterns.singleton.lazy;

/**
 * @author WangWenLei
 * @DATE: 2021/7/5
 **/
public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExectorThread());
        Thread thread2 = new Thread(new ExectorThread());

        thread1.start();
        thread2.start();
        System.out.println("End");
    }
}
