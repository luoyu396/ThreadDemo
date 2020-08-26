import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author tanbb
 * @create 2020-08-26 15:17
 */
public interface Lock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();

}
