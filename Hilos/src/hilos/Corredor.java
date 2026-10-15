/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;

/**
 *
 * @author 2DAM
 */
public class Corredor implements Runnable{
    private String nombre;
    
    private int contador = 0;
    
    public Corredor(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while(contador <= 5){
            System.out.println(nombre + contador);
            contador ++;
        }
    }
    
    public static void main(String[] args) {
        Corredor corredor1 = new Corredor("Pepe");
        Corredor corredor2 = new Corredor("Ana");
        Thread hilo1 = new Thread(corredor1);
        Thread hilo2 = new Thread(corredor2);
        
        hilo1.start();
        hilo2.start();
        
    }
    
    
}
