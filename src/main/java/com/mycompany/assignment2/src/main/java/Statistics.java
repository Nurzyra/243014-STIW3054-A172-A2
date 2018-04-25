import java.io.IOException;

    public class Statistics implements Read, Count {

    public void run() throws IOException {

       Read.run();
       Count.countcharacter();
       Git.githubpush();
    
    }

    public static void main(String[] args) throws IOException {

        Statistics  obj = new Statistics ();
        double t1 = System.nanoTime();
        obj.run();

        double t2 = System.nanoTime();

        System.out.println("Completing the execution = " + ((t2 - t1) / 1000000000) + " second");

    }

}
