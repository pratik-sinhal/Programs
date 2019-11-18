package concurrency.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pratik_s on 5/9/16.
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
    }
}
