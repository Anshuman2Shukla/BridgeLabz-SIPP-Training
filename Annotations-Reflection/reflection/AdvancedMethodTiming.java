package reflection;

import java.lang.reflect.Method;

public class AdvancedMethodTiming {
    public static void timeMethod(Object obj, String methodName, Class<?>[] paramTypes, Object... args) throws Exception {
        Method m = obj.getClass().getMethod(methodName, paramTypes);
        long start = System.nanoTime();
        Object res = m.invoke(obj, args);
        long end = System.nanoTime();
        System.out.println("Result: " + res);
        System.out.println("Execution time (ns): " + (end-start));
    }

    public static class Worker {
        public int work(int x) throws InterruptedException {
            Thread.sleep(50);
            return x*2;
        }
    }

    public static void main(String[] args) throws Exception {
        Worker w = new Worker();
        timeMethod(w, "work", new Class[]{int.class}, 21);
    }
}
