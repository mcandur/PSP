/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SantaClaus;

/**
 *
 * @author 2DAM
 */
public class SantaClaus extends Thread{
    Taller taller;
    
    public SantaClaus(Taller taller){
        this.taller = taller;
    }
    
    @Override
    public void run(){
        try{
            taller.esperarRenosYElfos();
            System.out.println("Santa reparte los regalos");
            
        }catch(InterruptedException ex){
            interrupt();
        } 
        
        
    }
    
}
