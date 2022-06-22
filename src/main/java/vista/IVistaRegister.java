package vista;

import java.awt.event.KeyListener;

public interface IVistaRegister extends IVista {
    void setKeyListener(KeyListener controlador);

    void muestraOpcionEmpleado();

    void muestraOpcionEmpleador();
}
