/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programa1;

/**
 *
 * @author 2DAM
 */
public class Restador implements Runnable {

    private String name;
    private Contador c;

    public Restador(String name, Contador c) {
        this.name = name;
        this.c = c;

    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 300; i++) {
                // System.out.println(name + " " + c.valor());
                c.decrementa();
               
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
        }

    }

}
