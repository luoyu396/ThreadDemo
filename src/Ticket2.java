/**
 * @author tanbb
 * @create 2020-08-17 10:52
 */
public class Ticket2 implements Runnable {

    private int index =1;

    private static final int MAX = 50;

    @Override
    public void run() {
        while (index < MAX) {
            System.out.println(Thread.currentThread()+ "的号码是：" + index++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        Thread t1 = new Thread(ticket2,"1号");
        Thread t2 = new Thread(ticket2,"2号");
        t1.start();
        t2.start();
    }
}
