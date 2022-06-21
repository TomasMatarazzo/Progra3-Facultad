package vista;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public interface IVista {

    void setActionListener(ActionListener controlador);

    void setKeyListener(KeyListener controlador);

    void ejecutar();

    void ocultar();

    void creaOtraVentana(String ventana);

    void lanzarVentanaEmergente(String mensaje);
}
