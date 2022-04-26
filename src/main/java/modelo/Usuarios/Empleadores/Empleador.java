package modelo.Usuarios.Empleadores;

import modelo.Tickets.Formulario_de_Busqueda;
import modelo.Tickets.Ticket;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.Usuarios.IGeneraTicket;
import modelo.Usuarios.Usuario;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class Empleador extends Usuario implements IGeneraTicket{
    private Persona tipoPersona;
    private String razonSocial;
    protected String rubro; // salud, comercio local o comercio internacional
    protected int puntaje;
    //Tickets
    private ArrayList<Ticket_de_Busqueda_de_Empleado> ticketsDeBusquedaDeEmpleado = new ArrayList<Ticket_de_Busqueda_de_Empleado>();

    //CONSTRUCTORES
    public Empleador(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    public Empleador(String nombreUsuario, String contrasena, Persona tipoPersona, String razonSocial, String rubro) {
        super(nombreUsuario, contrasena);
        this.tipoPersona = tipoPersona;
        this.razonSocial = razonSocial;
        this.rubro = rubro;
    }

    //GETTERS & ADDERS

    //FUNCIONALIDADES
    public void creaTicket(Formulario_de_Busqueda formulario, GregorianCalendar fechaAlta, int cantidadEmpleadosSolicitados,int[] vecPesos) {
        Ticket_de_Busqueda_de_Empleado nuevo = new Ticket_de_Busqueda_de_Empleado(formulario,fechaAlta,cantidadEmpleadosSolicitados,vecPesos);
        ticketsDeBusquedaDeEmpleado.add(nuevo);
    }

    public abstract double calculoComision(Ticket ticket);
    

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	
	 public int getIdUsuario() {
	    	return super.getIdUsuario();
	    }
}
