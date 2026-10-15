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
    int maxPlazas = 3;
    int dispoPlazas = 0;

    public Aparcamiento(int maxPlazas, int dispoPlazas) {
        this.maxPlazas = maxPlazas;
        this.dispoPlazas = dispoPlazas;
    }
    
    
    public void entrar(String Coche){
        dispoPlazas -=1;
        Coche.notify();
        
        
    }
    
    
    public void salir(String Coche){
        dispoPlazas +=1;
         
    }
    
    
    
}
