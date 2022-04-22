package modelo.Tickets;

import modelo.Formulario_de_Busqueda;
import modelo.Tickets.Ticket;

import java.util.GregorianCalendar;

public class Ticket_de_Busqueda_de_Empleo extends Ticket {
    private String resultado; // exito-fracaso

    //CONSTRUCTOR
    public Ticket_de_Busqueda_de_Empleo(Formulario_de_Busqueda formularioDeBusqueda, GregorianCalendar fechaDeAlta) {
        super(formularioDeBusqueda, fechaDeAlta);
        this.resultado = null;
    }
}
