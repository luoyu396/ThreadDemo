import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author tanbb
 * @create 2020-08-20 10:58
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = IntStream.range(0,2).mapToObj(ThreadJoin::create).collect(Collectors.toList());
        list.forEach(Thread::start);
        for (Thread thread : list) {
            thread.join();
        }

        for(int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName()+"#"+i);
            shortSleep();
        }
    }

    private static Thread create(int index) {
        return new Thread(()->{
           for(int i=0; i<10; i++) {
               System.out.println(Thread.currentThread().getName()+"#"+i);
               shortSleep();
           }
        }, String.valueOf(index));
    }

    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
