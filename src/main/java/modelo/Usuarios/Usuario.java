package modelo.Usuarios;

import modelo.Sistema;

public abstract class Usuario {
    private static int n = -1;
    //--------------------------//
    protected int IDUsuario;
    protected String nombreUsuario;
    protected String contrasena;
    protected boolean loged;
    protected int puntaje;

    //CONSTRUCTORES
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.IDUsuario = n++;
        this.puntaje = 0;
        this.loged = false;
    }

    //GETTERS & SETTERS
    public int getIDUsuario() {
        return IDUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public abstract String getTipo();

    public void setLoged(boolean loged) {
        this.loged = loged;
    }

    //FUNCIONALIDADES
    public boolean usuarioValido(String nombreUsuario) {
        return this.nombreUsuario.equalsIgnoreCase(nombreUsuario);
    }

    public boolean contrasenaValida(String contrasena) {
        return this.contrasena.equalsIgnoreCase(contrasena);
    }

}
