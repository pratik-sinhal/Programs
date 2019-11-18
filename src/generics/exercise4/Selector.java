package generics.exercise4;

/**
 * Created by pratik_s on 21/8/16.
 */
public interface Selector<T> {
    T current();
    void next();
    boolean end();
}
