package Estados;

import excepciones.EstadoException;
import interfaces.State;
import modelo.tickets.Ticket;

public class SuspendidoState implements State {
    private Ticket t;

    public SuspendidoState(Ticket t) {
        this.t=t;
    }
    @Override
    public void activar() {
        this.t.setState(new ActivadoState(this.t));
    }

    @Override
    public void suspender() throws EstadoException {
        throw new EstadoException("ERROR. Mismo estado");
    }

    @Override
    public void cancelar() {
        this.t.setState(new CanceladoState(this.t));
    }

    @Override
    public void finalizar() throws EstadoException {
        throw new EstadoException("Un ticket suspendido no se puede finalizar");
    }
}
