/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impresora;

/**
 *
 * @author 2DAM
 */
public class Empleado extends Thread{
    
    Impresora impresora;
    String documento;
    
    public Empleado(Impresora impresora, String documento){
        this.documento = documento;
        this.impresora = impresora;
    }
    
    @Override
    public void run(){
        
        impresora.imprimir(documento, 5);
        
    }
    
}
