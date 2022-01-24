package learn.note.JDKCode.callback.dome2;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.execute(new Callback() {
            @Override
            public void callbackMethod(String name) {
                System.out.println("内部类返回参数：" + name);
            }
        });
        // java 8 改写
        service.execute(item -> {
            System.out.println("返回参数 Lambda：" + item);
        });
    }
}
