/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centrodigitalizacion;

/**
 *
 * @author 2DAM
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        CentroDigitalizacion centro = new CentroDigitalizacion();
    
        Escaner escaner = new Escaner(centro);

        escaner.start();
        
        Usuario[] user = new Usuario[12];
         for (int i = 0; i < 12; i++) {
            user[i] = new Usuario(i + 1, centro);
            user[i].start();
        }
        for (int i = 0; i < 12; i++) {
            user[i].join();
        }
        
        System.out.println("SIMULACIÓN FINALIADA");
        

        
    }
        
    
    
}
