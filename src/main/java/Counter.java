public class Counter {
    private Object monitor1 = new Object();
    private Object monitor2 = new Object();
    private int value;
    private int value2;



    public  void inc(){
        synchronized (monitor1) {
            value++;
        }
    }

    public  void dec(){
        synchronized (monitor1) {
            value--;
        }
    }

    public int getValue() {
        return value;
    }
    public  void inc2(){
        synchronized (monitor2) {
            value2++;
        }
    }

    public  void dec2(){
        synchronized (monitor2) {
            value2--;
        }
    }

    public int getValue2() {
        return value2;
    }
}
//monitor can be = object or class
//monitor show status of accessibility = free/not free
//we use monitor where only 1 threads can be executed in one time

//Rule: if methods are synch for only one monitor
//so in one time can only work one of methods