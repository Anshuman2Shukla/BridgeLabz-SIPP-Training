package annotations;

import java.util.*;

public class Exercise3 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList(); // raw type
        list.add("Hello");
        list.add("World");
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
