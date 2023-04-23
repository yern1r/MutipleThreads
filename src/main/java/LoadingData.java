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
        //In order to executorService return something we use submit method
        //execute() return type is void, compare to submit()
        // which return parametered object type Future<>
        //then our value is stored in variable futureNAME
        Future<String> futureNAME = executorService.submit(new Callable<String>() {
            //interface has method call() which can return data type which given in <>
            //compare to Runnable (void run),  Callable can return something
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
        //get() will thread wait to finishing execution of call()
        // by get() we return the value which is stored in variable futureNAME
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
