package annotations;

import java.lang.reflect.Method;

public class Intermediate3 {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 1000000; i++);
    }

    public static void main(String[] args) throws Exception {
        Intermediate3 obj = new Intermediate3();
        for (Method m : Intermediate3.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(obj);
                long end = System.nanoTime();
                System.out.println(m.getName() + " took " + (end-start) + " ns");
            }
        }
    }
}
