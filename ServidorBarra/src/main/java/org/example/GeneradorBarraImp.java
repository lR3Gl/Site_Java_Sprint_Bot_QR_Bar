package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.imageio.ImageIO;

public class GeneradorBarraImp extends UnicastRemoteObject implements GeneradorBarra {

    protected GeneradorBarraImp() throws RemoteException {
        super();
    }

    @Override
    public byte[] generarBarra(String texto, int ancho, int alto) throws RemoteException {
        try {
            Code128Writer writer = new Code128Writer();
            BitMatrix bitMatrix = writer.encode(texto, BarcodeFormat.CODE_128, ancho, alto);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RemoteException("Error generando barra", e);
        }
    }
}