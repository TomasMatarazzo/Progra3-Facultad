package vista;

import java.util.ArrayList;
import java.util.TreeSet;

import modelo.listas.Contrato;
import modelo.tickets.Ticket;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.usuarios.Usuario;

public interface IVistaUsuarioComun extends IVista{

    void cambiarPagina(int pagina);

    FormTickets getForm();

	void mostrarFormTicket();

	void ocultarFormTicket();

	void llenarDatosEmpleado(String nombre, String apellido, String email, String telefono , int edad);

	void renderListaTicketsEmpleado(Ticket_de_Busqueda_de_Empleo ticket);

	void renderListaElecciones( TreeSet<Ticket> list);

	public void renderListaContratos(ArrayList<Contrato> contratos,Usuario usuario);

	Ticket getTicketSeleccionado();

	Ticket getTicketEleccionesSeleccionado();

	void setCantidadTickets(String cant);

	void llenarDatosEmpleador(String nombre, String tipoPersona, String rubro, String usuario);

	void confirmarSeleccion();

}
