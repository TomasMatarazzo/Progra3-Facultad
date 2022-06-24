package vista;

import javax.swing.*;

public interface IVistaAgencia extends IVista{

    void setKeyListener();

    String getTipoDeTrabajo();

    int getRangoLaboral();

    String getTipoDePuesto();

    int getIndiceSeleccionado();

    void cambiarPagina(int pagina);

    void cambiarTitulo(String nombreAgencia);

    void cambiarTotal(double total);

    void agregarDatos(String tipoTrabajo,String rangoLaboral,String tipoPuesto);

    void cargarModelo(DefaultListModel<String> modelo, String dato);

    void limpiaModelo(String modelo);

    void mostrarDatos(String dato);
}
