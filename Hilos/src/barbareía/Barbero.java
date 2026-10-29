/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbareía;

/**
 *
 * @author 2DAM
 */
public class Barbero extends Thread{
    
    private Barbería barberia;

    public Barbero(Barbería barberia) {
        this.barberia = barberia;
    }
    
    @Override
    public void run(){
        try {
            while(!barberia.cerrarTienda()){
                barberia.esperarClientes();
            System.out.println("Barbero empieza un corte ");
            int tiempo = (int)(Math.random() * 3001) + 2000;
            Thread.sleep(tiempo);
            barberia.terminarCorte();
                
            }
                
                
            
            
             
           
            
            
            
        } catch (InterruptedException e) {
            interrupt();
        }
    }
    
    
    
}
