package modelo.Usuarios;

import interfaces.ITicketeable;
import modelo.Formulario_de_Busqueda;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.Usuarios.Usuario;

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

    //FUNCIONALIDADES
    @Override
    public void creaTicket(Formulario_de_Busqueda form , GregorianCalendar fechaAlta , String resultado ) {
        Ticket_de_Busqueda_de_Empleado ticket = new Ticket_de_Busqueda_de_Empleo(form, fechaAlta, resultado);
        if (this.ticketDeBusquedaDeEmpleo == null)
            this.ticketDeBusquedaDeEmpleo = new Ticket_de_Busqueda_de_Empleo(form, fechaAlta, resultado);
    }


}
