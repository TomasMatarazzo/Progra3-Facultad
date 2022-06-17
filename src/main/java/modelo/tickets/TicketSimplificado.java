package modelo.tickets;

import modelo.Sistema;
import modelo.usuarios.Agencia;
import modelo.usuarios.empleadores.Empleador;

public class TicketSimplificado extends Ticket{
    private Empleador empleador;

    public TicketSimplificado(Formulario_de_Busqueda formularioDeBusqueda, String tipoDeTrabajo, Empleador empleador, Agencia agencia) {
        super(formularioDeBusqueda, tipoDeTrabajo);
        this.empleador=empleador;
        Sistema.getInstance().getAgencia().agregarABolsaDeTrabajo(this);
    }

    public Empleador getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Empleador empleador) {
        this.empleador = empleador;
    }
}
