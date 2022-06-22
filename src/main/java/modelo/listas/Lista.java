package modelo.listas;

import modelo.tickets.Ticket;

import java.io.Serializable;
import java.util.Calendar;
import java.util.TreeSet;

public class Lista implements Serializable { //COLECCION
    private TreeSet<Ticket> ofertas = new TreeSet<>();
    private Calendar fechaDeCreacion = Calendar.getInstance();

    //GETTERS && SETTERS
    public TreeSet<Ticket> getOfertas() {
        return ofertas;
    }

    public void setEmpleadoresPosibles(TreeSet<Ticket> ofertas) {
        this.ofertas = ofertas;
    }

     //TO STRING
    @Override
    public String toString() {
        return  "    " + ofertas +
                "   fechaDeCreacion:" + fechaDeCreacion.getTime() + "\n";
    }
}
