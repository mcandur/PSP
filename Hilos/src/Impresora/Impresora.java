/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impresora;

/**
 *
 * @author 2DAM
 */
public class Impresora {
    
    String documento;
    int paginas;
    
    public Impresora(String documento, int paginas){
        this.documento = documento;
        this.paginas = paginas;
    }
    
    public void imprimir(String documento, int paginas){
        synchronized(this){
            System.out.println("Comenzando impresión");
            for(int i = 0; i<=paginas;i++){
                System.out.println("Página: " + i + ", " + documento);
                try{
                    Thread.sleep(500);

                }catch (InterruptedException e){

                }
            }
            System.out.println("Imprsión terminada");
        }
        
    }
    
    
    
}
