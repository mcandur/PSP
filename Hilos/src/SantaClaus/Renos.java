/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SantaClaus;

/**
 *
 * @author 2DAM
 */
public class Renos extends Thread{
    Taller taller;
    private int id;
    
    public Renos(int id, Taller taller){
        this.id = id;
        this.taller = taller;
    }
    
    @Override
    public void run(){
        System.out.println("Renos de vacaciones");
        
        taller.llegarReno(id);
        
    }
    
}
