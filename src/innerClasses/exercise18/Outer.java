package innerClasses.exercise18;

/**
 * Created by pratik_s on 16/9/16.
 */
public class Outer {
    public static class NestedClass {
        public void display() {
            System.out.println("In NestedClass.display()");
        }
    }

    public static void main(String[] args) {
        NestedClass nestedClass = new NestedClass();
        nestedClass.display();
    }
}
