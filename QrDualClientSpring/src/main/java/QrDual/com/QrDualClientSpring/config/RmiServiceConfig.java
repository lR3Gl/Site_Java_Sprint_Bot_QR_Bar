package QrDual.com.QrDualClientSpring.config;

import QrDual.com.QrDualClientSpring.rmi.AutoReconnectProxy;
import QrDual.com.QrDualClientSpring.service.RmiConnector;
import org.example.GeneradorBarra;
import org.example.GeneradorQR;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.rmi.Naming;
import java.rmi.Remote;

@Configuration
public class RmiServiceConfig {

    @Bean
    public GeneradorQR qrServiceRemote() {
        return AutoReconnectProxy.create("rmi://localhost:1200/QrService", GeneradorQR.class);
    }

    @Bean
    public GeneradorBarra barraServiceRemote() {
        return AutoReconnectProxy.create("rmi://localhost:1300/BarraService", GeneradorBarra.class);
    }


}
