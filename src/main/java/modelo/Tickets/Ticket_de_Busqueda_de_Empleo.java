package modelo.Tickets;

import java.util.GregorianCalendar;

public class Ticket_de_Busqueda_de_Empleo extends Ticket {
    private String resultado; // exito-fracaso

    //CONSTRUCTOR
    public Ticket_de_Busqueda_de_Empleo(Formulario_de_Busqueda formularioDeBusqueda, GregorianCalendar fechaDeAlta) {
        super(formularioDeBusqueda, fechaDeAlta);
        this.resultado = null;
    }

    //GETTERS
    public String getResultado() {
        return resultado;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Ticket de Busqueda de Empleo: " +
                "   IDTicket: " + IDTicket +
                "   formularioDeBusqueda: " + formularioDeBusqueda.toString() +
                "   fechaDeAlta: " + fechaDeAlta +
                "   estado: " + estado +
                "   resultado: " + resultado;
    }

    //FUNCIONALIDADES
}
