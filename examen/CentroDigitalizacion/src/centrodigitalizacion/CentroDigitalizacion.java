/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package centrodigitalizacion;

/**
 *
 * @author 2DAM
 */
public class CentroDigitalizacion {
    //private int[] documentos = new int[3];
    
    int docsEnBandeja = 0;
    
    int[] idPorTurno = new int[3];
    int siguienteTurno = 0;
    int esperando = 0;
    int digitalizados = 0;
    private int proximoAtender = 0;
    boolean ocupado = false;
    
 

    

    public CentroDigitalizacion() {
    }
    
    public synchronized int entregarDocumento(int id) throws InterruptedException{
        if (esperando == 3){
             System.out.println("Usuario " + id + " espera: bandeja llena" );
        }
        while(esperando == 3){
            wait();
            
        }
        int miTurno = siguienteTurno++;
        idPorTurno[miTurno] = id;
        esperando++;
        System.out.println("Usuario " + id + "deposita el documento " + id + ". Bandeja: " + esperando +  "/3");
        
        if(!ocupado){
            ocupado = false;
        }
        notifyAll();     
        return miTurno;
    }
    
    public synchronized void terminarImpresion(int id){
        
        digitalizados++;
        docsEnBandeja--;
        ocupado = false;
        notifyAll();
        
    }    
    
    public synchronized int siguienteDoc() throws InterruptedException {
        while (esperando == 0 && digitalizados < 12) {
            wait();
        }
        if (esperando == 0) {
            return 0;                       
        }
        int id = idPorTurno[proximoAtender];
        proximoAtender++;
        esperando--;                       
        ocupado = true;
       
        notifyAll();                        
        return id;
    }

    
    
    
    public synchronized void esperarDocs(int miTurno, int id) throws InterruptedException {
        while (digitalizados <= miTurno) {    
            wait();
        }
        
    }
    
    
}
