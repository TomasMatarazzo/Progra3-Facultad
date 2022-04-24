package modelo;

import excepciones.DatosMalIngresadosException;
import excepciones.ErrorDeUsuarioException;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.Usuarios.Empleado_Pretenso;
import modelo.Usuarios.Empleador;
import modelo.Usuarios.Usuario;
import modelo.listas.Listas;

import java.util.ArrayList;

public class Sistema{
    private static Sistema instance = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
    private ArrayList<Empleado_Pretenso> empleadosPretensos = new ArrayList<Empleado_Pretenso>();
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

    public ArrayList<Empleador> getEmpleadores() {
        return empleadores;
    }

    public ArrayList<Empleado_Pretenso> getEmpleadosPretensos() {
        return empleadosPretensos;
    }

    private void agregaEmpleador(Empleador nuevo) {
        empleadores.add(nuevo);
    }

    //FUNCIONALIDADES

    /**
     * Pre:
     * Post:
     * @param nuevo
     */
    public void registrarUsuario(Usuario nuevo) throws DatosMalIngresadosException, ErrorDeUsuarioException {
        //Registra solo si tiene Usuario y Contrasena
        if (!nuevo.getNombreUsuario().equalsIgnoreCase("") && !nuevo.getContrasena().equalsIgnoreCase("")) {
            //VALIDACION
            if (existeUsuario(nuevo))
                throw new ErrorDeUsuarioException("El nombre de usuario existente ya existe.");

            usuarios.add(nuevo);
            if (nuevo.getTipo().equalsIgnoreCase("EMPLEADOR"))
                empleadores.add((Empleador) nuevo);
            else if (nuevo.getTipo().equalsIgnoreCase("EMPLEADO PRETENSO"))
                empleadosPretensos.add((Empleado_Pretenso) nuevo);
            else
                throw new DatosMalIngresadosException("Los datos ingresados son incorrectos");
        }
    }

    public boolean existeUsuario(Usuario otro) {
        for (int i = 0;i < usuarios.size();i++)
            if (usuarios.get(i).getNombreUsuario().equalsIgnoreCase(otro.getNombreUsuario()))
                return true;
        return false;
    }
}
