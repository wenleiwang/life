package learn.JDKCode.IO.NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Random;

/**
 * @author WangWenLei
 * @DATE: 2021/11/9
 **/
public class LockTest {
    private static final int SIZEOF_INT = 4;
    private static final int INDEX_START = 0;
    private static final int INDEX_COUNT = 10;
    private static final int INDEX_SIZE = INDEX_COUNT * SIZEOF_INT;
    private ByteBuffer buffer = ByteBuffer.allocate(INDEX_SIZE);
    private IntBuffer indexBuffer = buffer.asIntBuffer();
    private Random rand = new Random();

    public static void main(String[] args) throws IOException, InterruptedException {
        boolean writer = false;
        String filename;
        if (args.length != 2) {
            System.out.println("Usage: [-r | -w ] filename");
            return ;
        }
        writer = args [0].equals("-w");
        filename = args[1];
        RandomAccessFile raf = new RandomAccessFile(filename,(writer) ? "rw" : "r");
        FileChannel fc = raf.getChannel();
        LockTest lockTest = new LockTest();
        if (writer) {
            lockTest.doUpdates(fc);
        } else {
            lockTest.doQueries(fc);
        }
    }

    void doQueries(FileChannel fc) throws IOException, InterruptedException {
        while (true) {
            println("trying fo sharded lock ...");
            FileLock lock = fc.lock(INDEX_START,INDEX_SIZE,true);
            int reps = rand.nextInt(60) + 20;
            for (int i = 0 ; i < reps ; i++){
                int n = rand.nextInt(INDEX_COUNT);
                int  position = INDEX_START + (n *SIZEOF_INT);
                buffer.clear();
                fc.read(buffer,position);
                int value = indexBuffer.get(n);
                println("index entry " + n + "=" + value);
                Thread.sleep(100);
            }
            lock.release();

            println("<sleeping>");
            Thread.sleep(rand.nextInt(3000) + 500);
        }
    }

    void doUpdates(FileChannel fc) throws IOException, InterruptedException {
        while (true) {
            println("try for exclusive lock ...");
            FileLock lock = fc.lock(INDEX_START,INDEX_SIZE,false);
            updateIndex (fc);
            lock.release();
            println("<sleeping>");
            Thread.sleep(rand.nextInt(2000) + 500);
        }
    }

    private int idxval = 1;
    private void updateIndex (FileChannel fc) throws InterruptedException {
        indexBuffer.clear();
        for (int i = 0 ; i< INDEX_COUNT ; i++) {
            idxval ++;
            println("Updating index " + i + "=" + idxval);
            indexBuffer.put(idxval);
            Thread.sleep(500);
        }
    }


    private int lastLineLen = 0;
    private void println(String msg) {
        System.out.println("\r ");
        System.out.println(msg);
        for (int i = msg.length() ; i < lastLineLen ; i++) {
            System.out.println(" ");
        }
        System.out.println("\r");
        System.out.flush();
        lastLineLen = msg.length();
    }
}
