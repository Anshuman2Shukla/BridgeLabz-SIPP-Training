import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        File source = new File("source.txt");
        File destination = new File("destination.txt");

        if (!source.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}