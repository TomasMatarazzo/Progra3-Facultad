package modelo.usuarios;

import java.io.Serializable;
import java.util.Observable;

public abstract class Usuario extends Observable implements Serializable {
    protected String nombreUsuario;
    protected String contrasena;

    //CONSTRUCTORES
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    protected Usuario() {
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
