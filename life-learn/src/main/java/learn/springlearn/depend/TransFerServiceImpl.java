package learn.springlearn.depend;

/**
 * @author WangWenLei
 * @DATE: 2020/11/4
 **/
public class TransFerServiceImpl implements TransferService {
    public TransFerServiceImpl(AccountRepository acc){}

    @Override
    public void sayHello() {
        System.out.println("hello Bean 依赖！");
    }
}
