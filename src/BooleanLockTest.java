import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

/**
 * @author tanbb
 * @create 2020-08-26 17:47
 */
public class BooleanLockTest {

    private final Lock lock = new BooleanLock();

    public void syncMethod() {
        try {
            lock.lock(1000);
            int randomInt = new Random().nextInt(10);
            System.out.println(Thread.currentThread().getName() + " get the lock");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BooleanLockTest blt = new BooleanLockTest();
       // IntStream.range(0,10).mapToObj(i-> new Thread(blt::syncMethod)).forEach(Thread::start);

        new Thread(blt::syncMethod, "t1").start();

        TimeUnit.MILLISECONDS.sleep(10);

        Thread t2 = new Thread(blt::syncMethod,"t2");
        t2.start();

        TimeUnit.MILLISECONDS.sleep(10);

       // t2.interrupt();


    }
}
