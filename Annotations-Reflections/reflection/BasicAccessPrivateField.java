package reflection;

import java.lang.reflect.Field;

public class BasicAccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        System.out.println("Before: " + p);

        Field f = Person.class.getDeclaredField("age");
        f.setAccessible(true);
        f.setInt(p, 42);

        System.out.println("After: " + p);
        System.out.println("Retrieved age via reflection: " + f.getInt(p));
    }
}
