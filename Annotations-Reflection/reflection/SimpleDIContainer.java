package reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleDIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void register(Class<T> cls, T instance){ instances.put(cls, instance); }

    public <T> T get(Class<T> cls) throws Exception {
        if (instances.containsKey(cls)) return cls.cast(instances.get(cls));
        T obj = cls.getDeclaredConstructor().newInstance();
        // inject fields
        for (Field f : cls.getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                Object dep = get(f.getType());
                f.setAccessible(true);
                f.set(obj, dep);
            }
        }
        instances.put(cls, obj);
        return obj;
    }

    // Demo classes
    public static class Repo { public String toString(){ return "Repo{}"; } }
    public static class Service {
        @Inject Repo repo;
        public String toString(){ return "Service{repo="+repo+'}'; }
    }

    public static void main(String[] args) throws Exception {
        SimpleDIContainer c = new SimpleDIContainer();
        Service s = c.get(Service.class);
        System.out.println(s);
    }
}
