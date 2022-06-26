package modelo.tickets.Estados;

import modelo.excepciones.EstadoException;

import java.io.Serializable;

public interface IStateTickets extends Serializable {
    void activar() throws EstadoException;
    void suspender() throws EstadoException;
    void cancelar() throws EstadoException;
    void finalizar() throws EstadoException;
    String getNombreEstado() ;
}
