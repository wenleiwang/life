package learn.note.designpatterns.adapter.cainiao;

/**
 * @author WangWenLei
 * @DATE: 2021/4/25
 **/
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
