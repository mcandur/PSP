/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impresora;

/**
 *
 * @author 2DAM
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //crea una unia impresora, la comparte entre tres empleados y arranca sus hilos.

        Impresora i1 =  new Impresora("Archivo", 10);
        Empleado e1 = new Empleado(i1, "Doc1");
        Empleado e2 = new Empleado(i1, "Doc2");
        Empleado e3 = new Empleado(i1, "Doc3");
        
        Thread h1 = new Thread(e1);
        Thread h2 = new Thread(e2);
        Thread h3 = new Thread(e3);
        
        h1.start();
        h2.start();
        h3.start();
       
        h1.join();
        h2.join();
        h3.join();
        
        
        
    }
    
}
