package learn.note.JDKCode.IO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 测试无阻塞accept()使用ServerSocketChannel
 * @author WangWenLei
 * @DATE: 2021/11/10
 **/
public class ChannelAccept {
    public static final String GREETING = "Hello Imust be going.\r\n";
    public static void main (String[] args) throws IOException, InterruptedException {
        int port = 1234;
        if(args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        ByteBuffer buffer = ByteBuffer.wrap(GREETING.getBytes());
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        while (true) {
            System.out.println("Waiting for connections");
            SocketChannel sc = ssc.accept();
            if (sc == null) {
                Thread.sleep(2000);
            } else {
                System.out.println("Incoming connection from :" + sc.socket().getRemoteSocketAddress());
                buffer.rewind();
                sc.write(buffer);
                sc.close();
            }

        }
    }
}
