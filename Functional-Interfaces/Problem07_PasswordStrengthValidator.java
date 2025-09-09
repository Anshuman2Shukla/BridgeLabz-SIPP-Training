
interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        // at least 8 chars, one upper, one lower, one digit
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$");
    }
}

public class Problem07_PasswordStrengthValidator {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrongPassword("Weak123"));
        System.out.println(SecurityUtils.isStrongPassword("StrongPass1"));
    }
}
