package modelo.Usuarios;

import modelo.Sistema;

//QUEDA EN DUDA EL TEMA DEL SINGLETON DE LA PROPIA AGENCIA --> RESOLVER
public class Agencia extends Usuario {
    private static Agencia instance = null;
    private static Sistema sistema = Sistema.getInstance();


    //PATRON SINGLETON
    private Agencia(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    public static Agencia getInstance() {
        if (instance == null)
            instance = new Agencia("Administrador","Guille<3");
        return instance;
    }

    //FUNCIONALIDADES
    public void calculaComisiones() {
        double total = 0, aux;

        System.out.println("Comision a cobrar a cada Usuario: ");
        for (int i = 1;i < sistema.getUsuarios().size();i++) {
            aux = sistema.getUsuarios().get(i).calculaComision();
            System.out.println("\tUsuario: " + sistema.getUsuarios().get(i).nombreUsuario + " ~ Comision = $" + aux);
            total += aux;
        }
        System.out.println("\nMonto total a cobrar = $" + total);
    }
}
