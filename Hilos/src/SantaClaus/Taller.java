/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SantaClaus;

/**
 *
 * @author 2DAM
 */
public class Taller {
    public int renosDispo = 0;
    public int elfosDispo = 0;
    
    
    public synchronized void llegarReno(int id){
        renosDispo++;
        System.out.println("Reno " + id + " ha llegado. " + renosDispo +"/9");
        
        if (renosDispo == 9){
            notifyAll();
        }
    }
    
    public synchronized void esperarRenosYElfos() throws InterruptedException{
        while (renosDispo < 9 && elfosDispo <3){
            wait();
        }
        
        System.out.println("Santa despierta");
    }
    
    public synchronized void llegarElfos(int id) throws InterruptedException{
        
        
        while(elfosDispo==3){
            wait();
        }
        
        elfosDispo++;
        System.out.println("Elfo " + id + " está trabajando");
        
        if(elfosDispo == 3){
            notifyAll();
        }
        
     
    }
    

    
    
    
    
}
