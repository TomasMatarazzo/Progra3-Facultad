package modelo.tickets.locaciones;

import java.io.Serializable;

public interface ILocacion extends Serializable {

    int puntajeLocacion( ILocacion locacion);

    int puntajeHomeOffice();

    int puntajeIndistinto();

    int puntajePresencial();
}
