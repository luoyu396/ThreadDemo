import java.util.concurrent.TimeUnit;

/**
 * @author tanbb
 * @create 2020-08-21 18:31
 */
public class ThreadVolatile {
    static class InnerClass extends Thread {
        private volatile boolean isClose = false;

        @Override
        public void run() {
            System.out.println("i will start work");
            while (!isClose && !isInterrupted()) {
            }
            System.out.println(isInterrupted());
            System.out.println("i will exit work");
        }

        public void close() {
            isClose = true;
            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InnerClass innerClass = new InnerClass();
        innerClass.start();
        TimeUnit.SECONDS.sleep(10L);
        System.out.println("close thread");
        innerClass.close();
    }
}
