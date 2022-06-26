package vista;

import java.util.ArrayList;
import java.util.TreeSet;

import modelo.tickets.Ticket;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;

public interface IVistaUsuarioComun extends IVista{

    void cambiarPagina(int pagina);
    FormTickets getForm();
    public void lanzarVentanaEmergente(String mensaje);
	public void mostrarFormTicket();
	public void ocultarFormTicket();
	public void llenarDatosEmpleado(String nombre, String apellido, String email, String telefono , int edad);
	public void renderListaTicketsEmpleado( Ticket ticket);
	public void renderListaTicketsEmpleador( ArrayList<Ticket_de_Busqueda_de_Empleo> tickets);
	public void renderListaElecciones( TreeSet<Ticket> list) ;
	public Ticket getTicketSeleccionado();
	public Ticket getTicketEleccionesSeleccionado();
	public void setCantidadTickets(String cant) ;
	public void llenarDatosEmpleador(String nombre, String tipoPersona, String rubro, String usuario);
	public void confirmarSeleccion();
}
