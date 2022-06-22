package persistencia;

import modelo.listas.Contrato;
import modelo.listas.Lista;
import modelo.tickets.Ticket;
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
    private HashMap<Ticket, Lista> listas = new HashMap<>();
    private ArrayList<Contrato> contratos = new ArrayList<>();
    private HashMap<Ticket_de_Busqueda_de_Empleado,Empleador> ticketsDeEmpleadores = new HashMap<>();
    private HashMap<Ticket_de_Busqueda_de_Empleo,Empleado_Pretenso> ticketsDeEmpleadosPretensos = new HashMap<>();

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

    public HashMap<Ticket, Lista> getListas() {
        return listas;
    }

    public void setListas(HashMap<Ticket, Lista> listas) {
        this.listas = listas;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
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
