package modelo.Tickets.Locaciones;

public interface Locacion {
    int puntajeLocacion( Locacion locacion);
    int puntajeHomeOffice();
    int puntajeIndistinto();
    int puntajePresencial();
}
