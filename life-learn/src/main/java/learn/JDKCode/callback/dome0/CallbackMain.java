package learn.JDKCode.callback.dome0;


/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class CallbackMain {
    public static void main(String[] args) {
        Student wang = new StudentWang();
        Teacher teacher = new Teacher(wang);
        teacher.askQuestion();
    }
}
