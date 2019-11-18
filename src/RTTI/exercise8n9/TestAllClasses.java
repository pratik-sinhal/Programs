package RTTI.exercise8n9;

import java.lang.reflect.Field;

/**
 * Created by pratik_s on 24/9/16.
 */
public class TestAllClasses {
    public static void printClassInfo(Class c){
        System.out.println(c.getName());
        for (Field field: c.getDeclaredFields()) {
            System.out.println("---" + field.getName());
        }
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("RTTI.exercise8n9.AllClasses");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find AllClasses");
            System.exit(1);
        }
        traverseHierarchy(c);
    }

    private static void traverseHierarchy(Class c) {
        if(c == null)
            return;
        traverseHierarchy(c.getSuperclass());
        printClassInfo(c);
    }
}

