package controladores;

import modelo.Sistema;
import modelo.excepciones.ErrorDeContrasenaException;
import modelo.excepciones.ErrorDeUsuarioException;
import modelo.usuarios.Usuario;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.Util;
import vista.VentanaLogin;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class ControladorLogin implements ActionListener, KeyListener, WindowListener {
    private VentanaLogin vista;
    private Usuario modelo;

    public ControladorLogin(VentanaLogin vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
        this.vista.setKeyListener(this);
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
                    modelo = Sistema.getInstance().login(vista.getTextoNombreUsuario().getText(),vista.getTextoContrasena().getText());
                    vista.setObservado(modelo);
                    modelo.loguearse();
                } catch (ErrorDeContrasenaException e1) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
                    vista.getTextoContrasena().setText("");
                    vista.getBotonLogin().setEnabled(false);
                } catch (ErrorDeUsuarioException e2) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + e2.getMessage());
                    vista.getTextoNombreUsuario().setText("");
                    vista.getTextoContrasena().setText("");
                    vista.getBotonLogin().setEnabled(false);
                }
                break;
            case "Simulacion":
                vista.creaOtraVentana("Simulacion");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (vista.getTextoNombreUsuario().getText().isEmpty() || vista.getTextoContrasena().getText().isEmpty()) {
            vista.getBotonLogin().setEnabled(false);
        } else {
            vista.getBotonLogin().setEnabled(true);
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

    //METODOS QUE NO SE USAN
    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

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
