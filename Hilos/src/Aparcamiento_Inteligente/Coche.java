/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aparcamiento_Inteligente;

import java.time.Duration;

/**
 *
 * @author 2DAM
 */
public class Coche extends Thread{
    
    Aparcamiento aparcamiento;
    
    public Coche(Aparcamiento aparcamiento){
        this.aparcamiento = aparcamiento;
    }
    
    @Override
    public void run(){
        System.out.println("Intenta entrar en el aparcamiento");
        synchronized(aparcamiento){
            while(aparcamiento.dispoPlazas <= aparcamiento.maxPlazas){
            try{
                aparcamiento.wait();
                System.out.println("Aparcamiento completo");
            }catch(InterruptedException ex){}
        }
        aparcamiento.entrar("");
            
        }
        
        
        System.out.println("Ha entrado al aparcamiento");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){}
        
        aparcamiento.salir("");
        System.out.println("Ha salido del aparcamiento");
        
        
        
    }
    
}
