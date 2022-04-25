package modelo;

import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.Usuarios.Usuario;
import modelo.listas.Listas;
import java.util.ArrayList;

public class Sistema{
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
    /**
     * Pre:
     * Post:
     * @param nuevo
     */
    public void registrarUsuario(Usuario nuevo) {
        try {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).usuarioValido(nuevo.getNombreUsuario()))
                    throw new ErrorDeUsuarioException("El nombre de usuario ingresado ya existe.");
            }
            usuarios.add(nuevo);
        } catch (ErrorDeUsuarioException e) {
            System.out.println(e.getMessage());
        }
    }

    public void login(String nombreUsuario, String contrasena){
        try {
            for (int i = 0;i < usuarios.size();i++)
                if (usuarios.get(i).usuarioValido(nombreUsuario))
                    if (usuarios.get(i).contrasenaValida(contrasena))
                        usuarios.get(i).setLoged(true);
                    else
                        throw new ErrorDeContrasenaException("La contrasena ingresada es incorrecta.");
            throw new ErrorDeUsuarioException("El usuario ingresado es incorrecto.");
        }
        catch (ErrorDeUsuarioException e1) {
            System.out.println(e1.getMessage());
        }
        catch (ErrorDeContrasenaException e2) {
            System.out.println(e2.getMessage());
        }
    }
}
