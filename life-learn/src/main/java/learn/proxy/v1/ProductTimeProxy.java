package learn.proxy.v1;

/**
 * 生产需要花费的时间
 * @author WangWenLei
 * @DATE: 2021/4/7
 **/
public class ProductTimeProxy implements Product{
    public ProductTimeProxy(Product product) {
        this.product = product;
    }

    Product product;
    @Override
    public void product() {
        //开始时间
        long start = System.currentTimeMillis();
        product.product();
        long end = System.currentTimeMillis();
        System.out.println("生产时花费了" + (end - start) + "ms时间！");
    }
}
