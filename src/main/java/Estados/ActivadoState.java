package Estados;

import excepciones.EstadoException;
import interfaces.State;
import modelo.tickets.Ticket;

public class ActivadoState implements State {
    private Ticket t;

    public ActivadoState(Ticket t){
        this.t=t;
    }

    @Override
    public void activar ()throws EstadoException {
        throw new EstadoException("ERROR. Mismo Estado");
    }

    @Override
    public void suspender(){
        System.out.println("Se suspendio el activado");
        this.t.setState(new SuspendidoState(this.t));
    }

    @Override
    public void cancelar(){
        this.t.setState(new CanceladoState(this.t));
    }

    @Override
    public void finalizar(){
        this.t.setState(new FinalizadoState(this.t));
    }
}
