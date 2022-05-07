package modelo.usuarios;

import modelo.Sistema;
import modelo.constantes.Puntajes;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;

public class Agencia extends Usuario {
    private static Sistema sistema = Sistema.getInstance();

    public Agencia(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    //GETTERS

    //FUNCIONALIDADES
    public void muestraEmpleadores() {
        System.out.println("Lista de empleadores: ");
        for (int i = 0;i < sistema.getEmpleadores().size();i++)
            System.out.println(sistema.getEmpleadores().get(i));
    }

    public void muestraSolicitudesEmpleadores() {
        System.out.println("Lista de solicitudes de empleadores: ");
        for (Ticket_de_Busqueda_de_Empleado i : sistema.getTicketsDeEmpleadores().keySet())
            System.out.println(i);
    }

    public void muestraEmpleadosPretensos() {
        System.out.println("Lista de empleados pretensos: ");
        for (int i = 0;i < sistema.getEmpleadosPretensos().size();i++)
            System.out.println(sistema.getEmpleadosPretensos().get(i));
    }

    public void muestraSolicitudEmpleadosPretensos() {
        System.out.println("Lista de solicitudes de empleadores: ");
        for (Ticket_de_Busqueda_de_Empleo i : sistema.getTicketsDeEmpleadosPretensos().keySet())
            System.out.println(i);
    }

    //3.
    public void calculaComisiones() {
        double total = 0, aux = 0;

        System.out.println("Comision a cobrar a cada Empleador: ");
        for (int i = 0;i < sistema.getEmpleadores().size();i++) {
            aux = sistema.getEmpleadores().get(i).calculaComision();
            System.out.println("\tUsuario: " + sistema.getEmpleadores().get(i).getNombreUsuario() + " ~ Comision = $" + aux);
            total += aux;
        }

        System.out.println("Comision a cobrar a cada Empleado pretenso: ");
        for (int i = 0;i < sistema.getEmpleadosPretensos().size();i++) {
            aux = sistema.getEmpleadosPretensos().get(i).calculaComision();
            System.out.println("\tUsuario: " + sistema.getEmpleadosPretensos().get(i).getNombreUsuario() + " ~ Comision = $" + aux);
            total += aux;
        }

        System.out.println("\nMonto total a cobrar = $" + total);
    }

    public void agregarTipoDeTrabajo(String trabajo) {

        //SE INGRESAN LOS VALORES A PARTIR DE UN FORMULARIO

        sistema.agregaTiposDeTrabajo("Camarero");
        sistema.agregaTiposDeTrabajo("Taxista");
        sistema.agregaTiposDeTrabajo("Bombero");
        sistema.agregaTiposDeTrabajo("Piloto");
        sistema.agregaTiposDeTrabajo("Marinero");
    }

    public void confeccionarRangoEtario(int edad1, int edad2){
        // hay que ingresar los valores que van a ser usados para el rango de edad
        // se encuentra definido dentro de las constantes.
        Puntajes.setEdad2(edad2);
        Puntajes.setEdad1(edad1);

    }

    public void confeccionarTipoDePuesto(String puesto1, String puesto2, String puesto3){
        // hay que ingresar los valores que van a ser usados para v1 y v2 para el rango de edad
        // se encuentra definido dentro de las constantes.
        Puntajes.setPuesto1( puesto1 );
        Puntajes.setPuesto2( puesto2 );
        Puntajes.setPuesto3( puesto3 );

    }
}