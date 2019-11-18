package innerClasses.exercise9;

/**
 * Created by pratik_s on 29/8/16.
 */
public class Outer{
    private String str1;

    public Outer(String str1) {
        this.str1 = str1;
    }

    public InterfaceOne getInnerInstance() {
        class Inner implements InterfaceOne<String> {
            @Override
            public void one(String a) {
                System.out.println("Outer string = " + str1 + " and argument = " + a);
            }
        }
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer("example1");
        InterfaceOne inner = outer.getInnerInstance();
        new Thread();
        inner.one("example2");
    }
}
