package annotations;

import java.lang.reflect.Method;

public class TaskManager {

    @TaskInfo(priority = "HIGH", assignedTo = "Alice")
    public void criticalTask() { }

    @TaskInfo(priority = "LOW", assignedTo = "Bob")
    public void minorTask() { }

    public static void main(String[] args) {
        for (Method m : TaskManager.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo t = m.getAnnotation(TaskInfo.class);
                System.out.println(m.getName() + " -> priority=" + t.priority() + ", assignedTo=" + t.assignedTo());
            }
        }
    }
}
