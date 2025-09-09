package reflection;

import java.lang.reflect.Field;
import java.util.Map;

public class AdvancedObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> props) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> e : props.entrySet()) {
            try {
                Field f = clazz.getDeclaredField(e.getKey());
                f.setAccessible(true);
                f.set(obj, e.getValue());
            } catch (NoSuchFieldException ignored) {
                // skip unknown properties
            }
        }
        return obj;
    }

    // Demo class
    public static class Book {
        private String title;
        private int pages;
        public String toString(){ return "Book{title='"+title+"',pages="+pages+'}'; }
    }

    public static void main(String[] args) throws Exception {
        java.util.Map<String,Object> m = new java.util.HashMap<>();
        m.put("title","Reflection in Java");
        m.put("pages", 320);
        Book b = toObject(Book.class, m);
        System.out.println(b);
    }
}
