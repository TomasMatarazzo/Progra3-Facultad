package modelo.interfaces;

import modelo.excepciones.EstadoException;

public interface State {
    void activar() throws EstadoException;
    void suspender() throws EstadoException;
    void cancelar() throws EstadoException;
    void finalizar() throws EstadoException;
}
