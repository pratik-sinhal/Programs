package concurrency.example11;

/**
 * Created by pratik_s on 10/9/16.
 */
public class Task implements Runnable {
    private SynchronizedClass synchronizedClass;
    private Integer taskId;

    public Task(SynchronizedClass synchronizedClass, Integer taskId) {
        this.synchronizedClass = synchronizedClass;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        while(synchronizedClass.checkEquals()) {
            synchronizedClass.manipulate();
        }
        System.out.println("Exiting task with id = " + taskId);
        return;
    }
}
