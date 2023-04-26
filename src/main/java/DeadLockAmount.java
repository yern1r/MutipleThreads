public class DeadLockAmount {
    private int amount1;
    private int amount2;

    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();

    public DeadLockAmount(int amount1, int amount2) {
        this.amount1 = amount1;
        this.amount2 = amount2;
    }

    public void transferFrom1to2(int amount){
        synchronized (monitor1){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (amount <= amount1){
                System.out.println("amount <= amount2");
                //this helps to no one will not work with amount2 in one time
                synchronized (monitor2){
                    //but this method tend to take monitor2 and wait until
                    //this monitor will be accessible
                    //and from second method this is same
                    //in result there is infinity loop
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    amount1 -= amount;
                    amount2 += amount;
                }
            }else {
                System.out.println("Not enough");
            }
        }
    }
    public void transferFrom2to1(int amount){
        synchronized (monitor2){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (amount <= amount2){
                System.out.println("amount <= amount2");
                //this helps to no one will not work with amount2 in one time
                synchronized (monitor1){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    amount2 -= amount;
                    amount1 += amount;
                }
            }else {
                System.out.println("Not enough");
            }
        }
    }
}
