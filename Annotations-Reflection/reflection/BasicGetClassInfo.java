package reflection;

import java.lang.reflect.*;

public class BasicGetClassInfo {
    public static void main(String[] args) throws Exception {
        String className = args.length>0 ? args[0] : "java.util.ArrayList";
        Class<?> cls = Class.forName(className);

        System.out.println("Class: " + cls.getName());
        System.out.println("\nConstructors:");
        for (Constructor<?> c : cls.getDeclaredConstructors()) {
            System.out.println("  " + c);
        }

        System.out.println("\nFields:");
        for (Field f : cls.getDeclaredFields()) {
            System.out.println("  " + f);
        }

        System.out.println("\nMethods:");
        for (Method m : cls.getDeclaredMethods()) {
            System.out.println("  " + m);
        }
    }
}
