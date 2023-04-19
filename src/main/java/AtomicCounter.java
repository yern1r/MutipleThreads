import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger value = new AtomicInteger();
    public void increase(){
        value.getAndIncrement();
    }

    public void decrease(){
        value.getAndDecrement();
    }

    public int getValue() {
        return value.intValue();
    }
}
//solution of race condition
//atomic - can do all steps in one stage
//actually, increment (++) has 3 steps
//but by using atomic we can do in 1 step

//Volatile - limits to cash variable
// (to save value into local memory of thread)
// 1 2 3 3 3 ... => 1 2 3 4 5
// it does not synchronize so we should synchronize our thread