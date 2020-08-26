import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /*System.out.println("Hello World!");
        new Thread() {
            @Override
            public void run() {
                System.out.println("111111");
            }
        }.start();

        Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(3L);
        thread.start();*/

        IntStream.range(0,10).mapToObj(Main::create).forEach(Thread::start);
    }

    private static Thread create(int index) {
        Thread thread = new Thread(()->{
           if(index == 0) {
              Thread.yield();
           }
            System.out.println(index);
        });
        return thread;
    }
}
