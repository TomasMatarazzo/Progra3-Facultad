package modelo.Tickets;

public class Formulario_de_Busqueda {
    private String locacion;
    private double remuneracion;
    private String cargaHoraria;
    private String tipoPuestoLaboral;
    private String rangoEtario;
    private String experienciaPrevia;
    private String estudiosCursados;

    //CONSTRUCTOR
    public Formulario_de_Busqueda(String locacion, double remuneracion, String cargaHoraria, String tipoPuestoLaboral, String rangoEtario, String experienciaPrevia, String estudiosCursados) {
        this.locacion = locacion;
        this.remuneracion = remuneracion;
        this.cargaHoraria = cargaHoraria;
        this.tipoPuestoLaboral = tipoPuestoLaboral;
        this.rangoEtario = rangoEtario;
        this.experienciaPrevia = experienciaPrevia;
        this.estudiosCursados = estudiosCursados;
    }

    //GETTERS
    public String getLocacion() {
        return locacion;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public String getTipoPuestoLaboral() {
        return tipoPuestoLaboral;
    }

    public String getRangoEtario() {
        return rangoEtario;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public String getEstudiosCursados() {
        return estudiosCursados;
    }

    //TO STRING
    @Override
    public String toString() {
        return  "   locacion: " + locacion +
                "   remuneracion: " + remuneracion +
                "   cargaHoraria: " + cargaHoraria +
                "   tipoPuestoLaboral: " + tipoPuestoLaboral +
                "   rangoEtario: " + rangoEtario +
                "   experienciaPrevia: " + experienciaPrevia +
                "   estudiosCursados: " + estudiosCursados;
    }
}