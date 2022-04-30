package modelo.tickets;
import interfaces.ILocacion;
import modelo.constantes.Puntajes;
import modelo.tickets.Locaciones.LocacionFactory;
import modelo.tickets.Locaciones.LocacionHomeOffice;

public class Formulario_de_Busqueda {
    private ILocacion locacion;
    private double remuneracion;
    private int cargaHoraria;
    private int tipoPuestoLaboral;
    private int rangoEtario;
    private int experienciaPrevia;
    private int estudiosCursados;

    // CONSTRUCTOR

    public Formulario_de_Busqueda(ILocacion locacion, double remuneracion, int cargaHoraria, int tipoPuestoLaboral,
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

    public ILocacion getLocacion() {
        return locacion;
    }

    public int puntajeLocacion(ILocacion locacion) {
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

        return  "--FORMULARIO DE BUSQUEDA--  \n"+
                "   locacion: " + locacion.toString() + "\n" +
                "   remuneracion: " + remuneracion + "\n"+
                "   cargaHoraria: " + Puntajes.NOMBRES_FORM_BUSQUEDA[0][cargaHoraria] +"\n"+
                "   tipoPuestoLaboral: " + Puntajes.NOMBRES_FORM_BUSQUEDA[1][tipoPuestoLaboral]+"\n"+
                "   rangoEtario: " + Puntajes.NOMBRES_FORM_BUSQUEDA[2][rangoEtario] +"\n"+
                "   experienciaPrevia: " + Puntajes.NOMBRES_FORM_BUSQUEDA[3][experienciaPrevia] +"\n"+
                "   estudiosCursados: " + Puntajes.NOMBRES_FORM_BUSQUEDA[4][estudiosCursados];
    }

    public static void main(String[] args) {
        LocacionFactory factoryLocacion = new LocacionFactory();
        ILocacion locacion1 = factoryLocacion.getLocacion("presencial");
        int[] pesoAspectos ={1,1,1,1,1,1,1};
        Formulario_de_Busqueda form1 = new Formulario_de_Busqueda(locacion1,25000,1,1,1,1,1);
        Formulario_de_Busqueda form2 = new Formulario_de_Busqueda(factoryLocacion.getLocacion("indistinto"),60000,1,1,1,1,1);
        Ticket_de_Busqueda_de_Empleado ticket1 = new Ticket_de_Busqueda_de_Empleado(form1,"no se",1,1,pesoAspectos);
        Ticket_de_Busqueda_de_Empleo ticket2 = new Ticket_de_Busqueda_de_Empleo(form2,"no se");
        ticket1.puntajeTotal(ticket2);
        System.out.printf(form1.toString());
    }
}