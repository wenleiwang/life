package learn.IO.io;

import java.io.*;

/**
 * @author WangWenLei
 * @DATE: 2020/9/23
 **/
public class UseIO {
    //简单IO开始
    public static void main(String [] args){
        File file = new File("D://learn/girl.jpg");
        File file1 = new File("D://learn/girl1.jpg");
        try {
            System.out.println(file.getCanonicalPath());
            System.out.println(file.canExecute());
            System.out.println(file.canRead());
            System.out.println(file.canWrite());
            System.out.println(file.getUsableSpace());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fis =null;

        try {
            fis = new FileInputStream(file);
            int count = 0;
            System.out.println("字节大小"+count);
            FileOutputStream fos = new FileOutputStream(file1);
            byte[] buffer=new byte[1024];   //一次取出的字节数大小,缓冲区大小
            int numberReader = 0;
            while((numberReader = fis.read(buffer)) != -1){
                fos.write(buffer,0,numberReader);
                count++;
            }
            System.out.println("循环次数："+count);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
