package controladores;

import java.awt.event.*;
import java.io.IOException;

import modelo.Sistema;
import modelo.usuarios.EmpleadoPretenso;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.Util;
import vista.VentanaEmpleado;

public class ControladorEmpleados implements ActionListener, WindowListener {
	private VentanaEmpleado vista;
	private EmpleadoPretenso modelo;

	public ControladorEmpleados(VentanaEmpleado vista2, EmpleadoPretenso modelo) {
		this.modelo = modelo;
		this.vista = vista2;
		this.vista.setActionListener(this);
		this.vista.setWindowListener(this);
		vista.llenarDatosEmpleado(modelo.getNombre(),modelo.getApellido(),modelo.geteMail(), modelo.getTelefono(),modelo.getEdad());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "iniciarPERFIL":
				vista.cambiarPagina(0);
				break;
			case "iniciarTICKETS":
				vista.cambiarPagina(1);
				break;
			case "iniciarELECCIONES":
				vista.cambiarPagina(2);
				break;
			case "AGREGARTICKET":
				//agrego un nuevo ticket
				//tengo que eliminar el ticket dentro del usuario y del sistema
				if (modelo.getTicketDeBusquedaDeEmpleo() == null) {
					Sistema.getInstance().agregaTicketDeEmpleadosPretensos(modelo, vista.getTicketSeleccionado());
					modelo.setTicketDeBusquedaDeEmpleo(vista.getTicketSeleccionado());
					vista.mostrarFormTicket();
				}else {
					vista.lanzarVentanaEmergente("Ya creo un ticket.");
				}
				break;
			case "ELIMINARTICKET":
				// VERIFICA QUE SE HAYA SELECCIONADO UN TICKET
				if (vista.getTicketSeleccionado() != null) {
					Sistema.getInstance().eliminaTicketDeEmpleadosPretensos(vista.getTicketSeleccionado());
					modelo.setTicketDeBusquedaDeEmpleo(null);
					vista.lanzarVentanaEmergente("Se elimino el ticket.");
					System.out.println(modelo.getTicketDeBusquedaDeEmpleo());
					vista.renderListaTickets(modelo.getTicketDeBusquedaDeEmpleo());
				} else
					vista.lanzarVentanaEmergente("Seleccione el ticket a eliminar.");
				break;
			case "EMPLEADORELEGIDO":
				if (vista.getTicketEleccionesSeleccionado() != null) {

				}
				else
					vista.lanzarVentanaEmergente("Seleccion un ticket de la ronda de elecciones.");
				break;
			case "CREARTICKET":
				System.out.println("Se creo un ticket");
				vista.ocultarFormTicket();
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
