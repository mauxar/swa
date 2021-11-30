package modelo;

import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class GeneradorDeClaves 
{

    private HashMap<String, KeyPair> claves;

    private KeyPairGenerator generador;


    public GeneradorDeClaves() throws NoSuchAlgorithmException
    {
    generador = KeyPairGenerator.getInstance("RSA");
    generador.initialize(1024);
    claves = new HashMap<>(100);
    }


    public void generarClave(String password)
        {
    claves.put(password, generador.generateKeyPair());
    }
    
    public void exportarClavePublica(String rutaClavePublica, String passwordKeyPair) throws Exception
    {
    KeyPair parDeClaves = claves.get(passwordKeyPair);
    if(parDeClaves==null)
    {
        throw new Exception("No existe una clave publica guardada con el password especificado");
        }
        else
            {
        FileOutputStream fos = new FileOutputStream(rutaClavePublica);
        fos.write(parDeClaves.getPublic().getEncoded());
            fos.close();
              }

    }

        public HashMap<String, KeyPair> getClaves() {
            return claves;
        }

    public void setClaves(HashMap<String, KeyPair> claves) {
                this.claves = claves;
           }

        public KeyPairGenerator getGenerador() {
            return generador;
        }

        public void setGenerador(KeyPairGenerator generador) {
            this.generador = generador;
        }

}