package modelo.Tickets;

import modelo.Tickets.Locaciones.Locacion;

public class Formulario_de_Busqueda {
    private Locacion locacion;
    private double remuneracion;
    private int cargaHoraria;
    private int tipoPuestoLaboral;
    private int rangoEtario;
    private int experienciaPrevia;
    private int estudiosCursados;

    // CONSTRUCTOR

    public Formulario_de_Busqueda(Locacion locacion, double remuneracion, int cargaHoraria, int tipoPuestoLaboral,
            int rangoEtario, int experienciaPrevia, int estudiosCursados) {
        this.locacion = locacion;
        this.remuneracion = remuneracion;
        this.cargaHoraria = cargaHoraria;
        this.tipoPuestoLaboral = tipoPuestoLaboral;
        this.rangoEtario = rangoEtario;
        this.experienciaPrevia = experienciaPrevia;
        this.estudiosCursados = estudiosCursados;
    }

    // GETTERS

    public Locacion getLocacion() {
        return locacion;
    }

    public int puntajeLocacion(Locacion locacion) {
        return this.locacion.puntajeLocacion(locacion);
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getTipoPuestoLaboral() {
        return tipoPuestoLaboral;
    }

    public int getRangoEtario() {
        return rangoEtario;
    }

    public int getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public int getEstudiosCursados() {
        return estudiosCursados;
    }

    // TO STRING
    @Override
    public String toString() {
        return "   locacion: " + locacion +
                "   remuneracion: " + remuneracion +
                "   cargaHoraria: " + cargaHoraria +
                "   tipoPuestoLaboral: " + tipoPuestoLaboral +
                "   rangoEtario: " + rangoEtario +
                "   experienciaPrevia: " + experienciaPrevia +
                "   estudiosCursados: " + estudiosCursados;
    }
}