import java.util.*;

public class QuizResultProcessor {
    private String[] correctAnswers;
    private List<Integer> userScores = new ArrayList<>();

    public QuizResultProcessor(String[] correctAnswers) {

        this.correctAnswers = correctAnswers;
    }

    public int compareAnswers(String[] userAnswers) {
        try {
            if (userAnswers.length != correctAnswers.length) {
                throw new IllegalArgumentException("Answer length mismatch");
            }
            int score = 0;
            for (int i = 0; i < correctAnswers.length; i++) {
                if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                    score++;
                }
            }
            userScores.add(score);
            return score;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

    public String getGrade(int score) {
        int total = correctAnswers.length;
        double percent = (score * 100.0) / total;
        if (percent >= 90) return "A";
        else if (percent >= 80) return "B";
        else if (percent >= 70) return "C";
        else if (percent >= 60) return "D";
        else return "F";
    }

    public List<Integer> getUserScores() {
        return userScores;
    }

    public static void main(String[] args) {
        String[] correct = {"A", "B", "C", "D"};
        QuizResultProcessor processor = new QuizResultProcessor(correct);

        String[] user1 = {"A", "B", "C", "D"};
        String[] user2 = {"A", "C", "C", "D"};
        String[] user3 = {"A", "B", "C"}; 

        int score1 = processor.compareAnswers(user1);
        System.out.println("User1 Score: " + score1 + ", Grade: " + processor.getGrade(score1));

        int score2 = processor.compareAnswers(user2);
        System.out.println("User2 Score: " + score2 + ", Grade: " + processor.getGrade(score2));

        int score3 = processor.compareAnswers(user3);
        if (score3 != -1) {
            System.out.println("User3 Score: " + score3 + ", Grade: " + processor.getGrade(score3));
        }

        System.out.println("All user scores: " + processor.getUserScores());
    }
}
