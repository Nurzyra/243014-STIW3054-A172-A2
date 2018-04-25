    
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;

public interface Git{

     public static void githubpush(){
        try {

            ProcessBuilder builder = new ProcessBuilder(
             "cmd.exe", "/c", "cd && cd \"C:\\Users\\User\\243014-STIW3054-A172-A2.wiki\" && git add * && git commit -m \"Test\" && git pull && git push");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            System.out.println("\nResult : \n");
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            sleep(5000);
        } catch (Exception e) {
            System.out.println("Terminal having problem to run");
        }
    }

}

