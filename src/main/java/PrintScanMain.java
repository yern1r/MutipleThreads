public class PrintScanMain {
    public static void main(String[] args) {
        PrintScan machine = new PrintScan();
        new Thread(new Runnable() {
            @Override
            public void run() {
                machine.print(7);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                machine.scan(7);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
