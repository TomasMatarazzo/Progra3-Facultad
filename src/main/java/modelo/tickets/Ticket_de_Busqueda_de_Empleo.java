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

    public Ticket_de_Busqueda_de_Empleado getEleccion() {
        return eleccion;
    }

    //SETTERS
    
    public void setEleccion(Ticket_de_Busqueda_de_Empleado eleccion) {
		this.eleccion = eleccion;
	}
    
    //TO STRING
    @Override
    public String toString() {
        return  "   formularioDeBusqueda: " + formularioDeBusqueda.toString() +
                "   fechaDeAlta: " + fechaDeAlta +
                "   estado: " + estado +
                "   resultado: " + resultado;
    }

	

    //FUNCIONALIDADES
}
