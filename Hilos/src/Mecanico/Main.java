/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mecanico;

import barbareía.Cliente;

/**
 *
 * @author 2DAM
 */
public class Main {
    public static void main(String[] args) {
        Taller taller = new Taller();
        Mecanico b = new Mecanico(taller);
        b.start();
        
        for (int i = 1; i<= 10; i++){
            int id = i;
            Coche c = new Coche(id, taller);
            c.start();
        } 
        
    }
    
}
