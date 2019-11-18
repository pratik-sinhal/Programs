package concurrency.example12;

/**
 * Created by pratik_s on 13/9/16.
 */
public class AtomicityTest extends Thread {
    private int i;

    public AtomicityTest() {
        start();
    }

    public synchronized int getI() {
        return i;
    }

    public synchronized void evenIncrement() {
        ++i;
        ++i;
    }

    @Override
    public void run() {
        while (Boolean.TRUE){
            evenIncrement();
        }
        return;
    }
}
