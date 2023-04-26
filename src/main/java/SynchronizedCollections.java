import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class SynchronizedCollections {
    public static void main(String[] args) {
        List<Integer> numbers = new CopyOnWriteArrayList<>();
        //CopyOnWriteArrayList
        //CopyOnWriteArraySet
        //can to read and write

        //ConcurrentHashMap
        //Give opportunity in one time to read and write

        //for example , in one time you can read index7 , write index5, write 8 index

        //Faster than Collections.synchronizedList/synchronizedSet/synchronizedMap

        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(100);
                        numbers.add(i);
                    }
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(100);
                        numbers.add(i);
                    }
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(numbers.size());
    }
}