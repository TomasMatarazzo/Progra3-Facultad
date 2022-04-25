package modelo.Tickets;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Ticket_de_Busqueda_de_Empleado extends Ticket {
    private int cantEmpleadosSolicitados;
    private int cantEmpleadosObtenidos;
    private int[] pesoAspectos; //Dimension del arreglo = 7

    public Ticket_de_Busqueda_de_Empleado(Formulario_de_Busqueda formularioDeBusqueda, GregorianCalendar fechaDeAlta, int cantEmpleadosSolicitados, int[] pesoAspectos) {
        super(formularioDeBusqueda, fechaDeAlta, pesoAspectos);
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

