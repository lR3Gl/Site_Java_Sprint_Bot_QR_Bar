package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.imageio.ImageIO;

public class GeneradorQRImp extends UnicastRemoteObject implements GeneradorQR {

    protected GeneradorQRImp() throws RemoteException {
        super();
    }

    @Override
    public byte[] generarQR(String texto, int ancho, int alto) throws RemoteException {
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(texto, BarcodeFormat.QR_CODE, ancho, alto);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            return baos.toByteArray();
        } catch (WriterException | java.io.IOException e) {
            throw new RemoteException("Error generando QR", e);
        }
    }

    @Override
    public void generarCodigo(String texto) throws RemoteException {

    }
}
