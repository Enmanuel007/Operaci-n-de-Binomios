import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Servidor {
    public Servidor(){
        try {
            System.setProperty("java.rmi.server.codebase", "file:/c:/RMI/src");
            Interface i = new Implementacion();
            Naming.rebind("rmi://localhost/Polinomio", i);
        } catch (RemoteException | MalformedURLException e) {
            System.out.print("Error");
        }
    }
    
    public static void main(String[] args){
        Servidor servidor = new Servidor();
        System.out.println("Servidor en espera");
    }
}
