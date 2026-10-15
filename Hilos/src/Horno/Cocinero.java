/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Horno;

/**
 *
 * @author 2DAM
 */
public class Cocinero extends Thread{
    Horno horno;
    String nombre;
    
    public Cocinero(Horno horno, String nombre){
        this.horno = horno;
        this.nombre = nombre;
    }
   
    
    @Override
    public void run(){
        System.out.println("Preparando - " + nombre );
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            
        }
        System.out.println("Preparado terminado - " + nombre);
        
        
        
        synchronized (horno) {
            System.out.println("Comenzando horneado " + nombre);
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
            }
            System.out.println("Horneado terminado " + nombre);
        }
        
        
        
        System.out.println("Empaquetando - " + nombre );
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            
        }
        System.out.println("Empaquetado terminado - " + nombre);
        
     
    }
    
}
