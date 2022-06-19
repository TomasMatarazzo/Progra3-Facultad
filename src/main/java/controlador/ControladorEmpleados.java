package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.usuarios.Empleado_Pretenso;
import vista.VentanaEmpleado;

public class ControladorEmpleados implements ActionListener {
	private VentanaEmpleado vista;
	private Empleado_Pretenso modelo;

	public ControladorEmpleados(VentanaEmpleado vista, Empleado_Pretenso modelo) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
		vista.llenarDatosEmpleado(modelo.getNombre(),modelo.getApellido(),modelo.geteMail(), modelo.getTelefono(),modelo.getEdad());
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("iniciarTICKETS")) {
			vista.cambiarPagina(1);
		}else if (e.getActionCommand().equals("iniciarPERFIL")) {
			vista.cambiarPagina(0);
		}else if (e.getActionCommand().equals("iniciarELECCIONES")) {
			vista.cambiarPagina(2);
		}
		
	}

}
