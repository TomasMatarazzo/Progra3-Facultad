package modelo.tickets.Estados;

import modelo.excepciones.EstadoException;

public interface IStateTickets {
    void activar() throws EstadoException;
    void suspender() throws EstadoException;
    void cancelar() throws EstadoException;
    void finalizar() throws EstadoException;
}
