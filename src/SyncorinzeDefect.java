import java.util.concurrent.TimeUnit;

/**
 * @author tanbb
 * @create 2020-08-26 14:55
 */
public class SyncorinzeDefect {

    public synchronized void syncMethod() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncorinzeDefect defect = new SyncorinzeDefect();

        Thread t1 = new Thread(defect::syncMethod);
        t1.start();

        Thread t2 = new Thread(defect::syncMethod);
        TimeUnit.MICROSECONDS.sleep(10);
        t2.start();
        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }
}
