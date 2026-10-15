package UD1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GestorProcesosAvanzado {
    public static void main(String[] args) {
        //Ejecutar tres utilizades distintas de window
    
        // Lanza, además, dos procesos ping -n 4: uno a www.microsoft.com y otro a www.apple.com.
        // Inicia todos los procesos antes de esperar a cualquiera de ellos.
        // Identifica en pantalla la salida de cada ping y muestra solo sus tres primeras líneas. Sigue leyendo las restantes en segundo plano para que el proceso pueda terminar
        try {

            String pingMicrosoft = "ping -n 4 www.microsoft.com";
            String pingApple = "ping -n 4 www.apple.com";
            //Ejecutar los comandos
            Process procesoMicrosoft = Runtime.getRuntime().exec(pingMicrosoft);
            Process procesoApple = Runtime.getRuntime().exec(pingApple);
            //Leer los comandos
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(procesoMicrosoft.getInputStream())
            );
            String linea;
            int contador = 0;
            while((linea = reader.readLine())!= null){
                if(contador <4){
                    System.out.println(linea); 
                }
                contador++; 
            }

            BufferedReader reader2 = new BufferedReader(
                new InputStreamReader(procesoApple.getInputStream())
            );
            String linea2;
            int contador2 = 0;
            while((linea2 = reader2.readLine())!= null){
                if(contador2 <4){
                    System.out.println(linea2); 
                }
                contador2++; 
            }

            procesoMicrosoft.waitFor();
            procesoApple.waitFor();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        





    }
    
}
