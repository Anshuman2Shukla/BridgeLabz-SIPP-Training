package annotations;

import java.lang.reflect.Method;

public class Beginner1 {

    @ImportantMethod(level="HIGH")
    public void saveData() {}

    @ImportantMethod(level="MEDIUM")
    public void loadData() {}

    public void helper() {}

    public static void main(String[] args) {
        for (Method m : Beginner1.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + " importance: " + im.level());
            }
        }
    }
}
