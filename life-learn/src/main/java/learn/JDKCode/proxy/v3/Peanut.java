package learn.JDKCode.proxy.v3;

/**
 * 花生米工厂
 * @author WangWenLei
 * @DATE: 2021/4/7
 **/
public class Peanut implements Product {
    @Override
    public void product() {
        System.out.println("我这里生产了花生米！");
    }
}
