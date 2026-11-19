/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centrodigitalizacion;

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
    public void run() {
        while(true){
            try {
                int id;
                while ((id = centro.siguienteDoc()) != 0) {
                    Thread.sleep((int) (Math.random() * 400) + 100);   
                    centro.terminarImpresion(id);
                    System.out.println("Documento del usuario " + id + " terminado");
                }

            } catch (InterruptedException ex) {
                System.getLogger(Escaner.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }

    
    
    
    
    
}
