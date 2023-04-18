public class MainATM {
    public static void main(String[] args) {
        ATM atm = new ATM(1000);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.withdraw("Max" , 400);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.withdraw("Jack" , 500);

            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.withdraw("Robert" , 200);

            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
