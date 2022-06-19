package controladores;

import modelo.Sistema;
import modelo.excepciones.ErrorDeContrasenaException;
import modelo.excepciones.ErrorDeUsuarioException;
import modelo.usuarios.Usuario;
import vista.VentanaLogin;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorLogin implements ActionListener, KeyListener {
    private VentanaLogin vista;
    private Usuario modelo;

    public ControladorLogin(VentanaLogin vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
        this.vista.setKeyListener(this);
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
                    vista.getTextoContrasena().setText("\0");
                    vista.getBotonLogin().setEnabled(false);
                } catch (ErrorDeUsuarioException e2) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + e2.getMessage());
                    vista.getTextoNombreUsuario().setText("\0");
                    vista.getTextoContrasena().setText("\0");
                    vista.getBotonLogin().setEnabled(false);
                }
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

    //METODOS QUE NO SE USAN
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
