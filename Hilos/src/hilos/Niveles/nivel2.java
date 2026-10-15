/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos.Niveles;

/**
 Nivel 2 – Varios hilos trabajando
 Crea dos hilos diferentes utilizando expresiones lambda que impriman
 mensajes distintos en pantalla. Haz que cada uno tenga una pausa de
 diferente duración (por ejemplo, 500 ms y 700 ms) para observar cómo
 los mensajes se intercalan al ejecutarse.
 */
public class nivel2 {
    
    public static void main(String[] args) {
        
        Runnable rnbl1 = () -> {
            for(int i = 0; i < 5; i++){
                System.out.println("RNB 1 -- " + i);
                i++;
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){

                }
            }
        };
        Runnable rnbl2 = () -> {
            for(int i = 0; i <5; i++){
                System.out.println("RNB 2 -- " + i);
                i++;
                try{
                    Thread.sleep(7000);
                }catch (InterruptedException e){

                }
            }
        };
        
     
        Thread hilo1 = new Thread(rnbl1);
        Thread hilo2 = new Thread(rnbl2);

        hilo1.start();
        hilo2.start();
    }
    
}
