package persistencia;

import modelo.Sistema;
import modelo.excepciones.EstadoException;
import modelo.listas.Contrato;
import modelo.listas.Lista;
import modelo.tickets.Ticket;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.usuarios.EmpleadoPretenso;
import modelo.usuarios.empleadores.Empleador;

import java.util.ArrayList;
import java.util.HashMap;

public class Util {
    public static SistemaDTO sistemaDTOFromSistema(Sistema sistema){
        SistemaDTO respuesta=new SistemaDTO();
        ArrayList<EmpleadoPretenso> empleadosPretensos=new ArrayList<>();
        ArrayList<Empleador> empleadores = new ArrayList<>();
        HashMap<Ticket, Lista> listas = new HashMap<>();
        ArrayList<Contrato> contratos = new ArrayList<>();
        HashMap<Ticket_de_Busqueda_de_Empleado,Empleador> ticketsDeEmpleadores = new HashMap<>();
        HashMap<Ticket_de_Busqueda_de_Empleo, EmpleadoPretenso> ticketsDeEmpleadosPretensos = new HashMap<>();

        empleadosPretensos.addAll(sistema.getEmpleadosPretensos());
        empleadores.addAll(sistema.getEmpleadores());
        listas.putAll(sistema.getListas());
        contratos.addAll(sistema.getContratos());
        ticketsDeEmpleadores.putAll(sistema.getTicketsDeEmpleadores());
        ticketsDeEmpleadosPretensos.putAll(sistema.getTicketsDeEmpleadosPretensos());

        respuesta.setEmpleadosPretensos(empleadosPretensos);
        respuesta.setEmpleadores(empleadores);
        respuesta.setContratos(contratos);
        respuesta.setListas(listas);
        respuesta.setTicketsDeEmpleadores(ticketsDeEmpleadores);
        respuesta.setTicketsDeEmpleadosPretensos(ticketsDeEmpleadosPretensos);

        return respuesta;
    }

    public static void sistemaFromSistemaDTO(SistemaDTO sistemaDTO) throws EstadoException {

        ArrayList<EmpleadoPretenso> empleadosPretensos=new ArrayList<>();
        ArrayList<Empleador> empleadores = new ArrayList<>();
        ArrayList<Contrato> contratos = new ArrayList<>();
        HashMap<Ticket, Lista> listas = new HashMap<>();
        HashMap<Ticket_de_Busqueda_de_Empleado,Empleador> ticketsDeEmpleadores = new HashMap<>();
        HashMap<Ticket_de_Busqueda_de_Empleo, EmpleadoPretenso> ticketsDeEmpleadosPretensos = new HashMap<>();

        empleadosPretensos.addAll(sistemaDTO.getEmpleadosPretensos());
        empleadores.addAll(sistemaDTO.getEmpleadores());
        
        contratos.addAll(sistemaDTO.getContratos());
        listas.putAll(sistemaDTO.getListas());
        ticketsDeEmpleadores.putAll(sistemaDTO.getTicketsDeEmpleadores());
        ticketsDeEmpleadosPretensos.putAll(sistemaDTO.getTicketsDeEmpleadosPretensos());

        Sistema.getInstance().setEmpleadores(empleadores);
        Sistema.getInstance().setEmpleadosPretensos(empleadosPretensos);
        Sistema.getInstance().setContratos(contratos);
        Sistema.getInstance().setListas(listas);
        Sistema.getInstance().setTicketsDeEmpleadores(ticketsDeEmpleadores);
        Sistema.getInstance().setTicketsDeEmpleadosPretensos(ticketsDeEmpleadosPretensos);

        Sistema sistema=Sistema.getInstance();

        int i;

        for(Ticket_de_Busqueda_de_Empleado key: sistema.getTicketsDeEmpleadores().keySet()) {
            if(key.getEstado().equals("activado"))
                key.activar();
            else if(key.getEstado().equals("cancelado"))
                key.cancelar();
            else if(key.getEstado().equals("suspender"))
                key.suspender();
            else if(key.getEstado().equals("finalizar"))
                key.finalizar();

        }
        for(Ticket_de_Busqueda_de_Empleo key: sistema.getTicketsDeEmpleadosPretensos().keySet()) {
            if(key.getEstado().equals("activado"))
                key.activar();
            else if(key.getEstado().equals("cancelado"))
                key.cancelar();
            else if(key.getEstado().equals("suspender"))
                key.suspender();
            else if(key.getEstado().equals("finalizar"))
                key.finalizar();

        }
    }
}
