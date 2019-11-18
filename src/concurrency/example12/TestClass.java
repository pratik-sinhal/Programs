package concurrency.example12;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by pratik_s on 13/9/16.
 */
public class TestClass {
    public static void main(String[] args) {
        /* Timer to abort the program since it will not exit itself
            * due to use of synchronized keyword
         */
        new Timer().schedule(new TimerTask() {
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 50000); // Terminate after 10 seconds
        AtomicityTest atomicityTest = new AtomicityTest();
        while (Boolean.TRUE){
            Integer val = atomicityTest.getI();
            if((val & 1) > 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
