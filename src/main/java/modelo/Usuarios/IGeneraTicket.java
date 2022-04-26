package modelo.Usuarios;

import modelo.Tickets.Ticket;

public interface IGeneraTicket {

	double calculoComision(Ticket ticket);
	int getPuntaje();
	void setPuntaje(int i);
	int getIdUsuario();
}
