package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GeneradorQR extends Remote {
    byte[] generarQR(String texto, int ancho, int alto) throws RemoteException;

    void generarCodigo(String texto) throws RemoteException;
}
