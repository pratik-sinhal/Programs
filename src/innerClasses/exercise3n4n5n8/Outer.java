package innerClasses.exercise3n4n5n8;

/**
 * Created by pratik_s on 15/8/16.
 */
public class Outer {
    private String str;

    public Outer(String str) {
        this.str = str;
    }

    public void callOuter() {
        System.out.println("Outer class called");
    }

    // check if outer class can access contents of inner class--> not possible
    public String toString() {
        //return innerString;
        return "";
    }

    private class Inner {
        private String innerString;

        public Inner(String str) {
            innerString = str;
        }

        public String toString() {
            // check if inner class can call methods of outer class
            callOuter();
            return str;
        }

        /**
         * Method to return a reference of the outer class
         * @return
         */
        public Outer getOuterReference() {
            return Outer.this;
        }
    }

    public Inner getInnerInstance() {
        return new Inner("Inner string");
    }

    public static void main(String[] args) {
        Outer outer = new Outer("Outer string");
        Inner inner = outer.getInnerInstance();
        // to get reference of outer class from inner class instance
        Outer outer1 = inner.getOuterReference();
        // to get reference of inner class without calling outer class method
        Inner inner1 = outer.new Inner("Inner string");
        System.out.println(inner.toString());
        System.out.println(inner1.toString());
    }
}
