package QrDual.com.QrDualClientSpring.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface QrServiceRemote extends Remote {
    String generarQR(String texto) throws RemoteException;
}
