/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centro2;

/**
 *
 * @author 2DAM
 */
public class CentroDigitalizacion {
    
    int[] bandeja = new int[3];
    
    int docsEnBandeja = 0;
    int depositadosTotal = 0;
    int actual = 0;
    int terminados  = 0;
    
    boolean ocupado = false;
    
    boolean[] digitalizados = new boolean[4];
    
    public synchronized boolean entregarDocumento(int id) throws InterruptedException{
        if (!ocupado) {
            ocupado = true;
            actual = id;
            notifyAll();
            return true;
        }
        
        if(docsEnBandeja <3){
            bandeja[docsEnBandeja] = id;
            
        }
        while(docsEnBandeja == 3){
            wait();
        }
        
        bandeja[docsEnBandeja] = id;
        docsEnBandeja++;
        depositadosTotal ++;
        notifyAll();
        return false;
        
        
        
    }
    
    public synchronized int cogerDocs() throws InterruptedException{
        while(docsEnBandeja == 0 && depositadosTotal <=12){
            wait();
        }
        
        return actual;
    }
    
    public synchronized void terminarDigitalizacion(){
        digitalizados[actual]= true;
        terminados ++;
        notifyAll();
        
        if(docsEnBandeja >0){
            actual = bandeja[0];
            for (int i = 0; i < docsEnBandeja; i++) {
                bandeja[i] = bandeja[i+1];
            }
            
           docsEnBandeja --;
           bandeja[docsEnBandeja] = 0;
        }else{
            actual = 0;
            ocupado = false;
        }
        
        
    }
    
    
    
    
    
    
}
