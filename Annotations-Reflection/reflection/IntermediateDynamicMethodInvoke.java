package reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

public class IntermediateDynamicMethodInvoke {
    public static void main(String[] args) throws Exception {
        MathOperations ops = new MathOperations();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter method name (add/subtract/multiply): ");
        String name = sc.next();
        System.out.print("Enter two integers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        Method m = MathOperations.class.getMethod(name, int.class, int.class);
        Object r = m.invoke(ops, a, b);
        System.out.println("Result: " + r);
        sc.close();
    }
}
