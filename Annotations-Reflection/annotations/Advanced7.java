package annotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Advanced7 {
    private Map<String,Object> cache = new HashMap<>();

    @CacheResult
    public long expensiveCalculation(int x) {
        System.out.println("Computing for " + x);
        try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        return (long)x * x;
    }

    public Object invokeCached(String methodName, Object... args) throws Exception {
        String key = methodName + Arrays.toString(args);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        Method m = this.getClass().getMethod(methodName, int.class);
        Object result = m.invoke(this, args);
        if (m.isAnnotationPresent(CacheResult.class)) {
            cache.put(key, result);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Advanced7 obj = new Advanced7();
        System.out.println(obj.invokeCached("expensiveCalculation", 10));
        System.out.println(obj.invokeCached("expensiveCalculation", 10));
        System.out.println(obj.invokeCached("expensiveCalculation", 20));
    }
}
