package reflection;

import java.lang.reflect.*;

public class LoggingProxyDemo {
    public static void main(String[] args) {
        Greeting g = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            new InvocationHandler() {
                private final Greeting impl = new Greeting(){ public String sayHello(String name){ return "Hello, "+name; } };
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("[LOG] Calling: " + method.getName());
                    return method.invoke(impl, args);
                }
            }
        );
        System.out.println(g.sayHello("World"));
    }
}
