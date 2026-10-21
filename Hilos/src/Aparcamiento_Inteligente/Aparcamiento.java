/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aparcamiento_Inteligente;

/**
 *
 * @author 2DAM
 */
public class Aparcamiento {

    private int maxPlazas = 3;
    private int dispoPlazas = 3;

    public synchronized void entrar(String coche) throws InterruptedException {
        while (dispoPlazas == 0) {
            System.out.println(coche + " espera\nAparcamiento completo.");
            wait();
        }
        dispoPlazas--;
        System.out.println(coche + " entra\nPlazas libres: " + dispoPlazas);
    }

    public synchronized void salir(String coche) {
        dispoPlazas++;
        System.out.println(coche + " sale\nPlazas libres: " + dispoPlazas);
        notify();
    }
}
