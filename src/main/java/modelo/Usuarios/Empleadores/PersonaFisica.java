package modelo.Usuarios.Empleadores;

import modelo.Tickets.Ticket;
import modelo.Usuarios.Empleadores.Persona;

public class PersonaFisica extends Empleador {

	public PersonaFisica(String nombreUsuario, String contrasena) {
		super(nombreUsuario, contrasena);
		// TODO Auto-generated constructor stub
	}

	public double calculoComision(Ticket ticket) {
    	double aux=0;
    	switch (super.rubro) {
	    	case "salud":aux = 0.6; break;
	    	case "comercio local" :aux = 0.7;break;
	    	case "comercio internacional":aux=0.8;break;
    	}
    	return (ticket.getFormularioDeBusqueda().getRemuneracion()*aux);
    }
}
