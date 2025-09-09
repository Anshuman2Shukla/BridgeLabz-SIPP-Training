package reflection;

import java.lang.reflect.Field;

public class AdvancedToJson {
    public static String toJson(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Field[] fields = cls.getDeclaredFields();
        boolean first = true;
        for (Field f : fields) {
            f.setAccessible(true);
            if (!first) sb.append(',');
            sb.append('\"').append(f.getName()).append('\"').append(':');
            Object val = f.get(obj);
            if (val == null) sb.append("null");
            else if (val instanceof Number || val instanceof Boolean) sb.append(val.toString());
            else sb.append('\"').append(val.toString()).append('\"');
            first = false;
        }
        sb.append('}');
        return sb.toString();
    }

    public static class Simple { private String name = "x"; private int n = 5; }

    public static void main(String[] args) throws Exception {
        System.out.println(toJson(new Simple()));
    }
}
