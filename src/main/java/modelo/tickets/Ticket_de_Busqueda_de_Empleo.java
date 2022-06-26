package modelo.tickets;

import java.io.Serializable;

public class Ticket_de_Busqueda_de_Empleo extends Ticket implements Serializable {
    private String resultado; // exito-fracaso
    private Ticket_de_Busqueda_de_Empleado eleccion;

    //CONSTRUCTOR
    public Ticket_de_Busqueda_de_Empleo() {
    }

    public Ticket_de_Busqueda_de_Empleo(Formulario_de_Busqueda formularioDeBusqueda, String tipoDeTrabajo) {
        super(formularioDeBusqueda, tipoDeTrabajo);
        this.resultado = "PENDIENTE";
        this.eleccion = null;
    }

    //GETTERS
    public String getResultado() {
        return resultado;
    }

    public Ticket_de_Busqueda_de_Empleado getEleccion() {
        return eleccion;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setEleccion(Ticket_de_Busqueda_de_Empleado eleccion) {
        this.eleccion = eleccion;
    }

    //TO STRING


    @Override
    public String toString() {
        return "Ticket: " +
                " estado: " + (this.getState().getNombreEstado() == null ? "-" : this.getState().getNombreEstado())  +
        		(formularioDeBusqueda == null ? "-" : formularioDeBusqueda.toString()) +
                " fechaDeAlta: " + fechaDeAlta.getTime() +
                " estado: " + (this.getState().getNombreEstado() == null ? "-" : this.getState().getNombreEstado())  +
                " tipoDeTrabajo " + (tipoDeTrabajo == null ? "-" : tipoDeTrabajo)  +
                " puntajeTotal: " + puntajeTotal  +
                " resultado: " + (resultado == null ? "pendiente" : resultado)  +
                " eleccion: " + (eleccion == null ? "-" : eleccion);
    }
}
