package learn.note.JDKCode.IO.NIO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 三种类型的内存映射缓冲区的比较
 * @author WangWenLei
 * @DATE: 2021/11/9
 **/
public class MapFile {
    public static void main(String[] args) throws IOException {
        File tempFile = File.createTempFile("mapptest",null);
        RandomAccessFile file = new RandomAccessFile(tempFile,"rw");
        FileChannel channel = file.getChannel();
        ByteBuffer temp = ByteBuffer.allocate(100);
        temp.put("this is file content".getBytes());
        temp.flip();
        channel.write(temp, 0);
        // 放一些东西给这个文件，开始的位置8192
        // 8192是8KB，几乎可以肯定一个不同的 内存页
        // 可能导致文件空洞，根据文件系统页大小
        temp.clear();
        temp.put("this is more file content".getBytes());
        temp.flip();
        channel.write(temp,8192);
        MappedByteBuffer ro = channel.map(FileChannel.MapMode.READ_ONLY,0,channel.size());
        MappedByteBuffer rw = channel.map(FileChannel.MapMode.READ_WRITE,0,channel.size());
        MappedByteBuffer cow = channel.map(FileChannel.MapMode.PRIVATE,0,channel.size());
        System.out.println("开始---->");
        showBuffers(ro, rw, cow);
        cow.position(8);
        cow.put("COW".getBytes());
        System.out.println("改变cow缓冲区");
        showBuffers(ro, rw, cow);
        // 修改 rw缓冲区（内存映射文件）
        rw.position(9);
        rw.put(" R/W".getBytes());
        rw.position(8194);
        rw.put(" R/W".getBytes());
        rw.force();
        System.out.println("改变rw缓冲区");
        showBuffers(ro, rw, cow);
        temp.clear();
        temp.put("Channel write".getBytes());
        temp.flip();
        channel.write(temp,0);
        // 不动上界
        temp.rewind();
        channel.write(temp,8202);
        System.out.println("写在管道");
        cow.position(8207);
        cow.put(" COW2".getBytes());
        System.out.println("第二次改变COW缓冲区");
        showBuffers(ro, rw, cow);

        // 修改读写缓冲区
        rw.position(8210);
        rw.put(" R/W2".getBytes());
        rw.force();
        System.out.println("第二次改变读写缓冲区");
        showBuffers(ro, rw, cow);
        channel.close();
        file.close();
        tempFile.delete();
    }

    public static void showBuffers(ByteBuffer ro,ByteBuffer rw,ByteBuffer vow){
        dumpBuffer("R/O",ro);
        dumpBuffer("R/W",rw);
        dumpBuffer("COW",vow);
    }

    public static void dumpBuffer (String prefix,ByteBuffer buffer) {
        System.out.print(prefix + " : '");
        int nulls = 0;
        int limit = buffer.limit();
        for (int i = 0 ; i < limit ; i++){
            char c = (char) buffer.get(i);
            if( c == '\u0000') {
                nulls ++;
                continue;
            }
            if( nulls != 0){
                System.out.print("| [ " + nulls + " nulls ] |");
                nulls = 0;
            }
            System.out.print(c);
        }
        System.out.println("'");
    }
}
