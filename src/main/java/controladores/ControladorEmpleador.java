package controladores;

import modelo.usuarios.empleadores.Empleador;
import vista.VentanaEmpleador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEmpleador implements ActionListener {
	private VentanaEmpleador vista;
	private Empleador modelo;

	public ControladorEmpleador(VentanaEmpleador vista, Empleador modelo) {
		this.vista = vista;
		this.vista.setActionListener(this);
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
