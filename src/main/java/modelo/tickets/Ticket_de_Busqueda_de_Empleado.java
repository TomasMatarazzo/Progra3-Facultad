package modelo.tickets;

public class Ticket_de_Busqueda_de_Empleado extends Ticket {
    private int cantEmpleadosSolicitados;
    private int cantEmpleadosObtenidos;
    private int[] pesoAspectos; // pesoAspecto se encuentra dentro de la empresa.
    private Ticket_de_Busqueda_de_Empleo eleccion;

    //CONSTRUCTOR
    public Ticket_de_Busqueda_de_Empleado(Formulario_de_Busqueda formularioDeBusqueda, String tipoDeTrabajo, int cantEmpleadosSolicitados, int cantEmpleadosObtenidos, int[] pesoAspectos) {
        super(formularioDeBusqueda, tipoDeTrabajo);
        this.cantEmpleadosSolicitados = cantEmpleadosSolicitados;
        this.cantEmpleadosObtenidos = cantEmpleadosObtenidos;
        this.pesoAspectos = pesoAspectos;
        this.eleccion = null;
    }

    //GETTERS
    public int getCantEmpleadosSolicitados() {
        return cantEmpleadosSolicitados;
    }

    public int getCantEmpleadosObtenidos() {
        return cantEmpleadosObtenidos;
    }

    public void setCantEmpleadosObtenidos(int cantEmpleadosObtenidos) {
        this.cantEmpleadosObtenidos = cantEmpleadosObtenidos;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Ticket de Busqueda de Empleado: " +
                "   formularioDeBusqueda: " + formularioDeBusqueda.toString() +
                "   fechaDeAlta: " + fechaDeAlta +
                "   estado: " + estado +
                "   cantEmpleadosSolicitados: " + cantEmpleadosSolicitados +
                "   cantEmpleadosObtenidos: " + cantEmpleadosObtenidos;
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

