package reflection;

import java.lang.reflect.Method;

public class BasicInvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();
        Method m = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        m.setAccessible(true);
        Object res = m.invoke(c, 6, 7);
        System.out.println("multiply(6,7) = " + res);
    }
}
