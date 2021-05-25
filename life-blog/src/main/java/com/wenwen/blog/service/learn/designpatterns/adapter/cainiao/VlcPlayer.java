package com.wenwen.blog.service.learn.designpatterns.adapter.cainiao;

/**
 * @author WangWenLei
 * @DATE: 2021/4/25
 **/
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
