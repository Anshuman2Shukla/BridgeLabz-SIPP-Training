
public class Problem06_BackgroundJob {
    public static void main(String[] args) {
        Runnable job = () -> {
            try { Thread.sleep(1000); } catch(Exception e){}
            System.out.println("Job executed asynchronously!");
        };
        Thread t = new Thread(job);
        t.start();
    }
}
