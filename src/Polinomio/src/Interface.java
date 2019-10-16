import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote{
    public int[] sumar(int[] pA, int[] pB) throws RemoteException;
    public int[] restar(int[] pA, int[] pB) throws RemoteException;
    public int[] multiplicar(int[] pA, int[] pB) throws RemoteException;
}
