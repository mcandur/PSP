
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test2 {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("ping", "-n", "3", "www.google.com");
            Process proceso = pb.start();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(proceso.getInputStream())
            );
            String linea;
            while((linea = reader.readLine())!= null){
                System.out.println(linea);
            }
            int exitCode = proceso.waitFor();
            System.out.println("El proceso terminó con el código: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
