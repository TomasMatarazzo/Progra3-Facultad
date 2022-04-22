package modelo;

import interfaces.ITicketeable;

import java.util.ArrayList;

public class Empleado_Pretenso extends Usuario implements ITicketeable {
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

    public Empleado_Pretenso(String nombreUsuario, String contrasena                               , String nombre, String apellido, String telefono, int edad, String eMail) {
        super(nombreUsuario, contrasena);
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.eMail = eMail;
    }

    //GETTERS & SETTERS

    //FUNCIONALIDADES
    @Override
    public void creaTicket() {

    }
}
