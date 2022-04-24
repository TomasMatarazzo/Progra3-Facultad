package modelo.Usuarios;

import excepciones.EstadoInvalidoException;
import modelo.Sistema;
import modelo.Tickets.Ticket;

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
            instance = new Agencia("Administrador","Guille");
        return instance;
    }

    //FUNCIONALIDADES

    public void activarRondaDeContrataciones (Eleccion trabajadores, Eleccion empresas, ListaDeContratos lista) throws EstadoInvalidoException {
    	sistema.rondaContrataciones(trabajadores,empresas,lista);
    }
}
