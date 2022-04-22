package modelo;

import java.util.ArrayList;

public class Sistema {
    private static Sistema instance = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Ticket_de_Busqueda_de_Empleado> ticketsBusquedaEmpleados = new ArrayList<Ticket_de_Busqueda_de_Empleado>();
    private ArrayList<Ticket_de_Busqueda_de_Empleo> ticketsBusquedaEmpleo = new ArrayList<Ticket_de_Busqueda_de_Empleo>();

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
        //VALIDAR RESGISTRO
        usuarios.add(nuevo);
    }

    public boolean buscaUsuario(Usuario usuario) {

        return false;
    }
}
