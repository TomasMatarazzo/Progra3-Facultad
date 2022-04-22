package modelo;

import java.util.ArrayList;

public class Empleador extends Usuario{
    private String razonSocial;
    private String rubro; // salud, comercio local o comercio internacional
    //Ticket
    private ArrayList<Ticket_de_Busqueda_de_Empleado> ticketsDeBusquedaDeEmpleado = new ArrayList<Ticket_de_Busqueda_de_Empleado>();

}
