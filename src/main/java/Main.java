public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        //MyRunnable myRunnable = new MyRunnable();
        //Thread thread2 = new Thread(myRunnable);
        //thread2.start();

        //Thread thread = new MyThread();
        //thread.start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 1000; i++){

                        if (Thread.currentThread().isInterrupted()){

                            break;

                        }

                        System.out.print(i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 1000; i++){

            if (i == 25){

                thread.interrupt();

            }

            System.out.print("J");

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

//stop() is old  thing , by interrupt() we can stop our thread
//firstly by interrupt we take boolean value true/flase
//then by CurrentThread we are showing our thread
// after that we use isInterrupted to get boolean values
// then if it is true we break;

//join() - by this thread will wait until threads will end

//we do not know in what order thread will execute code

//
