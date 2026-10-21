/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SantaClaus;

import Aparcamiento_Inteligente.Coche;

/**
 *
 * @author 2DAM
 */
public class Main {
    public static void main(String[] args) {
        Taller taller =  new Taller();
        
        SantaClaus santa = new SantaClaus(taller);
        santa.start();
        
        for (int i = 1; i <= 9; i++) {
           Renos reno = new Renos(i, taller);
           reno.start();
        }
        
    }
    
}
