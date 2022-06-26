package modelo.tickets.Estados;

import modelo.excepciones.EstadoException;
import modelo.tickets.Ticket;

public class SuspendidoIStateTickets implements IStateTickets {
    private Ticket t;

    public SuspendidoIStateTickets(Ticket t) {
        this.t=t;
    }
    @Override
    public void activar() {
        this.t.setState(new ActivadoIStateTickets(this.t));
    }

    @Override
    public void suspender() throws EstadoException {
        throw new EstadoException("ERROR. Mismo estado");
    }

    @Override
    public void cancelar() {
        this.t.setState(new CanceladoIStateTickets(this.t));
    }

    @Override
    public void finalizar() throws EstadoException {
        throw new EstadoException("Un ticket suspendido no se puede finalizar");
    }
	@Override
	public String getNombreEstado() {
		return "Suspendido";
	}
}
