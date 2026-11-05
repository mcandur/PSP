/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mecanico;

/**
 *
 * @author 2DAM
 */
public class Mecanico extends Thread{
    
    private Taller taller;

    public Mecanico(Taller taller) {
        this.taller = taller;
    }
    

    @Override
    public void run() {
        try {
            while(true){
                int numero = taller.cogerCoche();
            
                System.out.println("Mecánico reparando coche " + numero);
                Thread.sleep(1000 + (int)(Math.random()*2000));
                System.out.println("Mecánico termina de reparar coche " + numero);
                taller.terminarReparacion(); //
                
            }
            
            
            
            
        } catch (InterruptedException ex) {
            System.getLogger(Mecanico.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
       
    }
    
    
    
}
