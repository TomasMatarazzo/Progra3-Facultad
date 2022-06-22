package simulacion;

import modelo.Sistema;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.Ticket;
import modelo.usuarios.Agencia;
import modelo.usuarios.empleadores.Empleador;

public class TicketSimplificado extends Ticket{
	
    private Empleador empleador;
    private String estado;

    public TicketSimplificado(BolsaDeTrabajo bolsa,Formulario_de_Busqueda formularioDeBusqueda, String tipoDeTrabajo, Empleador empleador, Agencia agencia) {
        super(formularioDeBusqueda, tipoDeTrabajo);
        this.empleador=empleador;
        this.estado = "Activo";
        bolsa.agregarABolsaDeTrabajo(this);
    }

    public TicketSimplificado(Formulario_de_Busqueda formularioDeBusqueda, String tipoDeTrabajo) {
        super(formularioDeBusqueda,tipoDeTrabajo);
    }

    public Empleador getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Empleador empleador) {
        this.empleador = empleador;
    }

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
}
