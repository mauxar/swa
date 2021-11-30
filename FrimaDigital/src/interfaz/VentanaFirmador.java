package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Controlador;



    public class VentanaFirmador extends JFrame implements ActionListener{


            public static final String SUBIR_ARCHIVO = "INSERTAR ARCHIVO";
            public static final String FIRMAR_ARCHIVO = "FIRMAR ARCHIVO";

            private JPasswordField passFieldContrasena;
            private JTextField txtNombreDocumento;

            private Inicio inicio;
            private String rutaArchivo;

            public VentanaFirmador(Inicio inicio) 
            {

                    this.inicio = inicio;
                    rutaArchivo="";

                    setTitle("Firmar");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setSize(522, 300);
                    setLocationRelativeTo (null);
                    JPanel contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    contentPane.setLayout(null);

              
                    JButton butSubirDocumento = new JButton("Insertar archivo");
                    butSubirDocumento.setActionCommand(SUBIR_ARCHIVO);
                    butSubirDocumento.addActionListener((ActionListener) this);
                    butSubirDocumento.setBounds(165, 10, 150, 60);
                    contentPane.add(butSubirDocumento);
             

                    passFieldContrasena = new JPasswordField();
                    passFieldContrasena.setBounds(250, 115, 200, 20);
                    contentPane.add(passFieldContrasena);

                    JLabel labIngreseContrasena = new JLabel("Ingrese la clave ",SwingConstants.CENTER);

                    labIngreseContrasena.setBounds(50, 100, 200, 50);
                    contentPane.add(labIngreseContrasena);

                    
                    JButton butFirmarDocumento = new JButton("Firmar");
                    butFirmarDocumento.setActionCommand(FIRMAR_ARCHIVO);
                    butFirmarDocumento.addActionListener((ActionListener) this);
                    butFirmarDocumento.setBounds(50, 170, 170, 75);
                    contentPane.add(butFirmarDocumento);
                  

                    txtNombreDocumento = new JTextField();
                    txtNombreDocumento.setEditable(false);
                    txtNombreDocumento.setBounds(160, 80, 158, 20);
                    contentPane.add(txtNombreDocumento);
                    txtNombreDocumento.setColumns(10);


                    JButton butMenuPrincipal = new JButton("Regresar");
                    butMenuPrincipal.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                    inicio.setVisible(true);
                                    dispose();
                            }
                    });
                    butMenuPrincipal.setBounds(300, 170, 170, 75);
                    contentPane.add(butMenuPrincipal);
            }


            public void subirArchivo()
            {
                    JFileChooser fc=new JFileChooser();
                    fc.setDialogTitle("Seleccionar archivo");  

                    int seleccion=fc.showOpenDialog(this);

                    if(seleccion==JFileChooser.APPROVE_OPTION)
                    { 
                        File fichero=fc.getSelectedFile();
                        rutaArchivo = fichero.getAbsolutePath(); 
                        txtNombreDocumento.setText(fichero.getName());

                    }
            }

            public void firmarArchivo()
            {
             
                    String password = new String(passFieldContrasena.getPassword());
                    if(rutaArchivo.equals("") || password.equals(""))
                    {
                            JOptionPane.showMessageDialog(this, "Para firmar debe seleccionar un archivo y especificar el password de la clave privada",
                                            "Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                            Controlador controlador = inicio.getControlador();

                            JOptionPane.showMessageDialog(this, "Seleccione donde quiere guardar la firma");

                    
                            JFileChooser fc = new JFileChooser();
                            fc.setDialogTitle("Guardar archivo");   

                            int seleccion = fc.showSaveDialog(this);

                            if (seleccion == JFileChooser.APPROVE_OPTION) 
                            {
                                File fichero = fc.getSelectedFile();
                                String rutaFirma = fichero.getAbsolutePath();

                          
                                try 
                                {
                                            controlador.firmarArchivo(rutaArchivo, rutaFirma, password);
                                            JOptionPane.showMessageDialog(this, "Firma generada exitosamente","Respuesta",JOptionPane.INFORMATION_MESSAGE);

                                            rutaArchivo = "";
                                            txtNombreDocumento.setText("");
                                            passFieldContrasena.setText(""); 
                                    } 
                                catch (Exception e) 
                                {
                                            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                    }
                            }
                    }
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                    String comando = e.getActionCommand();

                    if(comando.equals(SUBIR_ARCHIVO))
                    {

                            subirArchivo();
                    }
                    else if(comando.equals(FIRMAR_ARCHIVO))
                    {
                            firmarArchivo();
                    }

            }

    }