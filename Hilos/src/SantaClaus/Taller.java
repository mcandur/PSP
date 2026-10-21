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
    
    
    public synchronized void llegarReno(int id){
        renosDispo++;
        System.out.println("Reno " + id + " ha llegado. " + renosDispo +"/9");
        
        if (renosDispo == 9){
            notifyAll();
        }
    }
    
    public synchronized void esperarRenos() throws InterruptedException{
        while (renosDispo < 9){
            wait();
        }
        
        System.out.println("Han llegado todos los renos, Santa despierta");
    }
    
}
