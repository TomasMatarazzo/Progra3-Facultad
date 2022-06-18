package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaEmpleado;

public class ControladorEmpleados implements ActionListener {
	
	private VentanaEmpleado vista;

	public ControladorEmpleados(VentanaEmpleado vista) {
		this.vista = vista;
		this.vista.setControlador(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("iniciarTICKETS")) {
			vista.cambiarPagina(1);
		}else if (e.getActionCommand().equals("iniciarPERFIL")) {
			vista.cambiarPagina(0);
		}else if (e.getActionCommand().equals("iniciarELECCIONES")) {
			vista.cambiarPagina(2);
		}
		
	}

}
