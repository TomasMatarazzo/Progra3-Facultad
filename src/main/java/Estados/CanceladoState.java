package Estados;

import excepciones.EstadoException;
import interfaces.State;
import modelo.tickets.Ticket;

public class CanceladoState implements State {
    private Ticket t;
    public CanceladoState(Ticket t){
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
}
