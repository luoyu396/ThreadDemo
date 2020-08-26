/**
 * @author tanbb
 * @create 2020-08-17 10:46
 */
public class Ticket extends Thread {
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
        Ticket t1 = new Ticket();

        Ticket t2 = new Ticket();

        t1.start();

        t2.start();
    }
}
