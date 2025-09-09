package annotations;

import java.lang.reflect.Method;

public class Beginner2 {

    @Todo(task="Implement login", assignedTo="Alice", priority="HIGH")
    public void loginFeature() {}

    @Todo(task="Add logout", assignedTo="Bob")
    public void logoutFeature() {}

    public static void main(String[] args) {
        for (Method m : Beginner2.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println(m.getName() + " -> task=" + t.task() + ", assignedTo=" + t.assignedTo() + ", priority=" + t.priority());
            }
        }
    }
}
