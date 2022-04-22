package modelo.Tickets;

import modelo.Formulario_de_Busqueda;
import modelo.Tickets.Ticket;

import java.util.GregorianCalendar;

public class Ticket_de_Busqueda_de_Empleado extends Ticket {
    private int cantEmpleadosSolicitados;
    private int cantEmpleadosObtenidos;

    //CONSTRUCTOR
    public Ticket_de_Busqueda_de_Empleado(Formulario_de_Busqueda formularioDeBusqueda, GregorianCalendar fechaDeAlta, int cantEmpleadosSolicitados, int cantEmpleadosObtenidos) {
        super(formularioDeBusqueda, fechaDeAlta);
        this.cantEmpleadosSolicitados = cantEmpleadosSolicitados;
        this.cantEmpleadosObtenidos = 0;
    }

    public int getCantEmpleadosSolicitados() {
        return cantEmpleadosSolicitados;
    }

    public int getCantEmpleadosObtenidos() {
        return cantEmpleadosObtenidos;
    }

    public void setCantEmpleadosObtenidos(int cantEmpleadosObtenidos) {
        this.cantEmpleadosObtenidos = cantEmpleadosObtenidos;
    }
}
