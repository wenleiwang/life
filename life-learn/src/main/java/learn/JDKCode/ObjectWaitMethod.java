package learn.JDKCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author WangWenLei
 * @DATE: 2021/3/23
 **/
public class ObjectWaitMethod {
    static class myThread implements Runnable {

        @Override
        public void run() {

        }
    }

    static class Date{
        private int i;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    public static void main(String[] args) throws ParseException {

        String time = "2021-06-01";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = simpleDateFormat.parse(time);
        String today=simpleDateFormat.format(date);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
//        calendar.set(Calendar.HOUR_OF_DAY,-24);//昨天
//        calendar.set(Calendar.DATE,-1);//昨天
        calendar.add(Calendar.DATE,-1);
        String yesterday = simpleDateFormat.format(calendar.getTime());
        System.out.println(yesterday);


    }
}
