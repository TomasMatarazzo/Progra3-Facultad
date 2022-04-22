package modelo.Usuarios;

import modelo.Tickets.Formulario_de_Busqueda;

import java.util.GregorianCalendar;

public abstract class Usuario {
    protected String nombreUsuario;
    protected String contrasena;
    protected int puntaje;

    //CONSTRUCTORES
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.puntaje = 0;
    }

    //FUNCIONALIDADES
    public void login() {
        System.out.println("HOLA");
    }

}
