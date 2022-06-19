package controladores;

import vista.VentanaAgencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAgencia implements ActionListener {
    private VentanaAgencia vista;

    public ControladorAgencia(VentanaAgencia vista) {
        this.vista = vista;
        vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
