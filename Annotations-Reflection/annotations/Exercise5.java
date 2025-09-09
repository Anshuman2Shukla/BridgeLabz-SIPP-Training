package annotations;

import java.lang.reflect.Method;

public class Exercise5 {

    @BugReport(description = "Null pointer bug")
    @BugReport(description = "Array index bug")
    public void buggyMethod() {}

    public static void main(String[] args) throws Exception {
        Method m = Exercise5.class.getDeclaredMethod("buggyMethod");
        BugReport[] reports = m.getAnnotationsByType(BugReport.class);
        for (BugReport br : reports) {
            System.out.println("Bug: " + br.description());
        }
    }
}
