/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos.Niveles;

/**
Crea una clase que implemente Runnable y que, en su método run(), imprima un contador 
del 1 al 5 junto con el nombre del hilo y su prioridad actual.
Desde el método main():
Crea tres hilos (Thread) a partir de la misma tarea (Runnable).
Asigna a cada hilo una prioridad diferente:
Hilo 1 → Thread.MIN_PRIORITY
Hilo 2 → Thread.NORM_PRIORITY
Hilo 3 → Thread.MAX_PRIORITY
Muestra por consola el nombre y la prioridad de cada hilo antes de arrancarlos.
Arranca los tres hilos casi al mismo tiempo.
Una vez iniciados, cambia la prioridad de alguno de ellos en tiempo de ejecución usando setPriority() (por ejemplo, subir o bajar su prioridad mientras los demás siguen ejecutándose).
Observa los resultados y repite la ejecución varias veces para comparar.
 */

//COMPROBAR QUE ESTÉ BIEN
public class nivel4  implements Runnable{
    private int contador = 0;
    private String nombre;
   
    
    
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int threadPriority = Thread.currentThread().getPriority();
        while(contador <= 5){
            //System.out.println(Thread.currentThread().getName());
            System.out.println(contador + " - " + threadName + " - " + threadPriority);
            contador ++;
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){}
        }    
    }
    
    public static void main(String[] args) {
        nivel4 t1 = new nivel4();
        Thread h1 =new Thread(t1);
        h1.setName("hilo 1");
        h1.setPriority(Thread.MIN_PRIORITY);
        
        nivel4 t2 = new nivel4();
        Thread h2 = new Thread(t2);
        h2.setName("hilo 2");
        h2.setPriority(Thread.NORM_PRIORITY);
        
        nivel4 t3 = new nivel4();
        Thread h3 = new Thread(t3);
        h3.setName("hilo 3");
        h3.setPriority(Thread.MAX_PRIORITY);
        
        h1.start();
        h2.start();
        h1.setPriority(Thread.MIN_PRIORITY);
        h3.start();
        
        
        
    }
    
}
