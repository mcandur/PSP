/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programa1;

/**
 *
 * @author 2DAM
 */
public class pruebas {
    public static void main(String[] args) throws InterruptedException {
        Contador c1 = new Contador(100);
        Sumador s1 = new Sumador("Sumador", c1);
        Restador r1 = new Restador("Restador", c1);
        
        Thread hSum = new Thread(s1);
        Thread hRes = new Thread(r1);
        
        hSum.start();
        hRes.start();
        hSum.join();
        hRes.join();
        System.out.println(c1.valor());
        
        
    }
    
}
