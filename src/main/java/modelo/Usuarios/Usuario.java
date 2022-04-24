package modelo.Usuarios;

public abstract class Usuario {
    private static int n = -1;
    protected int IDUsuario;
    protected String nombreUsuario;
    protected String contrasena;
    protected int puntaje;

    //CONSTRUCTORES
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.IDUsuario = n++;
        this.puntaje = 0;
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

    //FUNCIONALIDADES
    public void login() {
        System.out.println("HOLA");
    }

    public double calculaComision() {
        return -1;
    }
}
