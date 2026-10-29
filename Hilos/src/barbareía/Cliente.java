/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbareía;

/**
 *
 * @author 2DAM
 */
public class Cliente extends Thread{
    private Barbería barberia;
    private String nombre;

    public Cliente(Barbería barberia, String nombre) {
        this.barberia = barberia;
        this.nombre = nombre;
    }
    
    @Override
    public void run(){
        int tiempo = (int)(Math.random() * 3001) + 2000;
        try {
            Thread.sleep(tiempo);
            barberia.llegaCliente(nombre);

        } catch (InterruptedException e) {
            interrupt();
        }
        

        
    }
    
    
}
