public class test1 {
    public static void main(String[] args) {
        try {
            Process proceso = Runtime.getRuntime().exec("notepad.exe");
            proceso.waitFor();
            System.out.println("El proceso notepad ha terminado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
