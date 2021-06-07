package learn.proxy.v1;

/**
 * 酒厂代理
 * @author WangWenLei
 * @DATE: 2021/4/7
 **/
public class LiquorProxy implements Product {
    Product product;

    public LiquorProxy(Product product) {
        this.product = product;
    }

    @Override
    public void product() {
        System.out.println("给我一部分定金，我去跟厂家沟通买回来。");
        product.product();
        System.out.println("酒回来了，你来取吧~");
    }
}
