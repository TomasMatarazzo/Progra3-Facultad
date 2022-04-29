package modelo.usuarios;

public abstract class UsuarioComun extends Usuario{
    protected int puntaje;

    public UsuarioComun(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
        this.puntaje = 0;
    }

    //GETTERS
    public int getPuntaje() {
        return puntaje;
    }

    //FUNCIONALIDADES
    public abstract double calculaComision();
}
