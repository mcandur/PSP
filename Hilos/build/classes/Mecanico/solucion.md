
class Taller {

    int[] cola = new int[5];

    boolean[] reparados = new boolean[11];
    boolean[] rechazados = new boolean[11];

    int esperando = 0;
    int actual = 0;
    int terminados = 0;

    boolean ocupado = false;

    // Un coche intenta entrar
    public synchronized boolean entrar(int numero) {

        if (!ocupado) {
            ocupado = true;
            actual = numero;

            System.out.println("Coche " + numero + " entra directamente");
            notifyAll();
            return true;
        }

        if (esperando < 5) {
            cola[esperando] = numero;
            esperando++;

            System.out.println("Coche " + numero + " aparca");
            return false;
        }

        rechazados[numero] = true;
        terminados++;

        System.out.println("Coche " + numero + " rechazado");
        return false;
    }

    // El mecanico espera hasta tener un coche
    public synchronized int cogerCoche() throws InterruptedException {

        while (!ocupado && terminados < 10) {
            System.out.println("Mecanico durmiendo...");
            wait();
        }

        return actual;
    }

    // El mecanico termina la reparacion
    public synchronized void terminar() {

        reparados[actual] = true;
        terminados++;
        notifyAll();

        if (esperando > 0) {

            actual = cola[0];

            for (int i = 0; i < esperando - 1; i++) {
                cola[i] = cola[i + 1];
            }

            esperando--;
            cola[esperando] = 0;

        } else {
            actual = 0;
            ocupado = false;
        }

   
    }

    // Cada coche espera hasta estar reparado
    public synchronized boolean esperar(int numero)
            throws InterruptedException {

        if (rechazados[numero]) {
            return false;
        }

        while (!reparados[numero]) {
            wait();
        }

        return true;
    }
}


class Coche extends Thread {

    int numero;
    Taller taller;

    public Coche(int numero, Taller taller) {
        this.numero = numero;
        this.taller = taller;
    }

    public void run() {

        try {
            // Tiempo aleatorio de llegada
            Thread.sleep((int)(Math.random() * 3000));

            System.out.println("Llega coche " + numero);

            taller.entrar(numero);

            if (taller.esperar(numero)) {
                System.out.println("Coche " + numero + " reparado y se va");
            } else {
                System.out.println("Coche " + numero + " se va sin reparar");
            }

        } catch (InterruptedException e) {
            System.out.println("Error en coche " + numero);
        }
    }
}


class Mecanico extends Thread {

    Taller taller;

    public Mecanico(Taller taller) {
        this.taller = taller;
    }

    public void run() {

        try {
            while (true) {

                int numero = taller.cogerCoche();

                if (numero == 0) {
                    break;
                }

                System.out.println("Mecanico reparando coche " + numero);

                // Tiempo aleatorio de reparacion
                Thread.sleep(1000 + (int)(Math.random() * 2000));

                System.out.println("Mecanico termina coche " + numero);

                taller.terminar();
            }

            System.out.println("Mecanico termina su jornada");

        } catch (InterruptedException e) {
            System.out.println("Error en mecanico");
        }
    }
}


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Taller taller = new Taller();

        Mecanico mecanico = new Mecanico(taller);
        mecanico.start();

        Coche[] coches = new Coche[10];

        // Crear y arrancar los 10 coches
        for (int i = 0; i < 10; i++) {
            coches[i] = new Coche(i + 1, taller);
            coches[i].start();
        }

        // Esperar a que terminen todos los coches
        for (int i = 0; i < 10; i++) {
            coches[i].join();
        }

        mecanico.join();

        System.out.println("SIMULACION FINALIZADA");
    }
}