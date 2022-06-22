package controladores;

import modelo.Sistema;
import modelo.excepciones.EstadoException;
import modelo.usuarios.Agencia;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.Util;
import vista.VentanaAgencia;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class ControladorAgencia implements ActionListener, KeyListener, WindowListener {
    private VentanaAgencia vista;
    private Agencia modelo;

    public ControladorAgencia(VentanaAgencia vista,Agencia modelo) {
        this.vista = vista;
        vista.setActionListener(this);
        vista.setKeyListener(this);
        this.vista.setWindowListener(this);
        this.modelo = modelo;
        vista.setObservado(this.modelo);
        vista.getTextoBienvenido().setText("Bienvenido, " + modelo.getNombreUsuario());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Perfil":
                vista.cambiarPagina(0);
                break;
            case "Ingresar datos":
                vista.cambiarPagina(1);
                break;
            case "Ver datos":
                vista.cambiarPagina(2);
                break;
            case "Comisiones":
                vista.cambiarPagina(3);
                break;
            case "Dar de baja":
                Sistema.getInstance().setAgencia(null);
                vista.creaOtraVentana("Login");
                JOptionPane.showMessageDialog(null, "Se ha eliminado la Agencia con exito!");
                this.modelo = null;
                break;
            case "Ronda de Encuentros Laborales":
                Sistema.getInstance().rondaEncuentrosLaborales();
                JOptionPane.showMessageDialog(null, "Se ha efectuado la ronda de Encuentros Laborales con exito!");
                break;
            case "Ronda de Contrataciones":
                try {
                    Sistema.getInstance().rondaContrataciones();
                } catch (EstadoException ex) {
                    vista.lanzarVentanaEmergente(ex.getMessage());
                }
                JOptionPane.showMessageDialog(null, "Se ha efectuado la ronda de Contrataciones con exito!");
                break;
            case "Agregar Datos":
                String tipoTrabajo = vista.getTextoTiposDeTrabajo().getText();
                String rangoLaboral = vista.getTextoRangoLaboral().getText();
                String tipoPuesto = vista.getTextoTiposDePuestos().getText();

                if (!tipoTrabajo.isEmpty())
                    Sistema.getInstance().agregaTiposDeTrabajo(tipoTrabajo);
                if (!rangoLaboral.isEmpty())
                    try {
                        modelo.confeccionarRangoEtario(Integer.parseInt(rangoLaboral));
                    } catch (NumberFormatException e1) {
                        vista.lanzarVentanaEmergente("ERROR: Ingrese un valor numerico entero de Rango");
                        vista.getTextoRangoLaboral().setText("");
                        rangoLaboral = "";
                    }
                if (!tipoPuesto.isEmpty())
                    modelo.confeccionarTipoDePuesto(tipoPuesto);

                vista.agregarDatos(tipoTrabajo,rangoLaboral,tipoPuesto);
                break;
            case "boxDatosCargados":
                switch (vista.getBoxDatosCargados().getSelectedIndex()) {
                    case 0:
                        vista.limpiaModelo(vista.getModeloDatosAlmacenados());
                        break;
                    case 1:
                        vista.limpiaModelo(vista.getModeloDatosAlmacenados());
                        modelo.muestraEmpleadores();
                        vista.mostrarDatos(vista.getListaDatosAlmacenados(),vista.getModeloDatosAlmacenados());
                        break;
                    case 2:
                        vista.limpiaModelo(vista.getModeloDatosAlmacenados());
                        modelo.muestraSolicitudesEmpleadores();
                        vista.mostrarDatos(vista.getListaDatosAlmacenados(),vista.getModeloDatosAlmacenados());
                        break;
                    case 3:
                        vista.limpiaModelo(vista.getModeloDatosAlmacenados());
                        modelo.muestraEmpleadosPretensos();
                        vista.mostrarDatos(vista.getListaDatosAlmacenados(),vista.getModeloDatosAlmacenados());
                        break;
                    case 4:
                        vista.limpiaModelo(vista.getModeloDatosAlmacenados());
                        modelo.muestraSolicitudEmpleadosPretensos();
                        vista.mostrarDatos(vista.getListaDatosAlmacenados(),vista.getModeloDatosAlmacenados());
                        break;
                }
                break;
            case "Calcular Comisiones":
                vista.limpiaModelo(vista.getModeloComisiones());
                modelo.calculaComisiones();
                vista.mostrarDatos(vista.getListaComisiones(),vista.getModeloComisiones());
                vista.getTextoTotal().setText("Total a cobrar: " + modelo.getTotal());
                vista.lanzarVentanaEmergente("Operacion realizada con exito");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (vista.getTextoTiposDeTrabajo().getText().isEmpty() && vista.getTextoRangoLaboral().getText().isEmpty() && vista.getTextoTiposDePuestos().getText().isEmpty())
            vista.getBotonAgregarDatos().setEnabled(false);
        else
            vista.getBotonAgregarDatos().setEnabled(true);


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (vista.getModeloRangosLaborales().size() == 2) {
            vista.getTextoRangoLaboral().setText("");
            vista.getTextoRangoLaboral().setEnabled(false);
        }
        if (vista.getModeloTiposDePuestos().size() == 3) {
            vista.getTextoTiposDePuestos().setText("");
            vista.getTextoTiposDePuestos().setEnabled(false);
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
