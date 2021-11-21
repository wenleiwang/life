package learn.designpatterns.bridge;

/**
 * @ClassName Car
 * @Author wwl
 * @Date 2021/10/20 23:24
 * @Version 1.0
 **/
public class Car extends Traffic {
    @Override
    public String speed() {
        return "150迈";
    }

    public String color(Black black){
        return black.name();
    }
}
