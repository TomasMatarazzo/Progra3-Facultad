package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vistas.vistaEmpleado;

public class controladorEmpleados implements ActionListener {
	
	private vistaEmpleado vista;

	public controladorEmpleados(vistaEmpleado vista) {
		super();
		this.vista = vista;
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
