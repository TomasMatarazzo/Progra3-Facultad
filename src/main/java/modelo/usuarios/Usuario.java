package modelo.usuarios;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    protected String nombreUsuario;
    protected String contrasena;
    protected boolean loged;

    //CONSTRUCTORES
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.loged = false;
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

    public void setLoged(boolean loged) {
        this.loged = loged;
    }
}
