/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos.Niveles;

/**
Nivel 1 – Crear y arrancar un hilo
 Crea una clase que implemente Runnable y que imprima números del 1
 al 5 con pausas de 1 segundo entre cada número. Arranca el hilo desde
 el método main() usando new Thread(...).start().
*/
public class nivel1 implements Runnable {
    private int contador = 0;

    
    @Override
    public void run() {
        while(contador <= 5){
            System.out.println(contador);
            contador ++;
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                
            }
        }
    }
    
    public static void main(String[] args) {
        nivel1 tarea = new nivel1();
        Thread hilo = new Thread(tarea);
        hilo.start();
        
    }
    
}
