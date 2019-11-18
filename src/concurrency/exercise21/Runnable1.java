package concurrency.exercise21;

/**
 * Created by pratik on 17/8/17.
 */
public class Runnable1 implements Runnable{
    @Override
    public void run(){
        try {
            System.out.println("waiting");
            this.wait();
            System.out.println("wait over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
