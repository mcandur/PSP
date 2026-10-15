/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Horno;

/**
 *
 * @author 2DAM
 */
public class Main {
    public static void main(String[] args) {
        Horno horno = new Horno();
        
        Cocinero c1 = new Cocinero(horno, "c1");
        Cocinero c2 = new Cocinero(horno, "c2");
        Cocinero c3 = new Cocinero(horno, "c3");
        
        Thread h1 = new Thread(c1);
        Thread h2 = new Thread(c2);
        Thread h3 = new Thread(c3);
        
        h1.start();
        h2.start();
        h3.start();
        
        
    }
    
}
