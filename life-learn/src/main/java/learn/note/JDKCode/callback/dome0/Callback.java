package learn.note.JDKCode.callback.dome0;

/**
 * 首先定义一个回调接口，只有一个方法tellAnswer(int answer)，即学生思考完毕告诉老师答案：
 * @author fang.com
 */
public interface Callback {
    void tellAnswer(int answer);
}
