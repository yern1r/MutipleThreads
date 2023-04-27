import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class FileSystem {
    public static void main(String[] args) {
    for (int i =0; i < 10; i++){
        //can only work 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // control of access in common resources with counter
        //if counter > 0 then it is accessible, if counter = 0 not accessible
        Semaphore semaphore = new Semaphore(3);
        //all task work in one time
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println(name + " started working ");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //but only 3 threads can work in one time
                //like countDownWatch it is counter
                try {
                    semaphore.acquire();
                    workWithFileSystem();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {//then after decreased until 0 ,
                    //value counter will increase to 1
                    semaphore.release();
                }

                System.out.println(name + " finished working");
            }
        });
        executorService.shutdown();
    }

    }

    private  static void workWithFileSystem(){
       String name = Thread.currentThread().getName();
       System.out.println(name + " started working with file system");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " finished working with file system");
    }
}
