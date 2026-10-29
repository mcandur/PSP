/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbareía;

/**
 *
 * @author 2DAM
 */
public class Barbería {
    
    private int capacidad;
    private int cantidadClientes;
    private int clientesDentro = 0;
    private boolean barberoDormido = false;
    private int clientesPendientes = 0;
    
    private int clientesTerminados = 0;

    public Barbería(int capacidad, int cantidadClientes) {
        this.capacidad = capacidad;
        this.cantidadClientes = cantidadClientes;
    }
    
    
    public synchronized void llegaCliente(String nombre) throws InterruptedException{
        System.out.println("Cliente " + nombre + " llega");
        while(clientesDentro == capacidad){
            System.out.println("Cliene " + nombre + " espera fuera." );
            wait();
        }
        
        System.out.println("Cliente " + nombre + " entra (" + clientesDentro + "/" + capacidad + ")");
        clientesDentro ++;
        clientesPendientes ++;
        
        if(barberoDormido){
            System.out.println("El cliente despierta al barbero");
            barberoDormido = false;
            notifyAll();
        }
    }
    
    public synchronized void esperarClientes()throws InterruptedException{
        while(clientesPendientes == 0){    
            barberoDormido = true;
            System.out.println("Barbero dormido");
            wait();
        }
      
        barberoDormido = false;
        clientesPendientes --;
    }
    
    public synchronized void terminarCorte() throws InterruptedException{
        clientesDentro --;
        System.out.println("Barbero termina un corte " + ("-  clientes dentro: ") + clientesDentro);
        clientesTerminados ++;
        notifyAll();
    }
    
    public synchronized boolean cerrarTienda(){
        return clientesTerminados == cantidadClientes;
    }
    
    
}
