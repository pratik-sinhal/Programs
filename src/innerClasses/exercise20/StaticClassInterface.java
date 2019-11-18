package innerClasses.exercise20;

/**
 * Created by pratik_s on 16/9/16.
 */
public interface StaticClassInterface {
    void display();
    class Static implements StaticClassInterface {
        @Override
        public void display() {
            System.out.println("In Static.display()");
        }

        public static void main(String[] args) {
            new Static().display();
        }
    }
}
