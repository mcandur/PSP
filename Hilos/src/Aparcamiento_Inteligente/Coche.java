/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aparcamiento_Inteligente;

import java.time.Duration;

/**
 *
 * @author 2DAM
 */
public class Coche extends Thread{
    
    private Aparcamiento aparcamiento;
    private String nombre;
    
    public Coche(String nombre, Aparcamiento aparcamiento){
        this.nombre = nombre;
        this.aparcamiento = aparcamiento;
    }
    
    @Override
    public void run() {
        try {
        aparcamiento.entrar(getName());

        int tiempo = (int)(Math.random() * 3001) + 2000;
        Thread. sleep(tiempo);

        aparcamiento.salir(getName());

        } catch (InterruptedException e) {
        System.out.println("Error en "+ getName());

        }
       
    }
    
}
