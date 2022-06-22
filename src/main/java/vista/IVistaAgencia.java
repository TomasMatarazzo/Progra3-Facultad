package vista;

import javax.swing.*;
import java.awt.event.KeyListener;

public interface IVistaAgencia extends IVista{

    void setKeyListener(KeyListener controlador);

    void cambiarPagina(int pagina);

    void agregarDatos(String tipoTrabajo,String rangoLaboral,String tipoPuesto);

    void cargarModelo(DefaultListModel modelo, String dato);

    void limpiaModelo(DefaultListModel modelo);

    void mostrarDatos(JList lista,DefaultListModel modelo);
}
