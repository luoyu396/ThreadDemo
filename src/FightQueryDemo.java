import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tanbb
 * @create 2020-08-21 15:38
 */
public class FightQueryDemo {

    private static List<String> comList = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        List<String> results = serachs("北京", "上海");
        System.out.println("----results-----");
        results.forEach(System.out::println);
    }

    private static List<String> serachs(String orign, String destion) {
        List<String> results = new ArrayList<>();

        List<FightQueryTask> tasks = comList.stream().map(f->create(f, orign, destion)).collect(Collectors.toList());

        tasks.forEach(Thread::start);

        tasks.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        tasks.stream().map(FightQueryTask::get).forEach(results::addAll);
        return results;
    }

    private static FightQueryTask create(String airLine, String orign, String destion) {
        return new FightQueryTask(airLine, orign, destion);
    }
}
