package modelo.listas;

import modelo.Usuarios.Usuario;
import java.util.TreeSet;

public abstract class Listas {
	
	private int IDTicket;
    private TreeSet<Usuario> candidatos = new TreeSet<Usuario>(); //Coleccion
    private int eleccion; //Corresponde al ID del ticket
	
    public int getIDTicket() {
		return IDTicket;
	}
	public void setIDTicket(int iDTicket) {
		IDTicket = iDTicket;
	}
	public int getEleccion() {
		return eleccion;
	}
	public void setEleccion(int eleccion) {
		this.eleccion = eleccion;
	}

}
