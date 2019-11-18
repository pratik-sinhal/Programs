package generics.exercise3;

import lombok.Data;

/**
 * Created by pratik_s on 15/8/16.
 */
@Data
public class SixTuple<A, B, C, D, E, F> {
    private A first;
    private B second;
    private C third;
    private D fourth;
    private E fifth;
    private F sixth;

    public SixTuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
    }

    @Override
    public String toString() {
        return first + " " + second + " " + third + " " + fourth + " " + fifth + " " + sixth;
    }

    public static void main(String[] args) {
        SixTuple<String, String, String, Integer, String, Integer> sixTuple
                = new SixTuple<String, String, String, Integer, String, Integer>("My", "DOB", "is", 30, "JUN", 1989);
        System.out.println(sixTuple);
    }
}
