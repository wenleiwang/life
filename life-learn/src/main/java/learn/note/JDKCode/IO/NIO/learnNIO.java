package learn.note.JDKCode.IO.NIO;

import java.nio.ByteBuffer;

/**
 * @author WangWenLei
 * @DATE: 2020/9/23
 **/
public class learnNIO {
    public static void main(String[] args) {
        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //看下四个核心变量的值
        System.out.println("初始时--->界限limit--->"+byteBuffer.limit());
        System.out.println("初始时--->位置position--->"+byteBuffer.position());
        System.out.println("初始时--->容量capacity--->"+byteBuffer.capacity());
        System.out.println("初始时--->标记Mark--->"+byteBuffer.mark());

        // 添加一些数据到缓冲区
        String s = "dflasjfas";
        byteBuffer.put(s.getBytes());

        //看下四个核心变量的值
        System.out.println("put之后--->界限limit--->"+byteBuffer.limit());
        System.out.println("put之后--->位置position--->"+byteBuffer.position());
        System.out.println("put之后--->容量capacity--->"+byteBuffer.capacity());
        System.out.println("put之后--->标记Mark--->"+byteBuffer.mark());
        byteBuffer.flip();

        System.out.println("flip之后--->界限limit--->"+byteBuffer.limit());
        System.out.println("flip之后--->位置position--->"+byteBuffer.position());
        System.out.println("flip之后--->容量capacity--->"+byteBuffer.capacity());
        System.out.println("flip之后--->标记Mark--->"+byteBuffer.mark());

        byte [] bytes = new byte[byteBuffer.limit()];
         byteBuffer.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println("get之后--->界限limit--->"+byteBuffer.limit());
        System.out.println("get之后--->位置position--->"+byteBuffer.position());
        System.out.println("get之后--->容量capacity--->"+byteBuffer.capacity());
        System.out.println("get之后--->标记Mark--->"+byteBuffer.mark());
        byteBuffer.clear();
        System.out.println("初始时--->界限limit--->"+byteBuffer.limit());
        System.out.println("初始时--->位置position--->"+byteBuffer.position());
        System.out.println("初始时--->容量capacity--->"+byteBuffer.capacity());
        System.out.println("初始时--->标记Mark--->"+byteBuffer.mark());
    }
}
