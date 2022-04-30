package modelo.Tickets.Locaciones;

public interface ILocacion {
    int puntajeLocacion( ILocacion locacion);
    int puntajeHomeOffice();
    int puntajeIndistinto();
    int puntajePresencial();
}
