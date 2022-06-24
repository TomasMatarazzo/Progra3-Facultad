package controladores;

import modelo.Sistema;
import modelo.excepciones.DatosMalIngresadosException;
import modelo.excepciones.ErrorDeUsuarioException;
import modelo.usuarios.UsuarioFactoryExtendida;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.Util;
import vista.IVistaRegister;
import vista.VentanaRegister;
import java.awt.event.*;
import java.io.IOException;

public class ControladorRegister implements ActionListener, WindowListener {
    private IVistaRegister vista;
    private UsuarioFactoryExtendida modeloFactory;

    public ControladorRegister(VentanaRegister vista, UsuarioFactoryExtendida modelo) {
        this.vista = vista;
        this.modeloFactory = modelo;
        this.vista.setActionListener(this);
        this.vista.setKeyListener();
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
            case "Volver":
                vista.creaOtraVentana("Login");
                vista.cerrarVentana();
                break;
            case "Registrarse":
                String tipoUsuario = vista.getTipoUsuario();

                try {
                    String nombreUsuario = vista.getNombreUsuario();
                    String contrasena = vista.getContrasena();

                    if (vista.esEmpleado()) {
                        String nombre = vista.getNombre();
                        String apellido = vista.getApellido();
                        String telefono = vista.getTelefono();
                        int edad = vista.getEdad();
                        String mail = vista.getEmail();
                        
                        modeloFactory.creaUsuario(nombreUsuario,contrasena,tipoUsuario,nombre,apellido,telefono,edad,mail);
                    } else {
                        String razonSocial = vista.getRazonSocial();
                        String rubro = vista.getRubro();

                        modeloFactory.creaUsuario(nombreUsuario,contrasena,tipoUsuario,razonSocial,rubro);
                    }
                    vista.lanzarVentanaEmergente("El usuario se ha creado con exito!");
                    vista.creaOtraVentana("Login");
                    vista.cerrarVentana();
                } catch (DatosMalIngresadosException e1) {
                    vista.lanzarVentanaEmergente("ERROR: " + e1.getMessage());
                } catch (ErrorDeUsuarioException e2) {
                    vista.lanzarVentanaEmergente("ERROR: " + e2.getMessage());
                    vista.nombreUsuarioInvalido();
                }
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

    //METODOS QUE NO SE USAN
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
