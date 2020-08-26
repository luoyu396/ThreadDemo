import java.util.concurrent.TimeUnit;

/**
 * @author tanbb
 * @create 2020-08-19 15:50
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
           while (true){
           }
        });

        thread.start();
        System.out.println(thread.isInterrupted());
        TimeUnit.SECONDS.sleep(1L);

        thread.interrupt();

        TimeUnit.SECONDS.sleep(1L);

        System.out.println(thread.isInterrupted());
    }
}
