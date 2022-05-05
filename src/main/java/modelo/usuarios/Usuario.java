package modelo.usuarios;

import modelo.Sistema;

public abstract class Usuario {
    private Sistema sistema = Sistema.getInstance();
    private static int n = -1;
    //--------------------------//
    protected int IDUsuario; //SE PUEDE OMITIR
    protected String nombreUsuario;
    protected String contrasena;
    protected boolean loged;

    //CONSTRUCTORES
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.IDUsuario = n++;
        this.loged = false;
    }

    //GETTERS & SETTERS
    public Sistema getSistema() {
        return sistema;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public abstract String getTipo();

    public void setLoged(boolean loged) {
        this.loged = loged;
    }

    //FUNCIONALIDADES
}
