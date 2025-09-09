package annotations;

import java.lang.reflect.Field;

public class Advanced6 {
    public static class User {
        @JsonField(name="user_name")
        private String username;

        @JsonField(name="user_age")
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;
        for (Field f : fields) {
            if (f.isAnnotationPresent(JsonField.class)) {
                f.setAccessible(true);
                JsonField jf = f.getAnnotation(JsonField.class);
                if (!first) sb.append(",");
                Object val = f.get(obj);
                sb.append("\"").append(jf.name()).append("\":"); 
                if (val instanceof Number || val instanceof Boolean) {
                    sb.append(val);
                } else {
                    sb.append("\"").append(val).append("\""); 
                }
                first = false;
            }
        }
        sb.append("}"); 
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        User u = new User("Alice", 30);
        System.out.println(toJson(u));
    }
}
