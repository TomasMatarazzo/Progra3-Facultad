package modelo.usuarios;

import modelo.Sistema;
import modelo.constantes.Puntajes;
import modelo.tickets.Ticket;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.usuarios.empleadores.Empleador;

import java.util.ArrayList;
import java.util.Map;

//QUEDA EN DUDA EL TEMA DEL SINGLETON DE LA PROPIA AGENCIA --> RESOLVER
public class Agencia extends Usuario {
    private static Agencia instance = null;
    private static Sistema sistema = Sistema.getInstance();
    
    //PATRON SINGLETON
    private Agencia(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    public static Agencia getInstance(String nombreUsuario, String contrasena) {
        if (instance == null)
            instance = new Agencia(nombreUsuario,contrasena);
        return instance;
    }

    //GETTERS
    @Override
    public String getTipo() {
        return "Agencia";
    }

    //FUNCIONALIDADES
    //2. Convencion: usuarios[0] = AGENCIA
    public void muestraEmpleadores() {
        Empleador aux;

        if (sistema.getUsuarios().size() != 0) {
            System.out.println("Lista de empleadores: ");
            for (int i = 0;i < sistema.getUsuarios().size();i++)
                if (sistema.getUsuarios().get(i).getTipo().equalsIgnoreCase("PERSONA FISICA") || sistema.getUsuarios().get(i).getTipo().equalsIgnoreCase("PERSONA JURIDICA")) {
                    aux = (Empleador) sistema.getUsuarios().get(i);
                    System.out.println(aux);
                }
        }
    }

    public void muestraSolicitudesEmpleadores() {
        if (sistema.getUsuarios().size() != 0) {
            System.out.println("Lista de solicitudes de empleadores: ");
            for (Ticket_de_Busqueda_de_Empleado i : sistema.getTicketsDeEmpleadores().keySet())
                System.out.println(i);
        }
    }

    public void muestraEmpleadosPretensos() {
        Empleado_Pretenso aux;

        if (sistema.getUsuarios().size() != 0) {
            System.out.println("Lista de empleados pretensos: ");
            for (int i = 0;i < sistema.getUsuarios().size();i++)
                if (sistema.getUsuarios().get(i).getTipo().equalsIgnoreCase("EMPLEADO PRETENSO")) {
                    aux = (Empleado_Pretenso) sistema.getUsuarios().get(i);
                    System.out.println(aux);
                }
        }
    }

    public void muestraSolicitudEmpleadosPretensos() {
        if (sistema.getUsuarios().size() != 0) {
            System.out.println("Lista de solicitudes de empleadores: ");
            for (Ticket_de_Busqueda_de_Empleo i : sistema.getTicketsDeEmpleadosPretensos().keySet())
                System.out.println(i);
        }
    }

    //3.
    public void calculaComisiones() {
        double total = 0, aux = 0;

        System.out.println("Comision a cobrar a cada Usuario: ");
        for (int i = 0;i < sistema.getUsuarios().size();i++) {
            aux = sistema.getUsuarios().get(i).calculaComision();
            System.out.println("\tUsuario: " + sistema.getUsuarios().get(i).getNombreUsuario() + " ~ Comision = $" + aux);
            total += aux;
        }

        System.out.println("\nMonto total a cobrar = $" + total);
    }

    public ArrayList<Ticket> confionarTipoDeTrabajo(String trabajo) {

        //SE INGRESAN LOS VALORES A PARTIR DE UN FORMULARIO

        sistema.agregaTiposDeTrabajo("Camarero");
        sistema.agregaTiposDeTrabajo("Taxista");
        sistema.agregaTiposDeTrabajo("Bombero");
        sistema.agregaTiposDeTrabajo("Piloto");
        sistema.agregaTiposDeTrabajo("Marinero");
    }
    
    public ArrayList<Ticket> confionarTipoPuestoLaboral( String tipoDePuesto) {

        ArrayList<Ticket> listaConfeccionada = new ArrayList<>();
        String puesto;

        for (Map.Entry<Ticket_de_Busqueda_de_Empleado, Empleador> elem : Sistema.getInstance().getTicketsDeEmpleadores().entrySet()) {
            puesto = Puntajes.NOMBRES_FORM_BUSQUEDA[0][elem.getKey().getTipoPuestoLaboral()]; // obtengo el nombre del puesto mediante su indice
            if (puesto.equalsIgnoreCase(tipoDePuesto)) {
                listaConfeccionada.add(elem.getKey());
            }
        }

        for (Map.Entry<Ticket_de_Busqueda_de_Empleo, Empleado_Pretenso> elem : Sistema.getInstance().getTicketsDeEmpleadosPretensos().entrySet()) {
            puesto = Puntajes.NOMBRES_FORM_BUSQUEDA[0][elem.getKey().getTipoPuestoLaboral()];
            if (puesto.equalsIgnoreCase(tipoDePuesto)) {
                listaConfeccionada.add(elem.getKey());
            }


        }
        return listaConfeccionada;
    }

    // confeccionar la de rango laboral
}
