import java.util.*;

public class QuizPlatform {
    private static final String[] correctAnswers = {"A", "C", "B", "D", "A"};

    public static int calculateScore(String[] userAnswers) {
        int score = 0;
        try {
            if (userAnswers.length != correctAnswers.length) {
                throw new Exception("Answer length does not match the correct answers.");
            }

            for (int i = 0; i < correctAnswers.length; i++) {
                if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                    score++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return score;
    }

    public static String getGrade(int score) {
        if (score == correctAnswers.length) return "A";
        else if (score >= correctAnswers.length - 1) return "B";
        else if (score >= correctAnswers.length - 2) return "C";
        else return "Fail";
    }

    public static void main(String[] args) {
        List<Integer> allScores = new ArrayList<>();

        String[][] allUserAnswers = {
                {"A", "C", "B", "D", "A"},
                {"A", "B", "B", "C", "A"},
                {"A", "C", "B"},
                {"B", "C", "D", "A", "B"}
        };

        for (String[] userAnswers : allUserAnswers) {
            int score = calculateScore(userAnswers);
            allScores.add(score);
            if (userAnswers.length == correctAnswers.length) {
                String grade = getGrade(score);
                System.out.println("Score: " + score + " | Grade: " + grade);
            }
        }

        System.out.println("All Scores: " + allScores);
    }
}