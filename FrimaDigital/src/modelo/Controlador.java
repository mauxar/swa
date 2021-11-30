package modelo;

import java.security.KeyPair;



public class Controlador {

            private GeneradorDeClaves generador;
            private Firmador firma;
            private Verificador verificador;
            
            public Controlador() 
            {
                try
                {
                    generador = new GeneradorDeClaves();
                    firma= new Firmador();
                    verificador = new Verificador();
                }
                catch(Exception e)
                {
                            
                }
        }

        public void generarClave(String password)
        {
            generador.generarClave(password);
                    
            }
            
        public void firmarArchivo(String rutaArchivo,String rutaFirma, String passwordKeyPair) throws Exception
            {
                KeyPair parDeClaves = generador.getClaves().get(passwordKeyPair);
                if(parDeClaves==null)
                {
                        throw new Exception("No existe una clave privada guardada con el password especificado");
                }
                else
                    {
                firma.firmarArchivo(rutaArchivo, parDeClaves.getPrivate(),rutaFirma);
            }
        }

            public boolean validarFirma(String rutaArchivo, String rutaFirma, String rutaClavePublica) throws Exception
    {
            return verificador.validarFirma(rutaArchivo, rutaFirma, rutaClavePublica);
    }

    public void exportarClavePublica(String rutaClavePublica, String passwordKeyPair) throws Exception
           {
                   generador.exportarClavePublica(rutaClavePublica, passwordKeyPair);
	}

}