package modelo.usuarios;

import modelo.Sistema;

public abstract class Usuario {
    protected Sistema sistema = Sistema.getInstance();
    protected String nombreUsuario;
    protected String contrasena;
    protected boolean loged;

    //CONSTRUCTORES
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.loged = false;
    }

    //GETTERS & SETTERS
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setLoged(boolean loged) {
        this.loged = loged;
    }
}
