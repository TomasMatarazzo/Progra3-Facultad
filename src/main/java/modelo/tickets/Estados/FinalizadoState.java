package modelo.tickets.Estados;

import modelo.excepciones.EstadoException;
import modelo.interfaces.State;
import modelo.tickets.Ticket;

public class FinalizadoState implements State {
    private Ticket t;
    public FinalizadoState(Ticket t){
        this.t= t;
    }
    @Override
    public void activar() throws EstadoException{
        throw new EstadoException("Un ticket finalizado no se puede activar");
    }

    @Override
    public void suspender() throws EstadoException {
        throw new EstadoException("Un ticket finalizado no se puede suspender");
    }

    @Override
    public void cancelar() throws EstadoException {
        throw new EstadoException("Un ticket finalizado no se puede cancelar");

    }

    @Override
    public void finalizar() throws EstadoException {
        throw new EstadoException("ERROR. Mismo estado");
    }
}
