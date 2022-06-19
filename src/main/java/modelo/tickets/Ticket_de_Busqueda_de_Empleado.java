package modelo.tickets;

import java.io.Serializable;

public class Ticket_de_Busqueda_de_Empleado extends Ticket implements Serializable{
    private int[] pesoAspectos; //Pesos de [1,3] vector de 7 dimensiones
    private Ticket_de_Busqueda_de_Empleo eleccion;

    //CONSTRUCTOR

    public Ticket_de_Busqueda_de_Empleado() {
    }

    public Ticket_de_Busqueda_de_Empleado(Formulario_de_Busqueda formularioDeBusqueda, String tipoDeTrabajo, int[] pesoAspectos) {
        super(formularioDeBusqueda, tipoDeTrabajo);
        this.pesoAspectos = pesoAspectos;
        this.eleccion = null;
    }

    //GETTERS
    public Ticket_de_Busqueda_de_Empleo getEleccion() {
        return eleccion;
    }

    public void setEleccion(Ticket_de_Busqueda_de_Empleo eleccion) {
        this.eleccion = eleccion;
    }

    public int[] getPesoAspectos() {
        return pesoAspectos;
    }

    public void setPesoAspectos(int[] pesoAspectos) {
        this.pesoAspectos = pesoAspectos;
    }

    //TO STRING
    @Override
    public String toString() {
        return  "   formularioDeBusqueda: \n" + formularioDeBusqueda.toString() +
                "   fechaDeAlta: " + fechaDeAlta.getTime() +
                "   estado: " + estado+
                "\n";
    }

    //FUCNIONALIDADES
    public double puntajeTotal(Ticket ticket) {
        double acum = 0;

        acum += this.pesoAspectos[0] * this.puntajeLocacion(ticket.formularioDeBusqueda.getLocacion());
        acum += this.pesoAspectos[1] * this.puntajeRenumeracion(ticket);
        acum += this.pesoAspectos[2] * this.puntajeCargaHoraria(ticket);
        acum += this.pesoAspectos[3] * this.puntajeTipoDeTrabajo(ticket);
        acum += this.pesoAspectos[4] * this.puntajeRangoEtario(ticket);
        acum += this.pesoAspectos[5] * this.puntajeExperienciaPrevia(ticket);
        acum += this.pesoAspectos[6] * this.puntajeEstudiosCursados(ticket);

        return acum;
    }
}

