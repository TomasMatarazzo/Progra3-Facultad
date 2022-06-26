package modelo.usuarios;

import modelo.tickets.Ticket;

import java.io.Serializable;

public abstract class UsuarioComun extends Usuario implements Serializable {
    protected int puntaje;

    public UsuarioComun(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
        this.puntaje = 0;
    }

    protected UsuarioComun() {
    }

    //GETTERS & SETTERS
    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    

    //FUNCIONALIDADES
    public abstract double calculaComision(double remuneracion);

    public abstract void muestraLista();
}
