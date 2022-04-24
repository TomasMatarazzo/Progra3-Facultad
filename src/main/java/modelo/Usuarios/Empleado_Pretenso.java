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
        this.ticketDeBusquedaDeEmpleo = null;
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


    @Override
    public String getNombreUsuario() {
        return super.getNombreUsuario();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Ticket_de_Busqueda_de_Empleo getTicketDeBusquedaDeEmpleo() {
        return ticketDeBusquedaDeEmpleo;
    }

    public void setDatos(String nombre, String apellido, String telefono, int edad, String eMail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.eMail = eMail;
    }

    @Override
    public String getTipo() {
        return "Empleado Pretenso";
    }

    //TO STRING
    @Override
    public String toString() {
        return "Empleado Pretenso: \n" +
                "   IDUsuario: " + IDUsuario +
                "   nombreUsuario: " + nombreUsuario +
                "   contrasena: " + contrasena + //La muestro?
                "   nombre: '" + nombre +
                "   apellido: '" + apellido +
                "   telefono: " + telefono +
                "   edad: " + edad +
                "   eMail: " + eMail +
                "   puntaje: " + puntaje;
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
