package modelo;

import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import modelo.tickets.Ticket;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.usuarios.Empleado_Pretenso;
import modelo.usuarios.empleadores.Empleador;
import modelo.usuarios.Usuario;
import modelo.listas.Lista;
import java.util.ArrayList;
import java.util.HashMap;

public class Sistema{
    private static Sistema instance = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<String> tiposDeTrabajo = new ArrayList<String>();
    private HashMap<Ticket_de_Busqueda_de_Empleado,Empleador> TicketsDeEmpleadores = new HashMap<>();
    private HashMap<Ticket_de_Busqueda_de_Empleo,Empleado_Pretenso> TicketsDeEmpleadosPretensos = new HashMap<>();
    private HashMap<Ticket,Lista> listas = new HashMap<>();
    private ArrayList<Contrato> contratos = new ArrayList<Contrato>();

    //PATRON SINGLETON
    private Sistema() {
    }

    public static Sistema getInstance() {
        if (instance == null)
            instance = new Sistema();
        return instance;
    }

    //GETTERS & ADDERS
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<String> getTiposDeTrabajo() {
        return tiposDeTrabajo;
    }

    public HashMap<Ticket_de_Busqueda_de_Empleado, Empleador> getTicketsDeEmpleadores() {
        return TicketsDeEmpleadores;
    }

    public HashMap<Ticket_de_Busqueda_de_Empleo, Empleado_Pretenso> getTicketsDeEmpleadosPretensos() {
        return TicketsDeEmpleadosPretensos;
    }

    public HashMap<Ticket, Lista> getListas() {
        return listas;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    //FUNCIONALIDADES
    public void registrarUsuario(Usuario nuevo) throws ErrorDeUsuarioException {
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

        if (!loged)
            throw new ErrorDeUsuarioException("El usuario ingresado es incorrecto.");
    }

//    public void creaTicket(Formulario_de_Busqueda formulario, GregorianCalendar fechaAlta, int[] pesos) throws TicketYaCreadoException {
//        if (this.ticketDeBusquedaDeEmpleo == null || this.getTicketDeBusquedaDeEmpleo().getEstado().equalsIgnoreCase("FINALIZADO"))
//            this.ticketDeBusquedaDeEmpleo = new Ticket_de_Busqueda_de_Empleo(formulario, fechaAlta, pesos);
//        else
//            throw new TicketYaCreadoException("No puede existir mas de un ticket.");
//    }
}
