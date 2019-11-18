package concurrency.exercise21;

import java.util.concurrent.TimeUnit;

/**
 * Created by pratik on 17/8/17.
 */
public class Runnable2 implements Runnable {

    Runnable1 runnable1;

    public Runnable2(Runnable1 runnable1) {
        this.runnable1 = runnable1;
    }

    @Override
    public void run() {
        synchronized (runnable1){
            runnable1.notifyAll();
        }
    }
}
