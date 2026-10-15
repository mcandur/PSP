/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programa1;

/**
 *
 * @author 2DAM
 */
public class Contador {
    private int c;
    
    public Contador(int c){
        this.c = c;
    }
    
    public synchronized void incrementa(){
        c++;
        
    }
    
    public synchronized void decrementa(){
        c--;
        
    }
    
    public synchronized int valor(){
        return c;
    }
    
    
    
    
    
}
