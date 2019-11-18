package generics.exercise9n10;

/**
 * Created by pratik_s on 21/9/16.
 */
public class GenericMethods {
    public <A,B> void f(A arg1, B arg2, String arg3) {
        System.out.println(arg1.getClass().getName());
        System.out.println(arg2.getClass().getName());
        System.out.println(arg3.getClass().getName());
        System.out.println("\n\n");
    }
}
