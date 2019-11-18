package concurrency.exercise6;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by pratik_s on 4/9/16.
 */
public class SleepingTask implements Runnable {
    private static Integer taskCount = 1;
    private final Integer taskId = taskCount++;
    /** objects created within a short time of each other will tend to produce similar
     * output, so it would be a good idea to keep the created Random object as a field,
     */
    Random random = new Random();

    @Override
    public void run() {
        Integer sleepTime = random.nextInt(10) + 1;
        try {

            TimeUnit.SECONDS.sleep(sleepTime);
            System.out.println("Exiting.... task " + taskId + " after sleeptime = " + sleepTime + " !!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
