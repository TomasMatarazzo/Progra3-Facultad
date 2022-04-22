package modelo.Tickets;

import excepciones.EstadoInvalidoException;

import java.util.GregorianCalendar;

///GREGORIAN CALENDAR CON LA FECHA DE ALTA --> COMPLETAR
public abstract class Ticket {
    protected Formulario_de_Busqueda formularioDeBusqueda;
    protected GregorianCalendar fechaDeAlta;
    protected String estado; // activo-suspendido-cancelado-finalizado

    //CONSTRUCTOR
    public Ticket(Formulario_de_Busqueda formularioDeBusqueda, GregorianCalendar fechaDeAlta) {
        this.formularioDeBusqueda = formularioDeBusqueda;
        this.fechaDeAlta = fechaDeAlta;
        this.estado = "Activo";
    }

    //FUNCIONALIDADES
    public void altaTicket() {
        if (!this.estado.equals("Cancelado")) //Una vez cancelado no se puede volver a activar.
            this.estado = "Activo";
    }

    public void bajaTicket() {
        //Un ticket pasa a cancelado por petición de la parte. --> AVERIGUAR BIEN
        this.estado = "Cancelado";
    }

    public void modificaTicket() throws EstadoInvalidoException {
        //Un ticket deja de estar activo y pasa a suspendido (y viceversa) por decisión del propietario.
        if (this.estado.equals("Activo"))
            this.estado = "Suspendido";
        else if (this.estado.equals("Suspendido"))
            this.estado = "Activo";
        else
            throw new EstadoInvalidoException("El estado del ticket no corresponde a la accion solicitada.");
    }

    public void finalizaTicket() {
        this.estado = "Finalizado";
    }



}
