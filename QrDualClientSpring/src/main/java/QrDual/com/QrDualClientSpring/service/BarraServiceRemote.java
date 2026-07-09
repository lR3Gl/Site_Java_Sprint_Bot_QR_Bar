package QrDual.com.QrDualClientSpring.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BarraServiceRemote extends Remote {
    byte[] generarCodigoBarra(String texto) throws RemoteException;
}
