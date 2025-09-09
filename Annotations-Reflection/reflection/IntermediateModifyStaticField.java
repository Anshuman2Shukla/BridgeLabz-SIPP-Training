package reflection;

import java.lang.reflect.Field;

public class IntermediateModifyStaticField {
    public static void main(String[] args) throws Exception {
        System.out.println("Before: " + Configuration.getApiKey());
        Field f = Configuration.class.getDeclaredField("API_KEY");
        f.setAccessible(true);
        f.set(null, "NEW_KEY_ABC"); // static field: target is null
        System.out.println("After: " + Configuration.getApiKey());
    }
}
