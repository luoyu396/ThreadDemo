import java.util.concurrent.TimeUnit;

/**
 * @author tanbb
 * @create 2020-08-26 9:36
 */
public class EventClient {
    public static void main(String[] args) {

        EventQueue eventQueue = new EventQueue();

        new Thread(()->{
            while (true) {
                eventQueue.offer(new EventQueue.Event());
            }
        },"producer1").start();

        new Thread(()->{
            while (true) {
                eventQueue.offer(new EventQueue.Event());
            }
        },"producer2").start();

        new Thread(()->{
            while (true) {
                eventQueue.take();
                try {
                    TimeUnit.MICROSECONDS.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"customer1").start();

        new Thread(()->{
            while (true) {
                eventQueue.take();
                try {
                    TimeUnit.MICROSECONDS.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"customer2").start();
    }
}
