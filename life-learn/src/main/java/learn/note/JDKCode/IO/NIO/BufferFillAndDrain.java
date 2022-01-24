package learn.note.JDKCode.IO.NIO;

import java.nio.CharBuffer;

/**
 * Buffer（缓冲区） 的填充和释放
 * @author WangWenLei
 * @DATE: 2021/10/12
 **/
public class BufferFillAndDrain {
    public static void main(String[] args) {
        //分配一个新的字符缓冲区。
        //新缓冲区的位置将为零，它的限制将是它的容量，它的标记将是未定义的，并且它的每个元素都将被初始化为零。
        // 它将有一个backing array ，其array offset为零。
        CharBuffer buffer = CharBuffer.allocate(100);
        while(fillBuffer(buffer)){
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }

    private static void drainBuffer(CharBuffer buffer) {
        while(buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println();
    }

    private static boolean fillBuffer(CharBuffer buffer) {
        if(index >= strings.length) {
            return false;
        }
        String string = strings[index++];
        for(int i = 0 ; i < string.length(); i++){
            buffer.put(string.charAt(i));
        }
        return true;
    }

    private static int index = 0;
    private static String [] strings = {
            "A random string value",
            "The product of an infinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for the Monkees：JiMin Hendrix",
            ";Scuse me while i kiss this fly",// Sory Jimi ;-)
            "help Me: help Me！"
    };
}
