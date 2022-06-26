package modelo.tickets.Estados;

import modelo.excepciones.EstadoException;
import modelo.tickets.Ticket;

public class CanceladoIStateTickets implements IStateTickets {
    private Ticket t;
    public CanceladoIStateTickets(Ticket t){
        this.t=t;
    }

    @Override
    public void activar() throws EstadoException {
        throw new EstadoException("Un ticket cancelado no se puede activar");
    }

    @Override
    public void suspender() throws EstadoException{
        throw new EstadoException("Un ticket cancelado no se puede suspender");

    }

    @Override
    public void cancelar() throws EstadoException {
        throw new EstadoException("ERROR. Mismo Estado");
    }

    @Override
    public void finalizar() throws EstadoException {
        throw new EstadoException("Un ticket cancelado no se puede finalizar");
    }

	@Override
	public String getNombreEstado() {
		return "Cancelado";
	}
}
