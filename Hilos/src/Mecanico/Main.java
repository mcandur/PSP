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
    public static void main(String[] args) throws InterruptedException {
//        Taller taller = new Taller();
//        Mecanico b = new Mecanico(taller);
//        b.start();
//        
//        for (int i = 1; i<= 10; i++){
//            int id = i;
//            Coche c = new Coche(id, taller);
//            c.start();
//        } 

            Taller taller = new Taller();

            Mecanico mecanico = new Mecanico(taller);
            mecanico.start();

            Coche[] coches = new Coche[10];

            // Crear y arrancar los 10 coches
            for (int i =0; i < 10; i++) {
            coches[i] = new Coche(i + 1, taller);
            coches[i].start();
            }
            // Esperar a que terminen todos los coches
            for (int i= 0; i < 10; i++) {
            coches[i].join();

            }

            mecanico.join();

            System.out.println("SIMULACION FINALIZADA");
        }
    }
    

