package QrDual.com.QrDualClientSpring.rmi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

public class AutoReconnectProxy {

    public static <T extends Remote> T create(String url, Class<T> iface) {
        AtomicReference<T> stubRef = new AtomicReference<>(connect(url, iface));

        InvocationHandler handler = (proxy, method, args) -> {
            T stub = stubRef.get();
            try {
                return method.invoke(stub, args);
            } catch (Exception e) {
                System.err.println("⚠️ Error RMI, intentando reconectar: " + url);
                e.printStackTrace();
                T newStub = connect(url, iface);
                if (newStub != null) {
                    stubRef.set(newStub);
                    return method.invoke(newStub, args);
                } else {
                    throw new RemoteException("No se pudo reconectar con " + url, e);
                }
            }
        };

        return (T) Proxy.newProxyInstance(
                iface.getClassLoader(),
                new Class[]{iface},
                handler
        );
    }

    private static <T extends Remote> T connect(String url, Class<T> iface) {
        try {
            return (T) Naming.lookup(url);
        } catch (Exception e) {
            System.err.println("❌ Falló la conexión inicial a " + url);
            return null;
        }
    }
}
