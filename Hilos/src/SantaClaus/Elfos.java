/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SantaClaus;

/**
 *
 * @author 2DAM
 */
public class Elfos extends Thread{
    private int id;
    Taller taller;
    
    public Elfos(int id, Taller taller){
        this.id = id;
        this.taller = taller;
        
    }
    
    @Override
    public void run(){
        
        try {
            taller.llegarElfos(id);
        } catch (InterruptedException ex) {
            System.getLogger(Elfos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    
}
