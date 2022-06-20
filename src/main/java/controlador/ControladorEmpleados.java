package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Sistema;
import modelo.usuarios.Empleado_Pretenso;
import vista.VentanaEmpleado;
import vista.VentanaEmpleados;

public class ControladorEmpleados implements ActionListener {
	private VentanaEmpleado vista;
	private Empleado_Pretenso modelo;

	public ControladorEmpleados(VentanaEmpleado vista2, Empleado_Pretenso modelo) {
		this.modelo = modelo;
		this.vista = vista2;
		this.vista.setControlador(this);
		vista.llenarDatosEmpleado(modelo.getNombre(),modelo.getApellido(),modelo.geteMail(), modelo.getTelefono(),modelo.getEdad());
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("iniciarTICKETS")) {
			vista.cambiarPagina(1);
		}else if (e.getActionCommand().equals("iniciarPERFIL")) {
			vista.cambiarPagina(0);
		}else if (e.getActionCommand().equals("iniciarELECCIONES")) {
			vista.cambiarPagina(2);
		}else if (e.getActionCommand().equals("AGREGARTICKET")) {
			//agrego un nuevo ticket
			//tengo que eliminar el ticket dentro del usuario y del sistema
			if (modelo.getTicketDeBusquedaDeEmpleo() == null) {
				Sistema.getInstance().agregaTicketDeEmpleadosPretensos(modelo, vista.getTicketSeleccionado());
				modelo.setTicketDeBusquedaDeEmpleo(vista.getTicketSeleccionado());
				vista.mostrarFormTicket();
			}else {
				vista.lanzarVentanaEmergente("Ya creo un ticket.");
			}
		}else if (e.getActionCommand().equals("ELIMINARTICKET")) {
			// VERIFICA QUE SE HAYA SELECCIONADO UN TICKET
			if (vista.getTicketSeleccionado() != null) {
				Sistema.getInstance().eliminaTicketDeEmpleadosPretensos(vista.getTicketSeleccionado());
				modelo.setTicketDeBusquedaDeEmpleo(null);
				vista.lanzarVentanaEmergente("Se elimino el ticket.");
				System.out.println(modelo.getTicketDeBusquedaDeEmpleo());
				vista.renderListaTickets(modelo.getTicketDeBusquedaDeEmpleo());
			}
			else {
				vista.lanzarVentanaEmergente("Seleccione el ticket a eliminar.");
			}
		}else if (e.getActionCommand().equals("EMPLEADORELEGIDO")) {
			if (vista.getTicketEleccionesSeleccionado() != null) {
				
			}
			else
				vista.lanzarVentanaEmergente("Seleccion un ticket de la ronda de elecciones.");
		}else if (e.getActionCommand().equals("CREARTICKET")) {
			System.out.println("Se creo un ticket");
			vista.ocultarFormTicket();
		}
	}

}
