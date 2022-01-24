package learn.note.JDKCode;

/**
 * @author WangWenLei
 * @DATE: 2021/3/18
 **/
public class IntegerLearn {

    static class Test{
        Integer data3 = 0;

        public Integer getData3() {
            return data3;
        }

        public void setData3(Integer data3) {
            this.data3 = data3;
        }
    }
    public static void main(String[] args) {
//        Integer data1 = 200;
//        Integer data2 = 200;
//        Test test = new Test();
//        test.setData3(data2);
//        System.out.println(test.getData3());
//        System.out.println(data1 == data2);
//        System.out.println(data1.intValue() == data2.intValue());
//        System.out.println(data1.equals(data2));

        long  a = 1000;
        int b = 10000;
        System.out.println(a * 1.0 /b);
    }
}
