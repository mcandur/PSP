/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;

/**
 *
 * @author 2DAM
 */
public class Coche  extends Thread{
    private String nombre;
    private int dorsal;
    private int distancia;
    
    
    public Coche(String nombre, int dorsal, int distancia){
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.distancia = 20;
    }
    
    @Override
    public void run(){
        int cont =0;
        while(distancia > cont){
            System.out.println(dorsal + " " + nombre + " - posicion " + (cont+1));
            cont++;
        }
        System.out.println("META: " + "[" + dorsal + "]"+ nombre);
        
        
    }
    
    public static void main(String[] args) {
        Coche Ferrari = new Coche("Ferrari", 7, 8);
        Coche Mercedes = new Coche("Mercedes", 3, 8);
        Coche RedBull = new Coche("Red Bull", 1, 8);
        Coche McLaren = new Coche("McLaren",4, 8);
        
        System.out.println(" === Comienza la carrera === ");
        
        
        Ferrari.start();
        Mercedes.start();
        RedBull.start();
        McLaren.start();
        
        
        System.out.println(" === Todos los coches han salido === ");
        
        
        
        
    }
}


