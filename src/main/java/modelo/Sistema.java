package modelo;

import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.Usuarios.Usuario;
import modelo.listas.Listas;
import java.util.ArrayList;

public class Sistema {
    private static Sistema instance = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Ticket_de_Busqueda_de_Empleado> ticketsBusquedaEmpleados = new ArrayList<Ticket_de_Busqueda_de_Empleado>();
    private ArrayList<Ticket_de_Busqueda_de_Empleo> ticketsBusquedaEmpleo = new ArrayList<Ticket_de_Busqueda_de_Empleo>();
    private ArrayList<Listas> listas = new ArrayList<Listas>();

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

    //FUNCIONALIDADES
    public void registrarUsuario(Usuario nuevo) {
        //VALIDAR REGISTRO
        usuarios.add(nuevo);
    }

    public boolean buscaUsuario(Usuario usuario) {

        return false;
    }
}
