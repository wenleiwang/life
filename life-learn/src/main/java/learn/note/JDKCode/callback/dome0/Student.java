package learn.note.JDKCode.callback.dome0;

/**
 * 接着定义一个学生接口，学生当然是解决问题，但是接收一个Callback参数，这样学生就知道解决完毕问题向谁报告：
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public interface Student {
    void resolveQuestion(Callback callback);
}
