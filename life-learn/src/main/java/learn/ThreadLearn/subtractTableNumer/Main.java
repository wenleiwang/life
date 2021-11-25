package learn.ThreadLearn.subtractTableNumer;

/**
 * 并发减库存问题
 * @Author wwl
 * @Date 2021/10/19 21:48
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        // 创建表
        /*
          create table subtract_num(
          	name varchar(100) not null ,
          	num int(11) not null
          )

          insert into subtract_num(name,num)VALUES ('苹果',1000);
         */
        // 1. 第一种方式 java锁的方式

        subtractNumByLock();
    }

    private static synchronized void subtractNumByLock() {

    }
}
