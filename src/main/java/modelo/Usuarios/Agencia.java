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
    //2.
    public void muestraEmpleadores() {
        System.out.println("Lista de empleadores: ");
        for (int i = 1;i < sistema.getEmpleadores().size();i++) {
                System.out.println(sistema.getEmpleadores().get(i));
        }
    }

    public void muestraSolicitudesEmpleadores() {
        Empleador auxEmpleador;

        System.out.println("Lista de solicitudes de empleadores: ");
        for (int i = 1;i < sistema.getEmpleadores().size();i++) {
            auxEmpleador = sistema.getEmpleadores().get(i);
            System.out.println("    " + auxEmpleador.nombreUsuario + ": ");
            for (int j = 0;j < auxEmpleador.getTicketsDeBusquedaDeEmpleado().size();j++) {
                System.out.println("        " + auxEmpleador.getTicketsDeBusquedaDeEmpleado().get(i) + "\n");
            }
        }
    }

    public void muestraEmpleadosPretensos() {
        System.out.println("Lista de empleados pretensos: ");
        for (int i = 1;i < sistema.getEmpleadosPretensos().size();i++) {
            System.out.println(sistema.getEmpleadosPretensos().get(i));
        }
    }

    public void muestraSolicitudEmpleadosPretensos() {
        System.out.println("Lista de solicitudes de empleados pretensos: ");
        for (int i = 1;i < sistema.getEmpleadosPretensos().size();i++) {
            System.out.println("    " + sistema.getEmpleadosPretensos().get(i).nombreUsuario + ": ");
            System.out.println(sistema.getEmpleadosPretensos().get(i).getTicketDeBusquedaDeEmpleo());
        }
    }

    //3.
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
