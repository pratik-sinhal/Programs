package concurrency.exercise5;

/**
 * Created by pratik_s on 24/8/16.
 */
public interface Generator<T> {
    T next(Integer n);
}
