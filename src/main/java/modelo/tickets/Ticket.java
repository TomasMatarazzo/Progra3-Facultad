package modelo.tickets;

import excepciones.EstadoInvalidoException;
import interfaces.ILocacion;
import modelo.constantes.Puntajes;

import java.util.GregorianCalendar;

///GREGORIAN CALENDAR CON LA FECHA DE ALTA --> COMPLETAR
public abstract class Ticket {
    protected Formulario_de_Busqueda formularioDeBusqueda;
    protected GregorianCalendar fechaDeAlta;
    protected String estado; // activo-suspendido-cancelado-finalizado
    protected String tipoDeTrabajo;

    // CONSTRUCTOR
    public Ticket(Formulario_de_Busqueda formularioDeBusqueda, String tipoDeTrabajo) {
        this.formularioDeBusqueda = formularioDeBusqueda;
        this.fechaDeAlta = new GregorianCalendar();
        this.estado = "Activo";
        this.tipoDeTrabajo = tipoDeTrabajo;
    }

    // GETTERS
    public Formulario_de_Busqueda getFormularioDeBusqueda() {
        return formularioDeBusqueda;
    }

    public GregorianCalendar getFechaDeAlta() {
        return fechaDeAlta;
    }

    public String getEstado() {
        return estado;
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

    // FUNCIONALIDADES
    public void altaTicket() {
        if (!this.estado.equals("Cancelado")) // Una vez cancelado no se puede volver a activar.
            this.estado = "Activo";
    }

    public void bajaTicket() {
        // Un ticket pasa a cancelado por petición de la parte. --> AVERIGUAR BIEN
        this.estado = "Cancelado";
    }

    public void modificaTicket() throws EstadoInvalidoException {
        // Un ticket deja de estar activo y pasa a suspendido (y viceversa) por decisión
        // del propietario.
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
        if (this.getRemuneracion() < Puntajes.V1) {
            return 0;
        } else if (this.getRemuneracion() < Puntajes.V2) {
            return 1;
        } else {
            return 2;
        }
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
}

}
