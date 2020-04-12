import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaHeap {
    public static void main(String[] args) {
        PriorityQueue<Person> pq = new PriorityQueue<>(4, (p1,p2) -> p1.age-p2.age);
        pq.add(new Person("Pratik", 20));
        pq.add(new Person("Ila", 10));
        pq.add(new Person("X", 10));
        pq.add(new Person("None", 30));
        System.out.println(Arrays.toString(pq.toArray()));
    }
}


class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age + "\n";
    }
}
