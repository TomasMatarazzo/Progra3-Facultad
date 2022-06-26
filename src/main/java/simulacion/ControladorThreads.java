package simulacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import modelo.Sistema;
import vista.IVista;
import javax.swing.*;

public class ControladorThreads implements ActionListener, WindowListener {
	private IVista vista;
	private ArrayList<Thread> threads = new ArrayList<>();
	
	public ControladorThreads(IVista vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
	}

	public ArrayList<Thread> getThreads() {
		return threads;
	}

	public void agregarThread(Thread t){
        this.threads.add(t);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread q;
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("Comenzar")) {
			for (int t = 0;t < 5;t++) {
				q = new Thread(Sistema.getInstance().getEmpleadores().get(t));
				this.agregarThread(q);
				q.start();
			}
			for (int t = 0;t < 5;t++) {
				q = new Thread(Sistema.getInstance().getEmpleadosPretensos().get(t));
				this.agregarThread(q);
				q.start();
			}
		} else
			if (comando.equalsIgnoreCase("Volver")) {
				for (int t = 0;t < this.threads.size();t++) {
					this.threads.get(t).interrupt();
				}
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
