/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbareía;

/**
 *
 * @author 2DAM
 */
public class Main {
    public static void main(String[] args) {
        int cantClientes = 10;
        int capacidad = 4;
        
        
        
        Barbería b = new Barbería(capacidad, cantClientes);
        Barbero barbero = new Barbero(b);
        barbero.start();
    
        for (int i = 1; i<= cantClientes; i++){
            String nombre =  "Cliente " + i;
            Cliente cliente = new Cliente(b, nombre);
            cliente.start();          
        } 
        
        
        
    }
      
    
    
}
