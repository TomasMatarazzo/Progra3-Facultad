package modelo;

import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import modelo.listas.Contrato;
import modelo.tickets.Ticket;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.usuarios.Empleado_Pretenso;
import modelo.usuarios.UsuarioComun;
import modelo.usuarios.empleadores.Empleador;
import modelo.listas.Lista;
import java.util.ArrayList;
import java.util.HashMap;

public class Sistema{
    private static Sistema instance = null;
    private ArrayList<UsuarioComun> usuarios = new ArrayList<>();

//    private ArrayList<Empleador> empleadores = new ArrayList<>();
//    private ArrayList<Empleado_Pretenso> empleadosPretensos = new ArrayList<>();

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

    //GETTERS & ADDERS
    public ArrayList<UsuarioComun> getUsuarios() {
        return usuarios;
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
    public void registrarUsuario(UsuarioComun nuevo) throws ErrorDeUsuarioException {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).usuarioValido(nuevo.getNombreUsuario()))
                throw new ErrorDeUsuarioException("El nombre de usuario ingresado ya existe.");
        }
        usuarios.add(nuevo);
        System.out.println("El usuario [" + nuevo.getNombreUsuario() + "] se ha registrado con exito.");
    }

    public void login(String nombreUsuario, String contrasena) throws ErrorDeContrasenaException, ErrorDeUsuarioException {
        boolean loged = false;

        for (int i = 0;i < usuarios.size();i++) {
            if (usuarios.get(i).usuarioValido(nombreUsuario))
                if (usuarios.get(i).contrasenaValida(contrasena)) {
                    loged = true;
                    System.out.println("El usuario [" + nombreUsuario + "] se ha logeado con exito.");
                } else
                    throw new ErrorDeContrasenaException("La contrasena ingresada es incorrecta.");
            usuarios.get(i).setLoged(loged);
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
            listas.put(ticketEmpleado,nuevalista);
        }
    }
}
