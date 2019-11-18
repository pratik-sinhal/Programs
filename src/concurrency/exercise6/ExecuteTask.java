package concurrency.exercise6;

/**
 * Created by pratik_s on 4/9/16.
 */
public class ExecuteTask {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new SleepingTask());
            thread.start();
        }
    }
}
