package generics.exercise25;

/**
 * Created by pratik_s on 21/9/16.
 */
public class Clazz implements IOne, ITwo {

    @Override
    public void one() {
        System.out.println("In Clazz.one()");
    }

    @Override
    public void two() {
        System.out.println("In Clazz.two()");
    }
}
