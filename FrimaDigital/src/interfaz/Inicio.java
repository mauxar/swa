package interfaz;

/*
@Autores Aguirre Gutiérrez Mauricio Alberto y Chavez Patiño Cesar Uriel
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Controlador;

/**
 * Ventana inicial del programa
 */

    public class Inicio extends JFrame {


            private Controlador controlador;

            public Inicio() 
            {
                    controlador = new Controlador();

                    setTitle("Firma Digital");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setSize(680,200);
                    setLocationRelativeTo (null);
                    JPanel contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    setLayout(null);


                    VentanaGeneradorClaves generadorClaves = new VentanaGeneradorClaves(this);
                    VentanaFirmador firmador = new VentanaFirmador(this);
                    Ventanacomprobar comprobador = new Ventanacomprobar(this);
                    /*VentanaSalir salir =new VentanaSalir (this);*/


                    JButton butGeneradorClaves = new JButton("Generar");
                    butGeneradorClaves.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                    generadorClaves.setVisible(true);
                                    dispose();
                            }
                    });
                    
                    butGeneradorClaves.setBounds(10, 40, 200, 80);
                    contentPane.add(butGeneradorClaves);

                    JButton butFirmador = new JButton("Firmar ");
                    butFirmador.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                    firmador.setVisible(true);
                                    dispose();
                            }
                    });
                    butFirmador.setBounds(230, 40, 200, 80);
                    contentPane.add(butFirmador);

                    JButton butComprobador = new JButton("Comprobar");
                    butComprobador.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                    comprobador.setVisible(true);
                                    dispose();
                            }
                    });
                    butComprobador.setBounds(450, 40, 200, 80);
                    contentPane.add(butComprobador);
            }

            public Controlador getControlador() {
                    return controlador;
            }

            public void setControlador(Controlador controlador) {
                    this.controlador = controlador;
            }

            public static void main(String[] args) 
            {
                    Inicio window = new Inicio();
                    window.setVisible(true);

            }

    }