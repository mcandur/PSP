package UD1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class GestorProcesosAvanzadoTEST {
    public static void main(String[] args) {
        // Ejecuta tres utilidades distintas de Windows. Cada una debe recibir un parámetro que afecte a su ejecución. Puedes usar, por ejemplo, cmd /c dir /b, whoami /user e ipconfig /all; también puedes elegir otras. Anota qué hace cada comando y con qué argumentos lo lanzas.

    
        try {
            //IPCONFIG
            ProcessBuilder pbIP = new ProcessBuilder("ipconfig", "/all");
            Process procesoIP = pbIP.start();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(procesoIP.getInputStream())
            );
            String linea;
            while((linea = reader.readLine())!= null){
                System.out.println(linea);
            }
            procesoIP.waitFor();
            
            //WHOAMI
            ProcessBuilder pbWAI = new ProcessBuilder("whoami", "/user");
            Process procesoWAI = pbWAI.start();
            BufferedReader reader2 = new BufferedReader(
                new InputStreamReader(procesoWAI.getInputStream())
            );
            String linea2;
            while((linea2 = reader2.readLine())!= null){
                System.out.println(linea2);
            }
            procesoWAI.waitFor();
            
            //DIR
            ProcessBuilder pbDIR = new ProcessBuilder("cmd", "/c", "dir","/d");
            Process procesoDIR = pbDIR.start();
            BufferedReader readerDir = new BufferedReader(
                new InputStreamReader(procesoDIR.getInputStream())
            );
            String linea3;
            while((linea3 = readerDir.readLine())!= null){
                System.out.println(linea3);
            }
            procesoDIR.waitFor();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        





    }
    
}
