package learn.note.JDKCode.callback.dome2;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class CallbackImpl implements Callback {
    @Override
    public void callbackMethod(String name) {
        System.out.println("回调函数实现类->具体实现类回调函数开始执行...");
    }
}
