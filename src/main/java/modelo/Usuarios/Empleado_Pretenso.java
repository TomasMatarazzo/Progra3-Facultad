package modelo.Usuarios;

import excepciones.TicketYaCreadoException;
import modelo.Tickets.Formulario_de_Busqueda;
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

    /**
     * Pre:
     * Post:
     * @return
     */
    @Override
    public double calculaComision() { //LA HAGO PROTECTED?
        double monto = 0, porcentaje;

        if (this.getTicketDeBusquedaDeEmpleo().getEstado().equalsIgnoreCase("FINALIZADO"))
            monto += this.ticketDeBusquedaDeEmpleo.getFormularioDeBusqueda().getRemuneracion();

        if (this.ticketDeBusquedaDeEmpleo.getFormularioDeBusqueda().getTipoPuestoLaboral().equalsIgnoreCase("JUNIOR"))
            porcentaje = 0.80;
        else if (this.ticketDeBusquedaDeEmpleo.getFormularioDeBusqueda().getTipoPuestoLaboral().equalsIgnoreCase("SENIOR"))
            porcentaje = 0.90;
        else //Es puesto laboral GERENCIAL
            porcentaje = 1.00;

        //Por cada punto obtenido se le resta un 1% al valor de la comisión
        if (this.puntaje > 0)
            porcentaje -= 0 + (0.01 * this.puntaje);

        return monto * porcentaje;
    }

}
