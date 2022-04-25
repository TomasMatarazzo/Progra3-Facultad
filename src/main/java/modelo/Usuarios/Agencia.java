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

    //GETTERS
    @Override
    public String getTipo() {
        return "Agencia";
    }

    //FUNCIONALIDADES
    //2.
    public void muestraEmpleadores() {
        Empleador aux;

        if (sistema.getUsuarios().size() != 0) {
            System.out.println("Lista de empleadores: ");
            for (int i = 1;i < sistema.getUsuarios().size();i++)
                if (sistema.getUsuarios().get(i).getTipo().equalsIgnoreCase("EMPLEADOR")) {
                    aux = (Empleador) sistema.getUsuarios().get(i);
                    System.out.println(aux);
                }
        }
    }

    public void muestraSolicitudesEmpleadores() {
        Empleador aux;

        if (sistema.getUsuarios().size() != 0) {
            System.out.println("Lista de solicitudes de empleadores: ");
            for (int i = 1;i < sistema.getUsuarios().size();i++)
                if (sistema.getUsuarios().get(i).getTipo().equalsIgnoreCase("EMPLEADOR")) {
                    aux = (Empleador) sistema.getUsuarios().get(i);
                    System.out.println("    " + aux.getNombreUsuario() + ": ");
                    for (int j = 0;j < aux.getTicketsDeBusquedaDeEmpleado().size();j++)
                        System.out.println("        " + aux.getTicketsDeBusquedaDeEmpleado().get(i) + "\n");
                }
        }
    }

    public void muestraEmpleadosPretensos() {
        Empleado_Pretenso aux;

        if (sistema.getUsuarios().size() != 0) {
            System.out.println("Lista de empleados pretensos: ");
            for (int i = 1;i < sistema.getUsuarios().size();i++)
                if (sistema.getUsuarios().get(i).getTipo().equalsIgnoreCase("EMPLEADO PRETENSO")) {
                    aux = (Empleado_Pretenso) sistema.getUsuarios().get(i);
                    System.out.println(aux);
                }
        }
    }

    public void muestraSolicitudEmpleadosPretensos() {
        Empleado_Pretenso aux;

        if (sistema.getUsuarios().size() != 0) {
            System.out.println("Lista de solicitudes de empleadores: ");
            for (int i = 1;i < sistema.getUsuarios().size();i++)
                if (sistema.getUsuarios().get(i).getTipo().equalsIgnoreCase("EMPLEADO PRETENSO")) {
                    aux = (Empleado_Pretenso) sistema.getUsuarios().get(i);
                    System.out.println("    " + aux.getNombreUsuario() + ": ");
                    System.out.println(aux.getTicketDeBusquedaDeEmpleo());
                }
        }
    }

    //3.
    public void calculaComisiones() {
        double total = 0, aux;

        System.out.println("Comision a cobrar a cada Usuario: ");
        for (int i = 1;i < sistema.getUsuarios().size();i++) {
            aux = sistema.getUsuarios().get(i).calculaComision();
            System.out.println("\tUsuario: " + sistema.getUsuarios().get(i).getNombreUsuario() + " ~ Comision = $" + aux);
            total += aux;
        }
        System.out.println("\nMonto total a cobrar = $" + total);
    }
}
