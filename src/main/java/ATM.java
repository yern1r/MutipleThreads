public class ATM {
    private int amount;
    private final Object monitor = new Object();

    public ATM(int amount) {
        this.amount = amount;
    }


//synchronized
    public  void withdraw(String name, int amount){
        synchronized (monitor) {
            System.out.println(name + " went to ATM");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (this.amount >= amount){
                this.amount = this.amount - amount;
                System.out.println(name + " withdraws " + amount);
                System.out.println("Left : " + (this.amount));
            }else {
                System.out.println("There is no enough money ," + name);
            }
        }
    }
}
