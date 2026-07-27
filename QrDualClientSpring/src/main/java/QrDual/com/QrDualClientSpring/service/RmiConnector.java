package QrDual.com.QrDualClientSpring.service;

import java.rmi.Naming;

public class RmiConnector {

    @SuppressWarnings("unchecked")
    public static <T> T conectar(String url, Class<T> clase) {
        try {
            Object obj = Naming.lookup(url);
            return (T) obj;
        } catch (Exception e) {
            System.err.println(" No se pudo conectar con el servidor: " + url);
            e.printStackTrace();
            return null;
        }
    }
}
