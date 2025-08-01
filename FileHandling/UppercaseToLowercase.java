import java.io.*;

public class UppercaseToLowercase {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("lowercase.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("Content written to lowercase.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}