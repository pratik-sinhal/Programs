package generics.exercise25;

/**
 * Created by pratik_s on 21/9/16.
 */
public class TestGenericMethods {
    public static void main(String[] args) {
        Clazz clazz = new Clazz();
        GenericMethods.genericOne(clazz);
        GenericMethods.genericTwo(clazz);
    }
}
