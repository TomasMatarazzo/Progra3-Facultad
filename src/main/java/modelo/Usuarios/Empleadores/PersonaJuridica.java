package modelo.Usuarios.Empleadores;

import modelo.Tickets.Ticket;
import modelo.Usuarios.Empleadores.Persona;

public class PersonaJuridica extends Empleador {

	public PersonaJuridica(String nombreUsuario, String contrasena) {
		super(nombreUsuario, contrasena);
		// TODO Auto-generated constructor stub
	}
	
	public double calculoComision(Ticket ticket) {
    	double aux=0;
    	switch (super.rubro) {
	    	case "salud":aux = 0.8; break;
	    	case "comercio local" :aux = 0.9;break;
	    	case "comercio internacional":aux=1.0;break;
    	}
    	return (ticket.getFormularioDeBusqueda().getRemuneracion()*aux);
    }
}
