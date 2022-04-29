package modelo.tickets;

public class Ticket_de_Busqueda_de_Empleado extends Ticket {
    private int cantEmpleadosSolicitados;
    private int cantEmpleadosObtenidos;
    private int[] pesoAspectos; //Dimension del arreglo = 7
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
}

