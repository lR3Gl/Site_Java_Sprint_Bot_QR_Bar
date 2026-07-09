package org.example;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorQR {
    public ServidorQR() {
        try {
            LocateRegistry.createRegistry(1200);
            GeneradorQRImp impl = new GeneradorQRImp();
            Naming.rebind("rmi://localhost:1200/QrService", impl);
            System.out.println("Servidor QR listo en puerto 1200");
        } catch (Exception e) {
            System.err.println("Error servidor QR");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServidorQR();
    }
}