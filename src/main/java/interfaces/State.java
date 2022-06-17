package interfaces;

import excepciones.EstadoException;

public interface State {
    void activar() throws EstadoException;
    void suspender() throws EstadoException;
    void cancelar() throws EstadoException;
    void finalizar() throws EstadoException;
}
