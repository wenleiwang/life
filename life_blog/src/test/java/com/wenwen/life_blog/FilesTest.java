package com.wenwen.life_blog;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author WangWenLei
 * @DATE: 2020/11/4
 **/
public class FilesTest {
    @Test
    void FilesCreateDirectory(){
        try {
            Files.createDirectory(Paths.get("com/wenwen/life_blog/uploadingfiles/data"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
