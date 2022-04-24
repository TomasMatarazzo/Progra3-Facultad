package modelo.Usuarios;

import excepciones.TicketYaCreadoException;
import modelo.Tickets.Formulario_de_Busqueda;
import modelo.Tickets.Ticket;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleo;

import java.util.GregorianCalendar;

public class Empleado_Pretenso extends Usuario {
    //Datos personales:
    private String nombre;
    private String apellido;
    private String telefono;
    private int edad;
    private String eMail;
    //Ticket
    private Ticket_de_Busqueda_de_Empleo ticketDeBusquedaDeEmpleo;

    //CONSTRUCTORES
    public Empleado_Pretenso(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    public Empleado_Pretenso(String nombreUsuario, String contrasena, String nombre, String apellido, String telefono, int edad, String eMail) {
        super(nombreUsuario, contrasena);
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.eMail = eMail;
        this.ticketDeBusquedaDeEmpleo = null;
    }

    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public String geteMail() {
        return eMail;
    }

    public Ticket_de_Busqueda_de_Empleo getTicketDeBusquedaDeEmpleo() {
        return ticketDeBusquedaDeEmpleo;
    }

    //FUNCIONALIDADES
    public void creaTicket(Formulario_de_Busqueda formulario, GregorianCalendar fechaAlta) throws TicketYaCreadoException {
        if (this.ticketDeBusquedaDeEmpleo == null)
            this.ticketDeBusquedaDeEmpleo = new Ticket_de_Busqueda_de_Empleo(formulario, fechaAlta);
        else
            throw new TicketYaCreadoException("No puede existir mas de un ticket.");
    }

	@Override
	public double calculoComision(Ticket ticket) {
		double aux=0;
		switch (this.ticketDeBusquedaDeEmpleo.getFormularioDeBusqueda().getTipoPuestoLaboral()){
			case "junior":aux= 0.8;break;
			case "senior":aux =0.9;break;
			case "gerencial":aux=1.0;break;
		}
		return ticket.getFormularioDeBusqueda().getRemuneracion()*aux;
		
	}

}
