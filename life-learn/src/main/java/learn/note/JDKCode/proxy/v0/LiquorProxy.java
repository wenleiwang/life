package learn.note.JDKCode.proxy.v0;

/**
 * 酒厂代理
 * @author WangWenLei
 * @DATE: 2021/4/7
 **/
public class LiquorProxy implements Product {
    Liquor liquor;

    public LiquorProxy(Liquor liquor) {
        this.liquor = liquor;
    }

    @Override
    public void product() {
        System.out.println("给我一部分定金，我去跟厂家沟通买回来。");
        liquor.product();
        System.out.println("酒回来了，你来取吧~");
    }
}
