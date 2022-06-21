package controladores;

import modelo.Sistema;
import modelo.usuarios.Agencia;
import vista.VentanaAgencia;
import javax.swing.*;
import java.awt.event.*;

public class ControladorAgencia implements ActionListener, KeyListener {
    private VentanaAgencia vista;
    private Agencia modelo;

    public ControladorAgencia(VentanaAgencia vista,Agencia modelo) {
        this.vista = vista;
        vista.setActionListener(this);
        vista.setKeyListener(this);
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
                Sistema.getInstance().rondaContrataciones();
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
                        vista.mostrarDatos(vista.getListaDatosAlmacenados());
                        break;
                    case 2:
                        vista.limpiaModelo(vista.getModeloDatosAlmacenados());
                        modelo.muestraSolicitudesEmpleadores();
                        vista.mostrarDatos(vista.getListaDatosAlmacenados());
                        break;
                    case 3:
                        vista.limpiaModelo(vista.getModeloDatosAlmacenados());
                        modelo.muestraEmpleadosPretensos();
                        vista.mostrarDatos(vista.getListaDatosAlmacenados());
                        break;
                    case 4:
                        vista.limpiaModelo(vista.getModeloDatosAlmacenados());
                        modelo.muestraSolicitudEmpleadosPretensos();
                        vista.mostrarDatos(vista.getListaDatosAlmacenados());
                        break;
                }
                break;
            case "Calcular Comisiones":
                vista.limpiaModelo(vista.getModeloComisiones());
                modelo.calculaComisiones();
                vista.mostrarDatos(vista.getListaComisiones());
                vista.getTextoTotal().setText("Total a cobrar: " + modelo.getTotal());
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

    //METODOS NO USADOS
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
