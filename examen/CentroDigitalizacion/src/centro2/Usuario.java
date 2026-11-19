/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centro2;

/**
 *
 * @author 2DAM
 */
public class Usuario extends Thread{
    int id;
    CentroDigitalizacion centro;

    public Usuario(int id, CentroDigitalizacion centro) {
        this.id = id;
        this.centro = centro;
    }
    
    @Override
    public void run() {
       try{
           Thread.sleep((int) (Math.random() * 300) + 100);   
           centro.entregarDocumento(id);
           
           
       }catch(InterruptedException e){
           interrupt();
           System.out.println(e);
       }
    }
    
}
