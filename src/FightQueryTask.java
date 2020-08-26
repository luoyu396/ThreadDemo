import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author tanbb
 * @create 2020-08-21 15:23
 */
public class FightQueryTask extends Thread implements FightQuery {

    private final String origan;

    private final String destion;

    private final List<String> fightList = new ArrayList<>();

    public FightQueryTask(String airLine, String origan, String destion) {
        super("["+airLine+"]");
        this.origan = origan;
        this.destion = destion;
    }


    @Override
    public void run() {
        System.out.printf("%s query %s to %s\n", getName(),origan,destion);
        int randomVal = ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(randomVal);
            fightList.add(getName()+"-"+randomVal);
            System.out.printf("this fight : %s list query is success\n",getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        return fightList;
    }
}
