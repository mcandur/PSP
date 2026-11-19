/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centro2;

/**
 *
 * @author 2DAM
 */
public class Escaner extends Thread{
    CentroDigitalizacion centro;
    int capacidad = 3;

    public Escaner(CentroDigitalizacion centro) {
        this.centro = centro;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                int id = centro.cogerDocs();
                Thread.sleep(1000 + (int)(Math.random() * 2000)); 
                centro.terminarDigitalizacion();

            }catch(InterruptedException e){
                
            }
        }
    }
    
    
}
