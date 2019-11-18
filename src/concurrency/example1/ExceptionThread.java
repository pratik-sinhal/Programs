package concurrency.example1;

/**
 * Created by pratik_s on 5/9/16.
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        thread.setUncaughtExceptionHandler(new MyUncaugthExceptionHandler());
        System.out.println("Run by " + thread);
        System.out.println("Exception handler = " +
                thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
