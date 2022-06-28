package persistencia;

import modelo.Sistema;
import modelo.constantes.Puntajes;
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
        ArrayList<String> tiposDeTrabajo = new ArrayList<>();

        tiposDeTrabajo.addAll(sistema.getTiposDeTrabajo());
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
        respuesta.setTiposDeTrabajo(tiposDeTrabajo);

        return respuesta;
    }

    public static void sistemaFromSistemaDTO(SistemaDTO sistemaDTO) throws EstadoException {

        ArrayList<EmpleadoPretenso> empleadosPretensos=new ArrayList<>();
        ArrayList<Empleador> empleadores = new ArrayList<>();
        ArrayList<Contrato> contratos = new ArrayList<>();
        HashMap<Ticket, Lista> listas = new HashMap<>();
        HashMap<Ticket_de_Busqueda_de_Empleado,Empleador> ticketsDeEmpleadores = new HashMap<>();
        HashMap<Ticket_de_Busqueda_de_Empleo, EmpleadoPretenso> ticketsDeEmpleadosPretensos = new HashMap<>();
        ArrayList<String> tiposDeTrabajo = new ArrayList<>();

        empleadosPretensos.addAll(sistemaDTO.getEmpleadosPretensos());
        empleadores.addAll(sistemaDTO.getEmpleadores());

        contratos.addAll(sistemaDTO.getContratos());
        listas.putAll(sistemaDTO.getListas());
        ticketsDeEmpleadores.putAll(sistemaDTO.getTicketsDeEmpleadores());
        ticketsDeEmpleadosPretensos.putAll(sistemaDTO.getTicketsDeEmpleadosPretensos());
        tiposDeTrabajo.addAll(sistemaDTO.getTiposDeTrabajo());

        Sistema.getInstance().setEmpleadores(empleadores);
        Sistema.getInstance().setEmpleadosPretensos(empleadosPretensos);
        Sistema.getInstance().setContratos(contratos);
        Sistema.getInstance().setListas(listas);
        Sistema.getInstance().setTicketsDeEmpleadores(ticketsDeEmpleadores);
        Sistema.getInstance().setTicketsDeEmpleadosPretensos(ticketsDeEmpleadosPretensos);
        Sistema.getInstance().setTiposDeTrabajo(tiposDeTrabajo);
    }

    public static void puntajeFromPuntajeDTO(PuntajesDTO puntajesDTO){
        Puntajes.setEdad1(puntajesDTO.getEdad1());
        Puntajes.setEdad2(puntajesDTO.getEdad2());
        Puntajes.setPuesto1(puntajesDTO.getPuesto1());
        Puntajes.setPuesto2(puntajesDTO.getPuesto2());
        Puntajes.setPuesto3(puntajesDTO.getPuesto3());
    }

    public static PuntajesDTO puntajesDTOFromPuntajes(){
        PuntajesDTO puntajesDTO=new PuntajesDTO();
        puntajesDTO.setEdad1(Puntajes.getEdad1());
        puntajesDTO.setEdad2(Puntajes.getEdad2());
        puntajesDTO.setPuesto1(Puntajes.getPuesto1());
        puntajesDTO.setPuesto2(Puntajes.getPuesto2());
        puntajesDTO.setPuesto3(Puntajes.getPuesto3());

        return puntajesDTO;

    }
}