package QrDual.com.QrDualClientSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class QrDualClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(QrDualClientApplication.class, args);
        System.out.println("🚀 Cliente Spring Boot iniciado en http://localhost:8080");
    }
}

