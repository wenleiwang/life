package learn.JDKCode.proxy.v0;

/**
 * 调用者
 * @author WangWenLei
 * @DATE: 2021/4/7
 **/
public class Main {
    public static void main(String[] args) {
        LiquorProxy liquorProxy = new LiquorProxy(new Liquor());
        liquorProxy.product();
    }
}
