import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThreads {

    public static void main(String[] args) {
        //it is interface, and there are many implementation

        //by this we can work with many threads,
        //the logic is when threads are free code will execute
        //if no one is not free , code will wait until on of 5 threads will be accessible
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // this countdown is counter
        // and this counter will take number of threads
        //which we are waiting to finish
        //there is 10 threads which we are waiting to finish execution
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            //variables should be final/effectively final in threads
            final int index = i;
            //in order to give task we create method execute
            //we do not create new threads , just give  object type runnable
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Start - " + index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finish - " + index);
                    //decreasing counter
                    countDownLatch.countDown();
                }
            });
        }
        //to finish executor service
        executorService.shutdown();
        //this counter will wait until the counter will be 0
        //after it is 0 it will stop
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads are terminated");
    }
}
