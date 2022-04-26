package modelo.Tickets;

import java.util.GregorianCalendar;

public class Ticket_de_Busqueda_de_Empleado extends Ticket {
    private int cantEmpleadosSolicitados;
    private int cantEmpleadosObtenidos;
    private int[] pesoAspectos; //Dimension del arreglo = 7

    //CONSTRUCTOR
    public Ticket_de_Busqueda_de_Empleado(Formulario_de_Busqueda formularioDeBusqueda, GregorianCalendar fechaDeAlta, int cantEmpleadosSolicitados, int[] pesoAspectos) {
        super(formularioDeBusqueda, fechaDeAlta, pesoAspectos);
        this.cantEmpleadosSolicitados = cantEmpleadosSolicitados;
        this.cantEmpleadosObtenidos = 0;
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
                "   IDTicket: " + IDTicket +
                "   formularioDeBusqueda: " + formularioDeBusqueda.toString() +
                "   fechaDeAlta: " + fechaDeAlta +
                "   estado: " + estado +
                "   cantEmpleadosSolicitados: " + cantEmpleadosSolicitados +
                "   cantEmpleadosObtenidos: " + cantEmpleadosObtenidos;
    }
}

