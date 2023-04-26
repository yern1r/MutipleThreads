public class MainDeadLock {
    public static void main(String[] args) {
        DeadLockAmount account = new DeadLockAmount(1000,1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.transferFrom1to2(300);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.transferFrom2to1(500);
            }
        }).start();
    }
}
