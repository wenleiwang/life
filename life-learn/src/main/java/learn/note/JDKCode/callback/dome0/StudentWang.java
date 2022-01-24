package learn.note.JDKCode.callback.dome0;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class StudentWang implements Student {
    @Override
    public void resolveQuestion(Callback callback) {
        System.out.println("回答了问题");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.tellAnswer(3);
    }
}
