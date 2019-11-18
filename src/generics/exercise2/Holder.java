package generics.exercise2;


import lombok.Data;

/**
 * Created by pratik_s on 15/8/16.
 */
@Data
public class Holder<T> {
    private T first;
    private T second;
    private T third;
    public Holder(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
