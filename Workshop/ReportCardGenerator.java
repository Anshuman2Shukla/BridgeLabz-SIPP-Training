import java.util.*;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

class Student {
    String name;
    String[] subjects;
    int[] marks;

    public Student(String name, String[] subjects, int[] marks) throws InvalidMarkException {
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;

        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Invalid mark: " + mark + ". Must be between 0 and 100.");
            }
        }
    }

    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / (double) marks.length;
    }

    public char assignGrade(double avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }

    public void displayReportCard() {
        System.out.println("Report Card for: " + name);
        System.out.println("---------------------------------");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-10s : %3d\n", subjects[i], marks[i]);
        }
        double avg = calculateAverage();
        System.out.printf("Average     : %.2f\n", avg);
        System.out.println("Grade       : " + assignGrade(avg));
        System.out.println("---------------------------------\n");
    }
}

public class ReportCardGenerator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        try {
            students.add(new Student("Alice", new String[]{"Math", "Physics", "Chemistry"}, new int[]{95, 88, 92}));
            students.add(new Student("Bob", new String[]{"Math", "Physics", "Chemistry"}, new int[]{70, 65, 78}));
            students.add(new Student("Charlie", new String[]{"Math", "Physics", "Chemistry"}, new int[]{55, 40, 60}));
            // students.add(new Student("Invalid", new String[]{"Math"}, new int[]{110}));
        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (Student s : students) {
            s.displayReportCard();
        }
    }
}
