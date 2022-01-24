package learn.note.designpatterns.bridge;

/**
 * @ClassName Steamship
 * @Author wwl
 * @Date 2021/10/20 23:24
 * @Version 1.0
 **/
public class Steamship extends Traffic {
    @Override
    public String speed() {
        return "30节";
    }
}
