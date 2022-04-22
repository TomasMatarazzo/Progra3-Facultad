package modelo;

public class Ticket_de_Busqueda_de_Empleado extends Ticket{
    private int cantEmpleadosSolicitados;
    private int cantEmpleadosObtenidos;

    //CONSTRUCTOR
    public Ticket_de_Busqueda_de_Empleado(Formulario_de_Busqueda formularioDeBusqueda, String fechaDeAlta, int cantEmpleadosSolicitados, int cantEmpleadosObtenidos) {
        super(formularioDeBusqueda, fechaDeAlta);
        this.cantEmpleadosSolicitados = cantEmpleadosSolicitados;
        this.cantEmpleadosObtenidos = cantEmpleadosObtenidos;
    }
}
