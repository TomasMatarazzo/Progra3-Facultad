package modelo.tickets;

import modelo.tickets.Estados.ActivadoIStateTickets;
import modelo.excepciones.EstadoException;
import modelo.tickets.locaciones.ILocacion;
import modelo.tickets.Estados.IStateTickets;
import modelo.constantes.Puntajes;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Ticket implements Comparable, Serializable {
    protected Formulario_de_Busqueda formularioDeBusqueda;
    protected Calendar fechaDeAlta = Calendar.getInstance();
    private IStateTickets IStateTickets;
    protected String tipoDeTrabajo;
    protected double puntajeTotal;

    // CONSTRUCTOR
    public Ticket(Formulario_de_Busqueda formularioDeBusqueda, String tipoDeTrabajo) {
        this.formularioDeBusqueda = formularioDeBusqueda;
        this.IStateTickets = new ActivadoIStateTickets(this);
        this.fechaDeAlta = new GregorianCalendar();
        this.tipoDeTrabajo = tipoDeTrabajo;
        this.puntajeTotal = 0;
    }

    protected Ticket() {
    }

    public void activar() throws EstadoException {
        this.IStateTickets.activar();
    }
    public void cancelar() throws EstadoException {
        this.IStateTickets.cancelar();
    }
    public void finalizar() throws EstadoException {
        this.IStateTickets.finalizar();
    }
    public void suspender() throws EstadoException {
        this.IStateTickets.suspender();
    }

    // GETTERS && SETTERS
    public Formulario_de_Busqueda getFormularioDeBusqueda() {
        return formularioDeBusqueda;
    }

    public String getTipoDeTrabajo() {
        return tipoDeTrabajo;
    }

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

    public double getPuntajeTotal() {
        return puntajeTotal;
    }


    public void setState(IStateTickets IStateTickets){
        this.IStateTickets = IStateTickets;
    }
    public IStateTickets getState(){
        return this.IStateTickets;
    }

    public void setPuntajeTotal(double puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }


    // FUNCIONALIDADES
    // Double dispatch con la locacion.
    // Para el resto de puntajes los calcularemos mediante matrices
    public int puntajeLocacion(ILocacion locacion) {
        return this.formularioDeBusqueda.puntajeLocacion(locacion);
    }

    public double puntajeRenumeracion(Ticket ticket) {
        return Puntajes.RENUMERACION[this.indiceRenumeracion()][ticket.indiceRenumeracion()];
    }

    public double puntajeCargaHoraria(Ticket ticket) {
        return Puntajes.MATRIZ2[this.getCargaHoraria()][ticket.getCargaHoraria()];
    }

    public int indiceRenumeracion() {
        if (this.getRemuneracion() < Puntajes.V1)
            return 0;
        else
            if (this.getRemuneracion() < Puntajes.V2)
                return 1;
            else
                return 2;
    }

    public double puntajeTipoDeTrabajo(Ticket ticket) {
        return Puntajes.MATRIZ2[this.getTipoPuestoLaboral()][ticket.getTipoPuestoLaboral()];
    }

    public double puntajeRangoEtario(Ticket ticket) {
        return Puntajes.MATRIZ2[this.getRangoEtario()][ticket.getRangoEtario()];
    }

    public double puntajeExperienciaPrevia(Ticket ticket) {
        return Puntajes.MATRIZ3[this.getExperienciaPrevia()][ticket.getExperienciaPrevia()];
    }

    public double puntajeEstudiosCursados(Ticket ticket) {
        return Puntajes.MATRIZ3[this.getEstudiosCursados()][ticket.getEstudiosCursados()];
    }

    @Override
    public int compareTo(Object o) {
        Ticket aux = (Ticket) o;

        if (this.puntajeTotal > aux.puntajeTotal)
            return 1;
        else
            if (this.puntajeTotal == aux.puntajeTotal)
                return 0;
            else
                return -1;
    }
}
