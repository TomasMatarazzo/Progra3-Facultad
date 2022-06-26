package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Sistema;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.tickets.locaciones.ILocacion;
import modelo.tickets.locaciones.LocacionFactory;
import modelo.usuarios.EmpleadoPretenso;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import util.Util;
import vista.IVistaUsuarioComun;
import vista.VentanaEmpleado;

public class ControladorEmpleados implements ActionListener, WindowListener {
	private IVistaUsuarioComun vista;
	private EmpleadoPretenso modelo;

	public ControladorEmpleados(VentanaEmpleado vista2, EmpleadoPretenso modelo) {
		this.modelo = modelo;
		this.vista = vista2;
		this.vista.setActionListener(this);
		vista.llenarDatosEmpleado(modelo.getNombre(), modelo.getApellido(), modelo.geteMail(), modelo.getTelefono(),
				modelo.getEdad());
		vista.renderListaTicketsEmpleado((Ticket_de_Busqueda_de_Empleo) modelo.getTicketDeBusquedaDeEmpleo());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("iniciarTICKETS")) {
			vista.cambiarPagina(1);
		} else if (e.getActionCommand().equals("iniciarPERFIL")) {
			vista.cambiarPagina(0);
		} else if (e.getActionCommand().equals("iniciarELECCIONES")) {
			vista.cambiarPagina(2);
		} else if (e.getActionCommand().equals("AGREGARTICKET")) {
			if (modelo.getTicketDeBusquedaDeEmpleo() == null) {
//				Sistema.getInstance().agregaTicketDeEmpleadosPretensos(modelo, vista.getTicketSeleccionado());
//				modelo.setTicketDeBusquedaDeEmpleo(vista.getTicketSeleccionado());
				vista.mostrarFormTicket();
			} else
				vista.lanzarVentanaEmergente("Ya creo un ticket.");

		} else if (e.getActionCommand().equals("ELIMINARTICKET")) {
			// VERIFICA QUE SE HAYA SELECCIONADO UN TICKET
			if (vista.getTicketSeleccionado() != null) {
				Sistema.getInstance().eliminaTicketDeEmpleadosPretensos(
						(Ticket_de_Busqueda_de_Empleo) vista.getTicketSeleccionado());
				modelo.setTicketDeBusquedaDeEmpleo(null);
				vista.lanzarVentanaEmergente("Se elimino el ticket.");
				System.out.println(modelo.getTicketDeBusquedaDeEmpleo());
				vista.renderListaTicketsEmpleado(modelo.getTicketDeBusquedaDeEmpleo());
			} else
				vista.lanzarVentanaEmergente("Seleccione el ticket a eliminar.");

		} else if (e.getActionCommand().equals("EMPLEADORELEGIDO")) {
			if (vista.getTicketEleccionesSeleccionado() != null) {
				vista.confirmarSeleccion();
				vista.lanzarVentanaEmergente("Se elegio un empleado.");
				modelo.getTicketDeBusquedaDeEmpleo()
						.setEleccion((Ticket_de_Busqueda_de_Empleado) vista.getTicketEleccionesSeleccionado());
			} else
				vista.lanzarVentanaEmergente("Seleccion un ticket de la ronda de elecciones.");
		} else if (e.getActionCommand().equals("CREARTICKET")) {
			vista.getForm().obtenerDatos();
			if (vista.getForm().renumeracion.equals("")) {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "Complete todos los campos");
			} else if (!Util.esNumero(vista.getForm().renumeracion)) {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "Renumeracion tiene que ser un numero");
			} else {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "Se creo el ticket");
				LocacionFactory locacion = new LocacionFactory();
				ILocacion locacionFac = locacion.getLocacion("indistinto");
				Formulario_de_Busqueda formulario = new Formulario_de_Busqueda(locacionFac,
						Integer.parseInt(vista.getForm().renumeracion), vista.getForm().cargaHoraria,
						vista.getForm().tipoPuesto, vista.getForm().edad, vista.getForm().experiencia,
						vista.getForm().estudios);
				try {
					modelo.creaTicket(formulario, "Bombero");
					System.out.println(modelo.getTicketDeBusquedaDeEmpleo());
				} catch (Exception exc) {
					exc.getMessage();
				}
				vista.renderListaTicketsEmpleado(modelo.getTicketDeBusquedaDeEmpleo());
				vista.getForm().cleanForms();
			}
		} else if (e.getActionCommand().equalsIgnoreCase("CERRARSESION")) {
			vista.creaOtraVentana("Login");
			vista.cerrarVentana();
			JOptionPane.showMessageDialog(null, "Te has deslogueado con exito");
		} else if (e.getActionCommand().equalsIgnoreCase("BAJA")) {
			vista.creaOtraVentana("Login");
			Sistema.getInstance().setAgencia(null);
			vista.cerrarVentana();
			JOptionPane.showMessageDialog(null, "Se ha eliminado la Agencia con exito!");
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			IPersistencia bin = new PersistenciaBIN();
			bin.abrirOutput("Sistema.bin");
			SistemaDTO sistemaDTO = Util.sistemaDTOFromSistema(Sistema.getInstance());
			bin.escribir(sistemaDTO);
			bin.cerrarOutput();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}
}
