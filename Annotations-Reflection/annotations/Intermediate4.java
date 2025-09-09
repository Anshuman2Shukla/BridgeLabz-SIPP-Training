package annotations;

import java.lang.reflect.Field;

public class Intermediate4 {

    public static class User {
        @MaxLength(10)
        private String username;

        public User(String username) throws Exception {
            Field f = User.class.getDeclaredField("username");
            MaxLength ml = f.getAnnotation(MaxLength.class);
            if (ml != null && username.length() > ml.value()) {
                throw new IllegalArgumentException("Username too long! max=" + ml.value());
            }
            this.username = username;
        }

        public String toString() { return "User{username='"+username+"'}"; }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new User("shortname"));
        try {
            new User("averyverylongusername");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
