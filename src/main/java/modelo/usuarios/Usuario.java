package modelo.usuarios;

import java.util.Observable;

public abstract class Usuario extends Observable {
    protected String nombreUsuario;
    protected String contrasena;

    //CONSTRUCTORES
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    //GETTERS & SETTERS
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public abstract void loguearse();
}
