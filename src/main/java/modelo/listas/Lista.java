package modelo.listas;

import modelo.tickets.Ticket;
import java.util.Calendar;
import java.util.TreeSet;

public class Lista { //Coleccion
    public TreeSet<Ticket> ofertas = new TreeSet<>();
    public Calendar fechaDeCreacion=Calendar.getInstance();

    public TreeSet<Ticket> getOfertas() {
        return ofertas;
    }

    public void setEmpleadoresPosibles(TreeSet<Ticket> ofertas) {
        this.ofertas = ofertas;
    }
}
