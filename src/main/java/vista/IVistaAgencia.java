package vista;

import javax.swing.*;

public interface IVistaAgencia extends IVista{

    void cambiarPagina(int pagina);

    void agregarDatos(String tipoTrabajo,String rangoLaboral,String tipoPuesto);

    void cargarModelo(DefaultListModel modelo, String dato);

    void limpiaModelo(DefaultListModel modelo);

    void mostrarDatos(JList lista);
}
