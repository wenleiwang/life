package learn.JDKCode.IO.NIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author WangWenLei
 * @DATE: 2021/11/10
 **/
public class ChannelTransfer {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Usage:filename ...");
            return;
        }
        catFiles(Channels.newChannel(System.out), args);
    }

    private static void catFiles(WritableByteChannel target, String[] files) throws IOException {
        for (int i = 0 ; i < files.length ; i++) {
            FileInputStream fis = new FileInputStream(files[i]);
            FileChannel channel = fis.getChannel();
            channel.transferTo(0,channel.size(),target);
            channel.close();
            fis.close();
        }
    }
}
