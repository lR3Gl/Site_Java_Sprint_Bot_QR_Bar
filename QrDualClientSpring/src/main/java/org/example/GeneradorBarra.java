package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GeneradorBarra extends Remote {
    byte[] generarBarra(String texto, int ancho, int alto) throws RemoteException;
}