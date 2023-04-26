public class PrintScan {
    private final Object printMonitor = new Object();
    private final Object scanMonitor = new Object();
    public void print(int page){
        synchronized (printMonitor) {
            for (int i = 1; i < page + 1; i++) {
                System.out.println("Print " + i + "page");
            }
        }
    }

    public void scan(int page){
        synchronized (scanMonitor) {
            for (int i = 1; i < page + 1 ; i++) {
                System.out.println("Scan " + i + "page");
            }
        }
    }
}
