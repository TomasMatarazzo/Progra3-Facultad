package controladores;

import modelo.Sistema;
import modelo.excepciones.DatosMalIngresadosException;
import modelo.excepciones.ErrorDeUsuarioException;
import modelo.usuarios.UsuarioFactoryExtendida;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.Util;
import vista.VentanaRegister;
import java.awt.event.*;
import java.io.IOException;

public class ControladorRegister implements ActionListener, KeyListener, WindowListener {
    private VentanaRegister vista;
    private UsuarioFactoryExtendida modeloFactory;

    public ControladorRegister(VentanaRegister vista, UsuarioFactoryExtendida modelo) {
        this.vista = vista;
        this.modeloFactory = modelo;
        this.vista.setActionListener(this);
        this.vista.setKeyListener(this);
        this.vista.setWindowListener(this);
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
                        int edad = 0;
                        if (!vista.getTextoEdad().getText().isEmpty()) {
                            try {
                                edad = Integer.parseInt(vista.getTextoEdad().getText());
                            } catch (NumberFormatException e1) {
                                vista.getTextoEdad().setText("");
                                throw new DatosMalIngresadosException("Ingrese un valor adecuado para la Edad");
                            }
                        }
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
                    vista.lanzarVentanaEmergente("El usuario se ha creado con exito!");
                    vista.creaOtraVentana("Login");
                } catch (DatosMalIngresadosException e1) {
                    vista.lanzarVentanaEmergente("ERROR: " + e1.getMessage());
                } catch (ErrorDeUsuarioException e2) {
                    vista.lanzarVentanaEmergente("ERROR: " + e2.getMessage());
                    vista.getTextoNombreDeUsuario().setText("");
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
