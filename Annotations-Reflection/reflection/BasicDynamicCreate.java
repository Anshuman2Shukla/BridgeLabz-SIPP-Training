package reflection;

public class BasicDynamicCreate {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("reflection.Student");
        Object obj = cls.getDeclaredConstructor(String.class, int.class).newInstance("Alice", 101);
        System.out.println("Created via ctor: " + obj);

        // using default constructor + setters via reflection (no setters here, so set fields directly)
        Object s2 = cls.getDeclaredConstructor().newInstance();
        java.lang.reflect.Field nameF = cls.getDeclaredField("name"); nameF.setAccessible(true); nameF.set(s2, "Bob");
        java.lang.reflect.Field idF = cls.getDeclaredField("id"); idF.setAccessible(true); idF.setInt(s2, 202);
        System.out.println("Created via default ctor + fields: " + s2);
    }
}
