import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AlphabetQueue {
    private static final Object MONITOR = new Object();
    private  static  final  String A = "A";
    private  static  final  String B = "B";
    private  static  final  String C = "C";
private static String nextLetter = A;


    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override

            public void run() {
                synchronized (MONITOR){
                for (int i = 0; i < 5; i++){
                    try {
                        while (!nextLetter.equals(A)){MONITOR.wait();}
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print(A);
                    nextLetter = B;
                    MONITOR.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (MONITOR){
                    for (int i = 0; i < 5; i++){
                        try {
                            while (!nextLetter.equals(B)){
                                MONITOR.wait();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print(B);
                        nextLetter = C;
                        MONITOR.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (MONITOR){
                    for (int i = 0; i < 5; i++){
                        //if it is not C ,sleep
                        //if threads sleeps, monitor will be free
                        try {
                            while (!nextLetter.equals(C)){
                                MONITOR.wait();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        //if it is C , it will print C
                        System.out.print(C);
                        //Then will change nextLetter variable value to A
                        nextLetter = A;
                        //after that will notify other slept threads
                        MONITOR.notifyAll();
                    }
                }
            }
        }).start();
    }
}
//notify() will notify/wake up randomly one thread
//notifyAll() will notify randomly all thread
    //by using this, we notify all threads but ,
    //if condition of program not performed threads sleeps,
// that means monitor will be free , then goes to another thread