package Java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Test {
    public static void main(String[] args) {
        MethodReference mr = new MethodReference();
        Map<String, String> map = new HashMap<>();
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, 30, "Pratik", new Addres("p1", "s1")));
        list.add(new Person(2, 35, "Ila", new Addres("p2", "s2")));
        list.add(new Person(3, 40, "Pawan", new Addres("p3", "s3")));
        list.add(new Person(4, 45, "Priyanka", new Addres("p3", "s4")));
        list.add(new Person(3, 40, "Pawan", new Addres("p3", "s3")));

        mr.toMap(list, Person::isMoreThanFive, Person::toString, System.out::println);
        System.out.println("word count = "+mr.getWordCount("I am    pratik i am"));
        System.out.println("grouped = "+mr.group(list));

    }
}

public class MethodReference {
    public void toMap(List<Person> list, Predicate<Person> p, Function<Person, String> F, Consumer<String> c){
        list.stream().filter(p).map(F).forEach(c);
        //list.stream().
    }

    public boolean isMoreThanFive(Person p) {
        return p.name.length() >= 5;
    }

    public Map<String, Integer> getWordCount(String s) {
        return  Arrays.stream(s.split("\\s+")).parallel().collect(Collectors.toMap(e->e, e->1, Integer::sum));
    }

    public Map<String, String> group(List<Person> list) {
        return list.stream().collect(Collectors.toMap(Person::getName, Person::getPinCode, (k,v) -> k+","+v));
    }
}

class Person {
    Integer id;
    int age;
    String name;
    Addres address;

    public Person(Integer id, int age, String name, Addres address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public boolean isMoreThanFive() {
        return name.length() >= 5;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getPinCode() {
        return address.pinCode;
    }
}

class Addres {
    String pinCode;
    String street;

    public Addres(String pinCode, String street) {
        this.pinCode = pinCode;
        this.street = street;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getStreet() {
        return street;
    }
}
