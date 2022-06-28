package modelo.tickets.Estados;

import modelo.excepciones.EstadoException;
import modelo.tickets.Ticket;

public class ActivadoIStateTickets implements IStateTickets {
    private Ticket t;

    public ActivadoIStateTickets(Ticket t){
        this.t=t;
    }

    @Override
    public void activar ()throws EstadoException {
        throw new EstadoException("ERROR. Mismo Estado");
    }

    @Override
    public void suspender(){
        System.out.println("Se suspendio el activado");
        this.t.setState(new SuspendidoIStateTickets(this.t));
    }

    @Override
    public void cancelar(){
        this.t.setState(new CanceladoIStateTickets(this.t));
    }

    @Override
    public void finalizar(){
        this.t.setState(new FinalizadoIStateTickets(this.t));
    }

	@Override
	public String getNombreEstado() {
		return "Activo";
		
	}
}
