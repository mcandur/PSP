/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aparcamiento_Inteligente;

/**
 *
 * @author 2DAM
 */
public class Main {
    public static void main(String[] args) {
        Aparcamiento ap = new Aparcamiento();
        
        for (int i = 1; i <= 8; i++) {
            String nombre = "Coche " + i;

            Coche coche = new Coche(nombre, ap);
            coche.start();
        }
        
    }
    
}
