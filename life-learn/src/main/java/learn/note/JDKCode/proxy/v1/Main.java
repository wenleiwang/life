package learn.note.JDKCode.proxy.v1;

/**
 * 调用者：代理酒厂还要统计花费多长时间
 * @author WangWenLei
 * @DATE: 2021/4/7
 **/
public class Main {
    public static void main(String[] args) {
        // 先沟通买酒后统计总时间
        Product product1 = new ProductTimeProxy(new LiquorProxy(new Liquor()));
        product1.product();

        System.out.println("------------------------");

        // 先统计造酒花费时间再沟通买酒
        Product product2 = new LiquorProxy(new ProductTimeProxy(new Liquor()));
        product2.product();
    }
}
