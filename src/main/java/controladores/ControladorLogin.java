package controladores;

import modelo.Sistema;
import modelo.excepciones.ErrorDeContrasenaException;
import modelo.excepciones.ErrorDeUsuarioException;
import modelo.usuarios.Usuario;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.Util;
import vista.IVistaLogin;
import vista.VentanaLogin;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class ControladorLogin implements ActionListener, WindowListener {
    private IVistaLogin vista;
    private Usuario modelo;

    public ControladorLogin(VentanaLogin vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
        this.vista.setKeyListener();
        this.vista.setWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case "Registrarse":
                vista.creaOtraVentana("Register");
                break;
            case "Login":
                try {
                    modelo = Sistema.getInstance().login(vista.getNombreUsuario(),vista.getContrasena());
                    vista.setObservado(modelo);
                    modelo.loguearse();
                } catch (ErrorDeContrasenaException e1) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
                    vista.contrasenaInvalida();
                } catch (ErrorDeUsuarioException e2) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + e2.getMessage());
                    vista.nombreUsuarioInvalido();
                }
                break;
            case "Simulacion":
                vista.creaOtraVentana("Simulacion");
                break;
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            IPersistencia bin = new PersistenciaBIN();
            bin.abrirOutput("Sistema.bin");
            SistemaDTO sistemaDTO = Util.sistemaDTOFromSistema(Sistema.getInstance());
            bin.escribir(sistemaDTO);
            bin.cerrarOutput();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //METODOS NO USADOS
    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
