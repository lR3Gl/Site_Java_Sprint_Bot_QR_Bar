package org.example;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorBarra {
    public ServidorBarra() {
        try {
            LocateRegistry.createRegistry(1300);
            GeneradorBarraImp impl = new GeneradorBarraImp();
            Naming.rebind("rmi://localhost:1300/BarraService", impl);
            System.out.println("Servidor Barra listo en puerto 1300");
        } catch (Exception e) {
            System.err.println("Error servidor Barra");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServidorBarra();
    }
}
