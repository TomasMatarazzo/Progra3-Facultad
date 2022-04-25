package modelo.Tickets;

import excepciones.EstadoInvalidoException;
import modelo.Constantes.Puntajes;
import modelo.Tickets.Locaciones.Locacion;

import java.util.GregorianCalendar;

///GREGORIAN CALENDAR CON LA FECHA DE ALTA --> COMPLETAR
public abstract class Ticket {
    private static int n = -1;
    protected int IDTicket;
    protected Formulario_de_Busqueda formularioDeBusqueda;
    protected GregorianCalendar fechaDeAlta;
    protected String estado; // activo-suspendido-cancelado-finalizado
    private int[] pesoAspectos; //Dimension del arreglo = 7

    //CONSTRUCTOR
    public Ticket(Formulario_de_Busqueda formularioDeBusqueda, GregorianCalendar fechaDeAlta, int [] pesoAspectos) {
        this.formularioDeBusqueda = formularioDeBusqueda;
        this.fechaDeAlta = fechaDeAlta;
        this.pesoAspectos = pesoAspectos;
        this.IDTicket = n++;
        this.estado = "Activo";
    }

    // ABMC

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

    // PUNTAJES
    // Este caso seria el caso base , en el que es indistinto

    // PUNTAJES


    public double puntajeTotal(Ticket ticket){
        double acum = 0;
        acum += this.pesoAspectos[0] * this.puntajeLocacion(ticket.formularioDeBusqueda.getLocacion());
        System.out.printf("\nlocacion:" + this.puntajeLocacion(ticket.formularioDeBusqueda.getLocacion()));
        acum += this.pesoAspectos[0] * this.puntajeRangoEtario(ticket);
        System.out.printf("\nrango etario:" + this.puntajeRangoEtario(ticket));

        acum += this.pesoAspectos[0] * this.puntajeTipoDeTrabajo(ticket);
        System.out.printf("\ntrabajo:" + this.puntajeTipoDeTrabajo(ticket));

        acum += this.pesoAspectos[0] * this.puntajeCargaHoraria(ticket);
        System.out.printf("\ncarga horaria:" + this.puntajeCargaHoraria(ticket));

        return acum;
    }

    // Double dispatch con la locacion.



    // Para el resto de puntajes los calcularemos mediante matrices
    public int puntajeLocacion(Locacion locacion){
        return this.formularioDeBusqueda.puntajeLocacion(locacion);
    }

    public double puntajeRenumeracion(Ticket ticket){
        return Puntajes.RENUMERACION[this.getTipoPuestoLaboral()][ticket.getTipoPuestoLaboral()];
    }

    public double puntajeCargaHoraria(Ticket ticket){
        return Puntajes.MATRIZ2[this.getCargaHoraria()][ticket.getCargaHoraria()];
    }

    public double puntajeTipoDeTrabajo(Ticket ticket){
        return Puntajes.MATRIZ2[this.getTipoPuestoLaboral()][ticket.getTipoPuestoLaboral()];
    }

    public double puntajeRangoEtario(Ticket ticket){
        return Puntajes.MATRIZ2[this.getRangoEtario()][ticket.getRangoEtario()];
    }

    public double puntajeExperienciaPrevia(Ticket ticket){
        return Puntajes.MATRIZ3[this.getExperienciaPrevia()][ticket.getExperienciaPrevia()];
    }

    public double puntajeEstudiosCursados(Ticket ticket){
        return Puntajes.MATRIZ3[this.getEstudiosCursados()][ticket.getEstudiosCursados()];
    }

    // GETTERS Y SETTERS

    public double getRemuneracion() {
        return formularioDeBusqueda.getRemuneracion();
    }

    public int getCargaHoraria() {
        return formularioDeBusqueda.getCargaHoraria();
    }

    public int getTipoPuestoLaboral() {
        return formularioDeBusqueda.getTipoPuestoLaboral();
    }

    public int getRangoEtario() {
        return formularioDeBusqueda.getRangoEtario();
    }

    public int getExperienciaPrevia() {
        return formularioDeBusqueda.getExperienciaPrevia();
    }

    public int getEstudiosCursados() {
        return formularioDeBusqueda.getEstudiosCursados();
    }


}
