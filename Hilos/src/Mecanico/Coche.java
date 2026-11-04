/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mecanico;

/**
 *
 * @author 2DAM
 */
public class Coche extends Thread{
    private int id;
    private Taller taller;

    public Coche(int id, Taller taller) {
        this.id = id;
        this.taller = taller;
    }
    
    
    
    @Override
    public void run() {
        int tiempo = (int)(Math.random() * 3001) + 2000;
        try {
            Thread.sleep(tiempo);
            taller.llegarCoche(id);
            

        } catch (InterruptedException e) {
            interrupt();
        }

       
    }
    
}
