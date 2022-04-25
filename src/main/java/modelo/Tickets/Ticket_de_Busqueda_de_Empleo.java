package modelo.Tickets;
import java.util.GregorianCalendar;

public class Ticket_de_Busqueda_de_Empleo extends Ticket {
    private String resultado; // exito-fracaso

    //CONSTRUCTOR

    public Ticket_de_Busqueda_de_Empleo(Formulario_de_Busqueda formularioDeBusqueda, GregorianCalendar fechaDeAlta, int[] pesoAspectos, String resultado) {
        super(formularioDeBusqueda, fechaDeAlta, pesoAspectos);
        this.resultado = resultado;
    }

}
