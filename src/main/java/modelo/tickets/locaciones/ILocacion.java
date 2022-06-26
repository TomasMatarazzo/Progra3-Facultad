package modelo.tickets.locaciones;

public interface ILocacion {

    int puntajeLocacion( ILocacion locacion);

    int puntajeHomeOffice();

    int puntajeIndistinto();

    int puntajePresencial();
}
