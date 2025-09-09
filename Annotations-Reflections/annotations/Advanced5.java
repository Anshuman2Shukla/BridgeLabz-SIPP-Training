package annotations;

import java.lang.reflect.Method;

@RoleAllowed("ADMIN") // optional class-level
public class Advanced5 {
    private String role;

    public Advanced5(String role) { this.role = role; }

    public void adminTask() {
        System.out.println("Admin task executed by role: " + role);
    }

    public static void main(String[] args) throws Exception {
        Advanced5 user = new Advanced5("USER");
        Advanced5 admin = new Advanced5("ADMIN");

        for (Advanced5 obj : new Advanced5[]{user, admin}) {
            Method m = Advanced5.class.getDeclaredMethod("adminTask");
            // check method-level first, then class-level
            RoleAllowed ra = m.getAnnotation(RoleAllowed.class);
            if (ra == null) ra = Advanced5.class.getAnnotation(RoleAllowed.class);
            if (ra != null && !obj.role.equals(ra.value())) {
                System.out.println("Access Denied for role: " + obj.role);
            } else {
                m.invoke(obj);
            }
        }
    }
}
