package learn.note.JDKCode.IO.NIO;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Random;

/**
 * @author WangWenLei
 * @DATE: 2021/11/17
 **/
public class PipeTest {
    public static void main(String[] args) throws IOException {
        WritableByteChannel out = Channels.newChannel(System.out);
        ReadableByteChannel workerChannel = sartWorker(10);
        ByteBuffer buffer = ByteBuffer.allocate(100);
        while (workerChannel.read(buffer) > 0){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }

    private static ReadableByteChannel sartWorker(int reps) throws IOException {
        Pipe pipe = Pipe.open();
        Worker worker = new Worker(pipe.sink(),reps);
        worker.start();
        return (pipe.source());
    }

    private static class Worker extends Thread{
        WritableByteChannel channel;
        private int reps ;
        Worker(WritableByteChannel channel,int reps){
            this.channel = channel;
            this.reps = reps;
        }

        @Override
        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            try {
                for(int i = 0 ; i < this.reps ; i++){
                    doSomeWork(buffer);
                    while (true){
                        if ((channel.write(buffer) > 0)) {

                        }
                    }
                }
                this.channel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String [] products = {
                "NO good deed goes unpunished",
                "To bu, or what ?",
                "To matter where you go ,there you are",
                "Just say \"Yo\"",
                "My karma ran over my dogma"
        };
        private Random rand = new Random();

        private void doSomeWork(ByteBuffer buffer) {
            int product = rand.nextInt(products.length);
            buffer.clear();
            buffer.put(products[product].getBytes());
            buffer.flip();
        }
    }
}
