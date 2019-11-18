package generics.exercise9n10;

/**
 * Created by pratik_s on 21/9/16.
 */
public class TestGenericMethods {
    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f(1, "", "hey");
        genericMethods.f(genericMethods, 1.4, "yoyo");
    }
}
