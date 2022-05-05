package modelo;

import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import modelo.listas.Contrato;
import modelo.tickets.Ticket;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.usuarios.Agencia;
import modelo.usuarios.Empleado_Pretenso;
import modelo.usuarios.empleadores.Empleador;
import modelo.listas.Lista;
import java.util.ArrayList;
import java.util.HashMap;

public class Sistema{
    private static Sistema instance = null;
    private Agencia agencia;
    private ArrayList<Empleador> empleadores = new ArrayList<>();
    private ArrayList<Empleado_Pretenso> empleadosPretensos = new ArrayList<>();
    private ArrayList<String> tiposDeTrabajo = new ArrayList<>();
    private HashMap<Ticket_de_Busqueda_de_Empleado,Empleador> ticketsDeEmpleadores = new HashMap<>();
    private HashMap<Ticket_de_Busqueda_de_Empleo,Empleado_Pretenso> ticketsDeEmpleadosPretensos = new HashMap<>();
    private HashMap<Ticket,Lista> listas = new HashMap<>();
    private ArrayList<Contrato> contratos = new ArrayList<>();

    //PATRON SINGLETON
    private Sistema() {
    }

    public static Sistema getInstance() {
        if (instance == null)
            instance = new Sistema();
        return instance;
    }

    //GETTERS & SETTERS & ADDERS
    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public ArrayList<Empleador> getEmpleadores() {
        return empleadores;
    }

    public ArrayList<Empleado_Pretenso> getEmpleadosPretensos() {
        return empleadosPretensos;
    }

    public ArrayList<String> getTiposDeTrabajo() {
        return tiposDeTrabajo;
    }

    public HashMap<Ticket_de_Busqueda_de_Empleado, Empleador> getTicketsDeEmpleadores() {
        return ticketsDeEmpleadores;
    }

    public HashMap<Ticket_de_Busqueda_de_Empleo, Empleado_Pretenso> getTicketsDeEmpleadosPretensos() {
        return ticketsDeEmpleadosPretensos;
    }

    public void agregaEmpleado(Empleador nuevo) {
        empleadores.add(nuevo);
    }

    public void agregaEmpleadoPretenso(Empleado_Pretenso nuevo) {
        empleadosPretensos.add(nuevo);
    }

    public void agregaTiposDeTrabajo(String nuevo) {
        tiposDeTrabajo.add(nuevo);
    }

    public void agregaTicketDeEmpleadosPretensos(Empleado_Pretenso usuario,Ticket_de_Busqueda_de_Empleo ticket) {
        ticketsDeEmpleadosPretensos.put(ticket,usuario);
    }

    public void agregaTicketDeEmpleadores(Empleador usuario,Ticket_de_Busqueda_de_Empleado ticket) {
        ticketsDeEmpleadores.put(ticket,usuario);
    }

    public HashMap<Ticket,Lista> getListas() {
        return listas;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    //FUNCIONALIDADES
    public void registrarUsuario(Empleador nuevo) throws ErrorDeUsuarioException {
        for (int i = 0; i < empleadores.size(); i++) {
            if (empleadores.get(i).getNombreUsuario().equalsIgnoreCase(nuevo.getNombreUsuario()))
                throw new ErrorDeUsuarioException("El nombre de usuario ingresado ya existe.");
        }
        empleadores.add(nuevo);
        System.out.println("El usuario [" + nuevo.getNombreUsuario() + "] se ha registrado con exito.");
    }

    public void registrarUsuario(Empleado_Pretenso nuevo) throws ErrorDeUsuarioException {
        for (int i = 0; i < empleadosPretensos.size(); i++) {
            if (empleadosPretensos.get(i).getNombreUsuario().equalsIgnoreCase(nuevo.getNombreUsuario()))
                throw new ErrorDeUsuarioException("El nombre de usuario ingresado ya existe.");
        }
        empleadosPretensos.add(nuevo);
        System.out.println("El usuario [" + nuevo.getNombreUsuario() + "] se ha registrado con exito.");
    }

    public void login(String nombreUsuario, String contrasena) throws ErrorDeContrasenaException, ErrorDeUsuarioException {
        boolean loged = false;
        int i = 0;

        while (i < empleadores.size() && loged == false) {
            if (empleadores.get(i).getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                if (empleadores.get(i).getContrasena().equalsIgnoreCase(contrasena)) {
                    loged = true;
                    System.out.println("El usuario [" + nombreUsuario + "] se ha logeado con exito.");
                } else
                    throw new ErrorDeContrasenaException("La contrasena ingresada es incorrecta.");
            else
                i++;
        }

        i = 0;
        while (i < empleadosPretensos.size() && loged == false) {
            if (empleadosPretensos.get(i).getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                if (empleadosPretensos.get(i).getContrasena().equalsIgnoreCase(contrasena)) {
                    loged = true;
                    System.out.println("El usuario [" + nombreUsuario + "] se ha logeado con exito.");
                } else
                    throw new ErrorDeContrasenaException("La contrasena ingresada es incorrecta.");
            else
                i++;
        }

        if (loged == false)
            throw new ErrorDeUsuarioException("El usuario ingresado es incorrecto.");
    }

    public void rondaEncuentrosLaborales(){
        double puntaje;
        
        for(Ticket_de_Busqueda_de_Empleado ticketEmpleador:ticketsDeEmpleadores.keySet()){
            Lista nuevalista = new Lista();
            for ( Ticket_de_Busqueda_de_Empleo ticketEmpleado: ticketsDeEmpleadosPretensos.keySet()){
                puntaje = ticketEmpleador.puntajeTotal(ticketEmpleado);
                ticketEmpleado.setPuntajeTotal(puntaje);
                if (ticketEmpleador.getTipoDeTrabajo().equalsIgnoreCase(ticketEmpleado.getTipoDeTrabajo())){
                    nuevalista.ofertas.add(ticketEmpleado);
                }

            }
            ticketsDeEmpleadores.get(nuevalista.ofertas.first()).setPuntaje(ticketsDeEmpleadores.get(nuevalista.ofertas.first()).getPuntaje()-5);
            ticketsDeEmpleadores.get(nuevalista.ofertas.last()).setPuntaje(ticketsDeEmpleadores.get(nuevalista.ofertas.last()).getPuntaje()+5);
            listas.put(ticketEmpleador,nuevalista);
        }

        for(Ticket_de_Busqueda_de_Empleo ticketEmpleado:ticketsDeEmpleadosPretensos.keySet()){
            Lista nuevalista = new Lista();
            for(Ticket_de_Busqueda_de_Empleado ticketEmpleador:ticketsDeEmpleadores.keySet()){
                puntaje = ticketEmpleador.puntajeTotal(ticketEmpleado);
                ticketEmpleador.setPuntajeTotal(puntaje);
                if (ticketEmpleador.getTipoDeTrabajo().equalsIgnoreCase(ticketEmpleado.getTipoDeTrabajo())){
                    nuevalista.ofertas.add(ticketEmpleador);
                }
            }
            ticketsDeEmpleadosPretensos.get(nuevalista.ofertas.last()).setPuntaje(ticketsDeEmpleadosPretensos.get(nuevalista.ofertas.last()).getPuntaje()+10);
            listas.put(ticketEmpleado,nuevalista);
        }
    }
}
