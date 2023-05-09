package STREAMAPI;

public class StreamAPI1 {
    public static void main(String[] args) {
        /*
        new Thread(
        -- we know that only Runnable type can be run --
        new Runnable()
        -- also we know that there is no parameters -- {
            -- then there is only one method , no needs to override --
            @Override
            -- only one method to execute --
            public void run() {

            }
            -- by using what we know we can simplify it --
            -- like below --
        })*/
        new Thread(() -> System.out.println(1)).start();
        //functional interface - is interface with only one abstract method



    }
}
