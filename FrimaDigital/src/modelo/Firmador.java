package modelo;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.Signature;

/**
 * Clase que firma documentos 
 */

public class Firmador
{


        public void firmarArchivo(String ruta, PrivateKey clavePrivada, String rutaFirma) throws Exception
    {

                byte[] data = leerArchivo(ruta);
                Signature dsa = Signature.getInstance("SHA1withRSA"); 
                dsa.initSign(clavePrivada);
                dsa.update(data);
                byte[] firma = dsa.sign();
                
                guardarFirma(rutaFirma, firma);
    }

            public byte[] leerArchivo(String ruta) throws Exception
            {
                    return Files.readAllBytes(Paths.get(ruta));
            }
            
            
            public void guardarFirma(String ruta, byte[] firma) throws Exception
            {
                    FileOutputStream fos = new FileOutputStream(ruta);
                    fos.write(firma);
                    fos.close();
            }

}