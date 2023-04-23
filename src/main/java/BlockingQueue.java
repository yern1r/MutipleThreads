import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    Queue <Runnable> queue = new LinkedList<>();

    //methods add & take are synchronized ,
    // that means they can not be called in one time
    private final Object monitor = new Object();

    // by add() method, we add task then we notify it
    //by notifying we wake up threads
    public void add(Runnable task){
        synchronized (monitor){
        queue.add(task);
        monitor.notify();
        }
    }

//in take() method , we check if queue is empty (is there any task in queue)
// if it is not empty , we will wait until there will be any task
// by waiting , threads sleep
    //then monitor is free,
// then there is no problem with monitor and other synchronized methods
    public Runnable take(){
        synchronized (monitor){
            try {
                while (queue.isEmpty()){
                    monitor.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return queue.poll();}
    }
}
