package simulacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.Sistema;
import vista.IVista;
import javax.swing.*;

public class ControladorThreads implements ActionListener, WindowListener {
	private IVista vista;

	public ControladorThreads(IVista vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread q;
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("Comenzar")) {
			for (int t = 0;t < Sistema.getInstance().getEmpleadores().size();t++) {
				q = new Thread(Sistema.getInstance().getEmpleadores().get(t));
				q.start();
			}
			for (int t = 0;t < Sistema.getInstance().getEmpleadosPretensos().size();t++) {
				q = new Thread(Sistema.getInstance().getEmpleadosPretensos().get(t));
				q.start();
			}
		} else
			if (comando.equalsIgnoreCase("Volver")) {
				//ACA DEBERIA DETENER TODOS LOS HILOS
				vista.creaOtraVentana("Login");
				vista.cerrarVentana();
				JOptionPane.showMessageDialog(null, "Se ha detenido la simulacion");
				
			}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		//PONGO ESTO?

/*		try {
			IPersistencia bin = new PersistenciaBIN();
			bin.abrirOutput("Sistema.bin");
			SistemaDTO sistemaDTO = Util.sistemaDTOFromSistema(Sistema.getInstance());
			bin.escribir(sistemaDTO);
			bin.cerrarOutput();
		} catch (IOException ex) {
			ex.printStackTrace();
		}*/
	}

	//METODOS NO USADOS
	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
