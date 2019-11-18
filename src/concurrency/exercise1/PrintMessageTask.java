package concurrency.exercise1;

/**
 * Created by pratik_s on 24/8/16.
 */
public class PrintMessageTask implements Runnable{
    private static Integer taskCount = 0;
    private final Integer taskId = taskCount++;

    PrintMessageTask() {
        /*System.out.println("Starting up the task no " + taskId);*/
    }

    @Override
    public void run() {
        System.out.println("Task no " + taskId + " printing first message");
        Thread.yield();
        System.out.println("Task no " + taskId + " printing second message");
        Thread.yield();
        System.out.println("Task no " + taskId + " printing third message");
        Thread.yield();
        System.out.println("Shutting down task no " + taskId);
        return;
    }

    public static void main(String[] args) {
        for (Integer i = 0; i <  5; i++) {
            Thread t = new Thread(new PrintMessageTask());
            t.start();
        }
        System.out.println("Starting program execution");
    }
}
