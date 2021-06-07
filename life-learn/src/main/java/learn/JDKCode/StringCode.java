package learn.JDKCode;

import java.io.UnsupportedEncodingException;

/**
 * @author WangWenLei
 * @DATE: 2021/2/26
 **/
public class StringCode {
    public static void main(String[] args) {
        String name = "fhkasdjfoiwejpoifjdsljfoiawef";
        String test = new String("abc");
        String test2 = new String(new char[]{'a','b'});

        char [] chs = new char[]{'a','b'};
        String test3 = new String (chs,1,1);
        System.out.println(test3);
        chs = new char[]{'c','d'};
        System.out.println(test3);
        byte [] by1 = new byte[]{'a','b'};
        String test4 = null;
        try {
            test4 = new String(by1, 1, 1, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(test4);

        // equals
        String test5 = "safasdf";
        String test6 = "safasdf ";
        boolean tag = test5.equals(test6);
        System.out.println(tag);

//        name.contains()
    }
}
