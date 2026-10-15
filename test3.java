
public class test3 {
    public static void main(String[] args) {
        try {
            String comando = "ping -n 2 www.google.com";
            Process[] procesos = new Process[3];
        // Lanzar 3 procesos ping en paralelo
        for (int i = 0; i < procesos.length; i++) {
            procesos[i] = Runtime.getRuntime().exec(comando);
            System.out.println("Proceso " + (i+1) + " lanzado.");
        }
        // Esperar a que todos los procesos terminen
        for (int i = 0; i < procesos.length; i++) {
            int exitVal = procesos[i].waitFor();
            System.out.println("Proceso " + (i+1) + " terminó con estado: " + exitVal);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
