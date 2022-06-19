package persistencia;

import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.usuarios.Empleado_Pretenso;
import modelo.usuarios.empleadores.Empleador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SistemaDTO implements Serializable {
    private ArrayList<Empleador> empleadores = new ArrayList<>();
    private ArrayList<Empleado_Pretenso> empleadosPretensos = new ArrayList<>();
    private HashMap<Ticket_de_Busqueda_de_Empleado,Empleador> ticketsDeEmpleadores = new HashMap<>();
    private HashMap<Ticket_de_Busqueda_de_Empleo,Empleado_Pretenso> ticketsDeEmpleadosPretensos = new HashMap<>();

    public SistemaDTO(){

    }

    public SistemaDTO(ArrayList<Empleador> empleadores, ArrayList<Empleado_Pretenso> empleadosPretensos, HashMap<Ticket_de_Busqueda_de_Empleado, Empleador> ticketsDeEmpleadores, HashMap<Ticket_de_Busqueda_de_Empleo, Empleado_Pretenso> ticketsDeEmpleadosPretensos) {
        this.empleadores = empleadores;
        this.empleadosPretensos = empleadosPretensos;
        this.ticketsDeEmpleadores = ticketsDeEmpleadores;
        this.ticketsDeEmpleadosPretensos = ticketsDeEmpleadosPretensos;
    }

    public ArrayList<Empleador> getEmpleadores() {
        return empleadores;
    }

    public void setEmpleadores(ArrayList<Empleador> empleadores) {
        this.empleadores = empleadores;
    }

    public ArrayList<Empleado_Pretenso> getEmpleadosPretensos() {
        return empleadosPretensos;
    }

    public void setEmpleadosPretensos(ArrayList<Empleado_Pretenso> empleadosPretensos) {
        this.empleadosPretensos = empleadosPretensos;
    }

    public HashMap<Ticket_de_Busqueda_de_Empleado, Empleador> getTicketsDeEmpleadores() {
        return ticketsDeEmpleadores;
    }

    public void setTicketsDeEmpleadores(HashMap<Ticket_de_Busqueda_de_Empleado, Empleador> ticketsDeEmpleadores) {
        this.ticketsDeEmpleadores = ticketsDeEmpleadores;
    }

    public HashMap<Ticket_de_Busqueda_de_Empleo, Empleado_Pretenso> getTicketsDeEmpleadosPretensos() {
        return ticketsDeEmpleadosPretensos;
    }

    public void setTicketsDeEmpleadosPretensos(HashMap<Ticket_de_Busqueda_de_Empleo, Empleado_Pretenso> ticketsDeEmpleadosPretensos) {
        this.ticketsDeEmpleadosPretensos = ticketsDeEmpleadosPretensos;
    }
}
