import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) throws IOException {
        String src = "largefile.txt";
        String destBuffered = "copy_buffered.txt";
        String destUnbuffered = "copy_unbuffered.txt";

        long startBuffered = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destBuffered))) {

            byte[] buffer = new byte[4096];
            int length;
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
        }
        long endBuffered = System.nanoTime();

        long startUnbuffered = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(destUnbuffered)) {

            byte[] buffer = new byte[4096];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
        }
        long endUnbuffered = System.nanoTime();

        System.out.println("Buffered Time: " + (endBuffered - startBuffered) + " ns");
        System.out.println("Unbuffered Time: " + (endUnbuffered - startUnbuffered) + " ns");
    }
}