package modelo.Usuarios;

public class Contrato {
	
	private int IdEmpleado;
	private int IdEmpleador;
	
	public Contrato(int idEmpleado, int idEmpleador) {
		super();
		IdEmpleado = idEmpleado;
		IdEmpleador = idEmpleador;
	}
	
	public int getIdEmpleado() {
		return IdEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		IdEmpleado = idEmpleado;
	}
	public int getIdEmpleador() {
		return IdEmpleador;
	}
	public void setIdEmpleador(int idEmpleador) {
		IdEmpleador = idEmpleador;
	}
	
	public String toString () {
		return "Contrato "+this.IdEmpleado+" y "+this.IdEmpleador;
	}

	
}
