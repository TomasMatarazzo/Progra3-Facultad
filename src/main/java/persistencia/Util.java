package persistencia;

import modelo.Sistema;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.usuarios.Empleado_Pretenso;
import modelo.usuarios.empleadores.Empleador;

import java.util.ArrayList;
import java.util.HashMap;

public class Util {
    public static SistemaDTO sistemaDTOFromSistema(){
        SistemaDTO respuesta=new SistemaDTO();
        ArrayList<Empleado_Pretenso> empleadosPretensos=new ArrayList<>();
        ArrayList<Empleador> empleadores = new ArrayList<>();
        HashMap<Ticket_de_Busqueda_de_Empleado,Empleador> ticketsDeEmpleadores = new HashMap<>();
        HashMap<Ticket_de_Busqueda_de_Empleo,Empleado_Pretenso> ticketsDeEmpleadosPretensos = new HashMap<>();

        empleadosPretensos.addAll(Sistema.getInstance().getEmpleadosPretensos());
        empleadores.addAll(Sistema.getInstance().getEmpleadores());
        ticketsDeEmpleadores.putAll(Sistema.getInstance().getTicketsDeEmpleadores());
        ticketsDeEmpleadosPretensos.putAll(Sistema.getInstance().getTicketsDeEmpleadosPretensos());

        respuesta.setEmpleadosPretensos(empleadosPretensos);
        respuesta.setEmpleadores(empleadores);
        respuesta.setTicketsDeEmpleadores(ticketsDeEmpleadores);
        respuesta.setTicketsDeEmpleadosPretensos(ticketsDeEmpleadosPretensos);

        return respuesta;
    }

    public static void sistemaFromSistemaDTO(SistemaDTO sistemaDTO){

        ArrayList<Empleado_Pretenso> empleadosPretensos=new ArrayList<>();
        ArrayList<Empleador> empleadores = new ArrayList<>();
        HashMap<Ticket_de_Busqueda_de_Empleado,Empleador> ticketsDeEmpleadores = new HashMap<>();
        HashMap<Ticket_de_Busqueda_de_Empleo,Empleado_Pretenso> ticketsDeEmpleadosPretensos = new HashMap<>();

        empleadosPretensos.addAll(sistemaDTO.getEmpleadosPretensos());
        empleadores.addAll(sistemaDTO.getEmpleadores());
        ticketsDeEmpleadores.putAll(sistemaDTO.getTicketsDeEmpleadores());
        ticketsDeEmpleadosPretensos.putAll(sistemaDTO.getTicketsDeEmpleadosPretensos());

        Sistema.getInstance().setEmpleadores(empleadores);
        Sistema.getInstance().setEmpleadosPretensos(empleadosPretensos);
        Sistema.getInstance().setTicketsDeEmpleadores(ticketsDeEmpleadores);
        Sistema.getInstance().setTicketsDeEmpleadosPretensos(ticketsDeEmpleadosPretensos);
    }
}
