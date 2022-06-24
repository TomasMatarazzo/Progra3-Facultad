package controladores;

import modelo.Sistema;
import modelo.excepciones.EstadoException;
import modelo.usuarios.Agencia;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.Util;
import vista.IVistaAgencia;
import vista.VentanaAgencia;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class ControladorAgencia implements ActionListener, WindowListener {
    private IVistaAgencia vista;
    private Agencia modelo;

    public ControladorAgencia(VentanaAgencia vista,Agencia modelo) {
        this.vista = vista;
        vista.setActionListener(this);
        vista.setKeyListener();
        this.vista.setWindowListener(this);
        this.modelo = modelo;
        vista.setObservado(this.modelo);
        vista.cambiarTitulo(modelo.getNombreUsuario());
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
            case "Desloguearse":
                vista.creaOtraVentana("Login");
                vista.cerrarVentana();
                JOptionPane.showMessageDialog(null, "Te has deslogueado con exito");
                break;
            case "Dar de baja":
                vista.creaOtraVentana("Login");
                Sistema.getInstance().setAgencia(null);
                vista.cerrarVentana();
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
                String tipoTrabajo = vista.getTipoDeTrabajo();
                int rangoLaboral = vista.getRangoLaboral();
                String auxRango;
                String tipoPuesto = vista.getTipoDePuesto();

                if (!tipoTrabajo.isEmpty())
                    Sistema.getInstance().agregaTiposDeTrabajo(tipoTrabajo);
                if (rangoLaboral > 0) {
                    modelo.confeccionarRangoEtario(rangoLaboral);
                    auxRango = String.valueOf(rangoLaboral);
                } else
                    auxRango = "";
                if (!tipoPuesto.isEmpty())
                    modelo.confeccionarTipoDePuesto(tipoPuesto);

                vista.agregarDatos(tipoTrabajo,auxRango,tipoPuesto);
                break;
            case "boxDatosCargados":
                switch (vista.getIndiceSeleccionado()) {
                    case 0:
                        vista.limpiaModelo("Datos Almacenados");
                        break;
                    case 1:
                        vista.limpiaModelo("Datos Almacenados");
                        modelo.muestraEmpleadores();
                        vista.mostrarDatos("Datos Almacenados");
                        break;
                    case 2:
                        vista.limpiaModelo("Datos Almacenados");
                        modelo.muestraSolicitudesEmpleadores();
                        vista.mostrarDatos("Datos Almacenados");
                        break;
                    case 3:
                        vista.limpiaModelo("Datos Almacenados");
                        modelo.muestraEmpleadosPretensos();
                        vista.mostrarDatos("Datos Almacenados");
                        break;
                    case 4:
                        vista.limpiaModelo("Datos Almacenados");
                        modelo.muestraSolicitudEmpleadosPretensos();
                        vista.mostrarDatos("Datos Almacenados");
                        break;
                }
                break;
            case "Calcular Comisiones":
                vista.limpiaModelo("Comisiones");
                modelo.calculaComisiones();
                vista.mostrarDatos("Comisiones");
                vista.cambiarTotal(modelo.getTotal());
                vista.lanzarVentanaEmergente("Operacion realizada con exito");
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
