/**
 * @author tanbb
 * @create 2020-08-18 16:23
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()-> {
            while (true) {
                try {
                    Thread.sleep(10L);
                    System.out.println("son is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(2000L);

        System.out.println("main is end");
    }
}
