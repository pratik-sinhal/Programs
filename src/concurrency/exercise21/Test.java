package concurrency.exercise21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by pratik on 17/8/17.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable1 runnable1 = new Runnable1();
        executorService.execute(runnable1);
        TimeUnit.SECONDS.sleep(5);
        executorService.execute(new Runnable2(runnable1));
        executorService.shutdown();
    }
}
