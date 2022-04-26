package modelo.Usuarios;

import modelo.Tickets.Ticket;

public abstract class Usuario {
    private static int n = -1;
    protected int IDUsuario;
    protected String nombreUsuario;
    protected String contrasena;
    

    //CONSTRUCTORES
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.IDUsuario = n++;
    }

    //FUNCIONALIDADES
    public void login() {
        System.out.println("HOLA");
    }

    public int getIdUsuario() {
    	return this.IDUsuario;
    }
 
}
