package learn.note.JDKCode.callback.dome0;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class Teacher implements Callback{
    private Student student;

    public Teacher (Student student) {
        this.student = student;
    }
    public void askQuestion() {
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道答案呢：" + answer);
    }
}
