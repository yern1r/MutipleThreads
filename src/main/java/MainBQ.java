import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainBQ {
    public static void main(String[] args) {
        //there is already interface BlockingQueue:)
        BlockingQueue<Runnable> blockingQueue =new LinkedBlockingQueue<>();
        //BlockingQueue blockingQueue = new BlockingQueue();
        new Thread(new Runnable() {
            int i = 0;
            @Override
            public void run() {

                while (true){
                    System.out.println("Counter: " + i);
                    i++;
                    try {
                        Runnable task = blockingQueue.take();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    /*if (task != null){
                        new Thread(task).start();
                    }*/
                }
            }
        }).start();

        for (int i =0; i < 10; i++){
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            blockingQueue.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("---" + index);
                }
            });
        }
    }
}
