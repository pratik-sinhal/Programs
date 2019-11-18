package concurrency.example1;

/**
 * Created by pratik_s on 5/9/16.
 */
public class MyUncaugthExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable e) {
        System.out.println("Caught " + e);
    }
}
