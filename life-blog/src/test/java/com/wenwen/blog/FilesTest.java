package com.wenwen.blog;

import com.alibaba.fastjson.JSON;
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

    @Test
    void test(){
        String tets = "fsfjaie.efwjoaef.jpg";
        System.out.println(tets.indexOf('.'));
        System.out.println(tets.substring(tets.indexOf('.')));

        String[] name = tets.split("\\.");
        System.out.println(name.length);
        System.out.println(JSON.toJSONString(name));
        System.out.println(name[name.length - 1]);
    }
}
