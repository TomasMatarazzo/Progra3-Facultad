package modelo.tickets;

public class Ticket_de_Busqueda_de_Empleo extends Ticket {
    private String resultado; // exito-fracaso
    private Ticket_de_Busqueda_de_Empleado eleccion;

    //CONSTRUCTOR
    public Ticket_de_Busqueda_de_Empleo(Formulario_de_Busqueda formularioDeBusqueda, String tipoDeTrabajo) {
        super(formularioDeBusqueda, tipoDeTrabajo);
        this.resultado = null;
        this.eleccion = null;
    }

    //GETTERS
    public String getResultado() {
        return resultado;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Ticket de Busqueda de Empleo: " +
                "   formularioDeBusqueda: " + formularioDeBusqueda.toString() +
                "   fechaDeAlta: " + fechaDeAlta +
                "   estado: " + estado +
                "   resultado: " + resultado;
    }

    //FUNCIONALIDADES
}
