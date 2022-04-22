package modelo.Usuarios.Empleadores;

import interfaces.ITicketeable;
import modelo.Formulario_de_Busqueda;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.Usuarios.Usuario;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Empleador extends Usuario implements ITicketeable {
    private Persona tipoPersona;
    private String razonSocial;
    private String rubro; // salud, comercio local o comercio internacional
    //Tickets
    private ArrayList<Ticket_de_Busqueda_de_Empleado> ticketsDeBusquedaDeEmpleado = new ArrayList<Ticket_de_Busqueda_de_Empleado>();

    //CONSTRUCTORES
    public Empleador(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    public Empleador(String nombreUsuario, String contrasena, Persona tipoPersona, String razonSocial, String rubro) {
        super(nombreUsuario, contrasena);
        this.tipoPersona = tipoPersona;
        this.razonSocial = razonSocial;
        this.rubro = rubro;
    }

    //GETTERS & SETTERS

    //FUNCIONALIDADES
    @Override
    public void creaTicket(Formulario_de_Busqueda form , GregorianCalendar fechaAlta , String resultado) {

    }

}
