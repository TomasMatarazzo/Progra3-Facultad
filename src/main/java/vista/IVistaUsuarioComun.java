package vista;

import java.util.TreeSet;
import modelo.tickets.Ticket;

public interface IVistaUsuarioComun extends IVista{

    void cambiarPagina(int pagina);

    FormTickets getForm();

	void mostrarFormTicket();

	void ocultarFormTicket();

	void llenarDatosEmpleado(String nombre, String apellido, String email, String telefono , int edad);

	void renderListaTicketsEmpleado( Ticket ticket);

	void renderListaElecciones( TreeSet<Ticket> list);

	Ticket getTicketSeleccionado();

	Ticket getTicketEleccionesSeleccionado();

	void setCantidadTickets(String cant);

	void confirmarSeleccion();
}
