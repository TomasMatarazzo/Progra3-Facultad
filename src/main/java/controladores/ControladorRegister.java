package controladores;

import modelo.excepciones.DatosMalIngresadosException;
import modelo.excepciones.ErrorDeUsuarioException;
import modelo.usuarios.UsuarioFactoryExtendida;
import vista.VentanaRegister;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorRegister implements ActionListener, KeyListener {
    private VentanaRegister vista;
    private UsuarioFactoryExtendida modeloFactory;

    public ControladorRegister(VentanaRegister vista, UsuarioFactoryExtendida modelo) {
        this.vista = vista;
        this.modeloFactory = modelo;
        this.vista.setActionListener(this);
        this.vista.setKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        switch (evento.getActionCommand()) {
            case "Empleado":
                vista.muestraOpcionEmpleado();
                break;
            case "Empleador":
                vista.muestraOpcionEmpleador();
                break;
            case "Registrarse":

                String tipoUsuario;
                if (vista.getEmpleadoRadioButton().isSelected())
                    tipoUsuario = vista.getEmpleadoRadioButton().getActionCommand();
                else {
                    if (vista.getFisicaRadioButton().isSelected())
                        tipoUsuario = vista.getFisicaRadioButton().getActionCommand();
                    else
                        tipoUsuario = vista.getJuridicaRadioButton().getActionCommand();
                }

                try {
                    String nombreUsuario = vista.getTextoNombreDeUsuario().getText();
                    String contrasena = vista.getTextoContrasena().getText();

                    if (vista.getEmpleadoRadioButton().isSelected()) {
                        String nombre = vista.getTextoNombre().getText();
                        String apellido = vista.getTextoApellido().getText();
                        String telefono = vista.getTextoTelefono().getText();
                        int edad = (vista.getTextoEdad().getText().isEmpty())? 0:Integer.parseInt(vista.getTextoEdad().getText());
                        String mail = vista.getTextoEMail().getText();
                        
                        modeloFactory.creaUsuario(nombreUsuario,contrasena,tipoUsuario,nombre,apellido,telefono,edad,mail);
                    } else {
                        String razonSocial = vista.getTextoRazonSocial().getText();
                        String rubro;
                        if (vista.getSaludRadioButton().isSelected())
                            rubro = vista.getSaludRadioButton().getActionCommand();
                        else
                            if (vista.getComercioLocalRadioButton().isSelected())
                                rubro = vista.getComercioLocalRadioButton().getActionCommand();
                            else
                                if (vista.getComercioInternacionalRadioButton().isSelected())
                                    rubro = vista.getComercioInternacionalRadioButton().getActionCommand();
                                else
                                    rubro = "\0";

                        modeloFactory.creaUsuario(nombreUsuario,contrasena,tipoUsuario,razonSocial,rubro);
                    }

                    vista.creaOtraVentana("Login");
                } catch (DatosMalIngresadosException e1) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
                } catch (ErrorDeUsuarioException e2) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + e2.getMessage());
                    vista.getTextoNombreDeUsuario().setText("\0");
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (vista.getTextoNombreDeUsuario().getText().isEmpty() || vista.getTextoContrasena().getText().isEmpty()) {
            vista.getBotonRegistrarse().setEnabled(false);
        } else {
            vista.getBotonRegistrarse().setEnabled(true);
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
