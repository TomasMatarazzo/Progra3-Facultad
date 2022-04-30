package modelo.Tickets.Locaciones;

public class LocacionIndistinto implements ILocacion {
    @Override
    public int puntajeLocacion(ILocacion locacion) {
        return locacion.puntajeIndistinto();
    }

    @Override
    public int puntajeHomeOffice() {
        return 1;
    }

    @Override
    public int puntajeIndistinto() {
        return 1;
    }

    @Override
    public int puntajePresencial() {
        return -1;
    }
}
