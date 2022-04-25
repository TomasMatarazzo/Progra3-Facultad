package modelo.Tickets.Locaciones;

public class LocacionHomeOffice implements Locacion{

    @Override
    public int puntajeLocacion(Locacion locacion) {
        return locacion.puntajeHomeOffice();
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
