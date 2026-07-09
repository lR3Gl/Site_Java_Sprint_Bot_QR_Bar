package QrDual.com.QrDualClientSpring.controller;

import QrDual.com.QrDualClientSpring.service.QrServiceRemote;
import QrDual.com.QrDualClientSpring.service.BarraServiceRemote;
import org.example.GeneradorBarra;
import org.example.GeneradorQR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

@Controller
public class QrDualController {

    private final GeneradorQR qrService;
    private final GeneradorBarra barraService;

    @Autowired
    public QrDualController(GeneradorQR qrServiceRemote, GeneradorBarra barraServiceRemote) {
        this.qrService = qrServiceRemote;
        this.barraService = barraServiceRemote;
    }

    @PostMapping("/generarQr")
    @ResponseBody
    public byte[] generarQr(@RequestParam String texto) {
        try {
            return qrService.generarQR(texto, 300, 300); // Usa tamaño fijo o configurable
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/generarBarra")
    @ResponseBody
    public byte[] generarBarra(@RequestParam String texto) {
        try {
            return barraService.generarBarra(texto, 300, 100); // Usa tamaño fijo o configurable
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}

