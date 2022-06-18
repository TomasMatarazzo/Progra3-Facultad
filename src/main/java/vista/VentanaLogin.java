package vista;

import controlador.ControladorRegister;
import modelo.usuarios.UsuarioFactoryExtendida;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class VentanaLogin extends JFrame implements IVista {
    private JPanel panelPrinciapal;
    private JPanel panelCentral;
    private JPanel panelInferior;
    private JPanel PanelDatos;
    private JTextField textoNombreUsuario;
    private JTextField textoContrasena;
    private JButton botonRegistrarse;
    private JButton botonLogin;

    public JTextField getTextoNombreUsuario() {
        return textoNombreUsuario;
    }

    public void setTextoNombreUsuario(JTextField textoNombreUsuario) {
        this.textoNombreUsuario = textoNombreUsuario;
    }

    public JTextField getTextoContrasena() {
        return textoContrasena;
    }

    public void setTextoContrasena(JTextField textoContrasena) {
        this.textoContrasena = textoContrasena;
    }

    public JButton getBotonRegistrarse() {
        return botonRegistrarse;
    }

    public void setBotonRegistrarse(JButton botonRegistrarse) {
        this.botonRegistrarse = botonRegistrarse;
    }

    public JButton getBotonLogin() {
        return botonLogin;
    }

    public void setBotonLogin(JButton botonLogin) {
        this.botonLogin = botonLogin;
    }

    @Override
    public void setActionListener(ActionListener controlador) {
        this.botonLogin.addActionListener(controlador);
        this.botonRegistrarse.addActionListener(controlador);
    }

    @Override
    public void setKeyListener(KeyListener controlador) {
        this.textoNombreUsuario.addKeyListener(controlador);
        this.textoContrasena.addKeyListener(controlador);
    }

    @Override
    public void ejecutar() {
        setTitle("Grupo 5");
        pack(); //Coloca los componentes
        setContentPane(panelPrinciapal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,400); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setLocationRelativeTo(null);
        botonLogin.setEnabled(false);
    }

    @Override
    public void ocultar() {
        setVisible(false);
    }

    @Override
    public void creaOtraVentana(String ventana) {
        switch (ventana) {
            case "Register":
                UsuarioFactoryExtendida modelo = new UsuarioFactoryExtendida();
                VentanaRegister vista = new VentanaRegister();
                ControladorRegister controladorRegister = new ControladorRegister(vista,modelo);
                vista.ejecutar();
                break;
            case "Empleado Pretenso":
                System.out.println("Se abre la ventana de EMPLEADO PRETENSO");
                break;
            case "Empleador":
                System.out.println("Se abre la ventana de EMPLEADOR");
                break;
            case "Agencia":
                System.out.println("Se abre la ventana de AGENCIA ");

                break;
        }
        this.ocultar();
    }
}
