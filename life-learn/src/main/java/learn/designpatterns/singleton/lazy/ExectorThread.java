package learn.designpatterns.singleton.lazy;

import lombok.SneakyThrows;

/**
 * @author WangWenLei
 * @DATE: 2021/7/5
 **/
public class ExectorThread implements Runnable{

    @SneakyThrows
    @Override
    public void run() {
//        Thread.sleep(2000L);
        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
