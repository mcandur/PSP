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
    
    private boolean[] rechazados = new boolean[11]; //boolean de 11 posiciones donde se controlan los coches rechazados

    public synchronized boolean llegarCoche(int id) throws InterruptedException{
        
        if(mecanicoDormido){
            mecanicoDormido = false;
            actual = id;
            notifyAll();
        }
        if(plazasOcupadas <5){
            plazas[plazasOcupadas] = id; //insertamos el id en el lugar que sería el contador de las plazas ocupadas
            plazasOcupadas++;
            System.out.println("El coche " + id + "entra. " + plazasOcupadas + "/5" );
        }
        
        System.out.println("Todas las plazas estan ocupdas, el coche se va.");
        cochesTerminados ++;
        rechazados[id] = true; // ponemos en el array de rechazados al coche que no ha podido entrar en el parking

        return false;
        
       
    }
    //si llegacoche es true se ejecuta terminarreparacion, 
    
    
    public synchronized void terminarReparacion() throws  InterruptedException{ //(int id)
        
        reparados[actual] = true; //no esta declarado reparados
        cochesTerminados++;
        if(plazasOcupadas > 0){
            actual = plazas[0];
            for (int i = 0; i < plazasOcupadas; i++) {
                plazas[i] = plazas[i+1];
            }
            plazasOcupadas--;
            plazas[plazasOcupadas] = 0;
        }
        else{
            actual = 0;
            ocupado = false; //no esta declarado ocupado
        }
        notifyAll();
        
        
//        if(id == actual){
//           Thread.sleep(200);
//           actual = plazas[0]; 
//        }else{
//            wait();
//        }
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
    
    //el mecánico espera hasta tener un coche
    public synchronized int cogerCoche() throws InterruptedException{
        while(!mecanicoDormido && cochesTerminados <10){
            System.out.println("Mecánico durmienod");
            wait();
        }
        return actual;
    }
    
    
    
    
    //cada coche espera hasta estar reparado
    public synchronized boolean esperar(int numero){
        if (rechazados[numero]){ // si el coche esta en rechazados
            return false;
        }
        
//        while(!reparados[numero]){ // si el coche esta siendo reparado no se puede ir del taller hasta q acabe su reparación
//            wait();
//        }
        
        return true;
    }
    

    
    
}
