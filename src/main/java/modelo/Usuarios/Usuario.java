package modelo.Usuarios;

import modelo.Sistema;

public abstract class Usuario {
    private Sistema sistema = Sistema.getInstance();
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
    public double calculaComision() {
        return -1;
    }

    public boolean usuarioValido(String nombreUsuario) {
        if (this.nombreUsuario.equalsIgnoreCase(nombreUsuario))
            return true;
        else
           return false;
    }

    public boolean contrasenaValida(String contrasena) {
        if (this.contrasena.equalsIgnoreCase(contrasena))
            return true;
        else
            return false;
    }
}
