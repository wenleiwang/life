package learn.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author WangWenLei
 * @DATE: 2020/9/23
 **/
public class CopyUseNIO {
    public static void main(String[] args) {
        FileChannel in = null;
        FileChannel out = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("D:/learn/girl.jpg");
            fos = new FileOutputStream("D:/learn/2.jpg");
            in = fis.getChannel();
            out = fos.getChannel();

            //分配指定缓冲区大小
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            //将通道中的主句存入缓冲区中
            while (in.read(byteBuffer) != -1){
                //切换读取数据模式
                byteBuffer.flip();
                //把数据写入通道
                out.write(byteBuffer);
                //清空缓冲区
                byteBuffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
