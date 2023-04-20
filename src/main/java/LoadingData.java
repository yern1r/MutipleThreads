import java.util.concurrent.*;

public class LoadingData {
    public static void main(String[] args) {
        //by thread-factory we made of each threads as daemons
        ExecutorService executorService = Executors.newFixedThreadPool(3,new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });
        //by this executor service we made timer
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.print(".");
                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //these methods can return String data type
        Future<String> futureNAME = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "John";
            }
        });
        Future<Integer> futureAge = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(4000);
                return 20;
            }
        });
        //get() will thread wait to execution of call()
        try {
            String name = futureNAME.get();
            int age = futureAge.get();
            System.out.println("\nName : " + name + "Age : " + age);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
