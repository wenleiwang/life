package learn.note.JDKCode.proxy.cglib;

/**
 * @author WangWenLei
 * @DATE: 2021/7/6
 **/
public class CglibTest {
    public static void main(String[] args) {
        try {
            Customer obj = (Customer)new CglibMeipo().getInstance(Customer.class);
            obj.finLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}