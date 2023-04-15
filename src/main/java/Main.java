public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

        Thread thread = new MyThread();
        thread.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    System.out.print("ok");
                }
            }
        });

        for (int i = 0; i < 100; i++){
            System.out.print("j");
        }

        System.out.println("\n Finish");
    }
}

//there is 2 way to create multiple flow/threads:
//1 - extends from class Thread
//2 - implements interface Runnable (anonymous class) : <--prefer

//run() - code will execute in main thread/flow
//start() - code will execute in different thread/flow , asynch
//in run we show what to do, by start we will execute code
