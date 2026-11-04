/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mecanico;

/**
 *
 * @author 2DAM
 */
public class Taller {
    private int plazasOcupadas = 0;
    private boolean mecanicoDormido = true;
    private int actual;
    private int[] plazas = new int[5];
    
    private int cochesTerminados = 0;

    public synchronized void llegarCoche(int id) throws InterruptedException{
        
        if(mecanicoDormido){
            mecanicoDormido = false;
            actual = id;
            notifyAll();
        }else if(plazasOcupadas <5){
            plazas[plazasOcupadas] = id;
            plazasOcupadas++;
            System.out.println("El coche " + id + "entra. " + plazasOcupadas + "/5" );
        }else{
            System.out.println("Todas las plazas estan ocupdas, el coche se va.");
            cochesTerminados ++;
        }
       
    }
    //si llegacoche es true se ejecuta terminarreparacion, 
    
    
    public synchronized void terminarReparacion(int id) throws  InterruptedException{
        if(id == actual){
           Thread.sleep(200);
           actual = plazas[0]; 
        }else{
            wait();
        }
        //se puede asi? // si actual es nuestra id, un sleep para terminar la ejecucion y despues cambiar el id de actual al primero de plazas y quitar el q esta en 0, es decir, pasar los array alante, se puede????
    }
    
//    public synchronized void esperarCoches() throws InterruptedException{
//        while(plazasOcupadas == 0){
//            System.out.println("Mecánico dormido, no hay coches");
//            mecanicoDormido = true;
//            wait();
//        }
//        
//        mecanicoDormido = false;
//        //plazasOcupadas++;
//    }
    
    
    

    
    
}
