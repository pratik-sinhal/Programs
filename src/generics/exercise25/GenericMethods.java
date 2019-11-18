package generics.exercise25;

/**
 * Created by pratik_s on 21/9/16.
 */
public class GenericMethods {
    public static <T extends IOne> void genericOne(T arg) {
        arg.one();
    }

    public static <T extends ITwo> void genericTwo(T arg) {
        arg.two();
    }
}
