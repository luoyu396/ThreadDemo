import java.util.concurrent.TimeUnit;

/**
 * @author tanbb
 * @create 2020-08-21 17:26
 */
public class ThreadInterruptExit {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("i will start work");
                while (!isInterrupted()) {
                }
                System.out.println(isInterrupted());
                System.out.println("i will exit work");
            }
        };

        thread.start();
        TimeUnit.SECONDS.sleep(10L);
        System.out.println("i will interrupt thread");
        thread.interrupt();
    }
}
