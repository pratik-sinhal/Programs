package innerClasses.exercise15;

/**
 * Created by pratik_s on 4/9/16.
 */
public class SecondClass {

    public Sample sample(Integer arg) {
        //anonymous inner class
        return new Sample(arg) {

        }; // here semicolon is mandatory
    }

    public static void main(String[] args) {
        SecondClass secondClass = new SecondClass();
        Sample sample = secondClass.sample(10);
        sample.display();
    }
}
