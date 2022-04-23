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

    //FUNCIONALIDADES
    public void login() {
        System.out.println("HOLA");
    }

}
