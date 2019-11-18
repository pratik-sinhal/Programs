package concurrency.example11;

/**
 * Created by pratik_s on 10/9/16.
 */
public class SynchronizedClass {
    private Integer a = 10;
    private Integer b = 10;

    public synchronized void manipulate() {
        ++a;
        ++b;
    }

    public synchronized Boolean checkEquals() {
        return a.equals(b);
    }
}
