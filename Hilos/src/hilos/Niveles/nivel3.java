/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos.Niveles;

/**
Nivel 3 – Comprobar el estado de un hilo
 Crea un hilo que tarde unos segundos en terminar (usando
 Thread.sleep()). Usa el método isAlive() para comprobar si el hilo sigue
 en ejecución antes, durante y después de que finalice. Utiliza también
 join() para esperar a que termine.
 * 
 */
public class nivel3 implements Runnable{
    

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e) {}

    }
    
    public static void main(String[] args) {
        nivel3 tarea = new nivel3();
        Thread hilo = new Thread(tarea);
        System.out.println(hilo.isAlive());
        hilo.start();
        System.out.println(hilo.isAlive());        
        
       
        try{ // esperar a que termine
            hilo.join();
        }catch(InterruptedException e){
        }
        
        System.out.println(hilo.isAlive()); 
        
        
    }
    
}
