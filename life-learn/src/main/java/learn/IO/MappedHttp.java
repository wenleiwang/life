package learn.IO;

import java.io.*;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author WangWenLei
 * @DATE: 2021/11/9
 **/
public class MappedHttp {
    private static final String OUTPUT_FILE = "MappedHttp.out";
    private static final String LINE_SET = "\r\n";
    private static final String SERVER_ID = "Server:Ronsoft Dummy Server";
    private static final String HTTP_HDR = "HTTP/1.0 200 OK" + LINE_SET + SERVER_ID + LINE_SET;
    private static final String HTTP_404_HDR = "HTTP/1.0 404 Not Found" + LINE_SET + SERVER_ID + LINE_SET;
    private static final String MSG_404 = "Could not open file :";

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("usage： filename");
            return;
        }
        String file = args[0];
        ByteBuffer header = ByteBuffer.wrap(bytes(HTTP_HDR));
        ByteBuffer dynhdrs = ByteBuffer.allocate(128);
        ByteBuffer [] gather = {header,dynhdrs,null};
        String contentType = "unknown/unknown";
        long contentLength = -1;
        try {
            FileInputStream fis = new FileInputStream(file);
            FileChannel fc = fis.getChannel();
            MappedByteBuffer filedate = fc.map(FileChannel.MapMode.READ_ONLY,0,fc.size());
            gather[2] = filedate;
            contentLength = fc.size();
            contentType = URLConnection.guessContentTypeFromName(file);
        } catch (IOException e) {
            ByteBuffer buf = ByteBuffer.allocate(128);
            String msg = MSG_404 + e + LINE_SET;
            buf.put(bytes(msg));
            buf.flip();
            gather [0] = ByteBuffer.wrap(bytes(HTTP_404_HDR));
            gather [2] = buf;
            contentLength = msg.length();
            contentType = "text/p;ain";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("Content-Length: " + contentLength);
        sb.append(LINE_SET);
        sb.append(LINE_SET).append(LINE_SET);
        dynhdrs.put(bytes(sb.toString()));
        dynhdrs.flip();
        FileOutputStream fos = new FileOutputStream(OUTPUT_FILE);
        FileChannel out = fos.getChannel();
        while (out.write(gather) > 0) {

        }
        out.close();
        System.out.println("output writen to " + OUTPUT_FILE);
    }

    private static byte [] bytes(String string) throws UnsupportedEncodingException {
        return (string.getBytes("US-ASCII"));
    }
}
