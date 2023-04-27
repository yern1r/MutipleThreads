import java.util.concurrent.CyclicBarrier;

public class ThreadCyclicBarrier {
    public static void main(String[] args) {
        //counter for 2 threads
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //it is random time of execution "work"
                    long millis = (long)(Math.random() * 5000 + 1000);
                    String name = Thread.currentThread().getName();
                    System.out.println(name + ": Data is being prepared");
                    try {
                        Thread.sleep(millis);
                        System.out.println(name + ": Data is ready");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        //1st thread will prepare data then
                        //will call await, then his counter will be 1
                        //then second thread , counter = 0
                        //then 3rd thread, counter = 1
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + ": Continue work");
                }
            }).start();
        }
    }
}
