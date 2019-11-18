package concurrency.example11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pratik_s on 10/9/16.
 */
public class TestClass {
    public static void main(String[] args) {
        SynchronizedClass synchronizedClass = new SynchronizedClass();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executor.execute(new Task(synchronizedClass, i));
        }
        executor.shutdown();
    }
}
