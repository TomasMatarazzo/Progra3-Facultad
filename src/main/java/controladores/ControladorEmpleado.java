package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Sistema;
import modelo.excepciones.EstadoException;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.tickets.locaciones.ILocacion;
import modelo.tickets.locaciones.LocacionFactory;
import modelo.usuarios.EmpleadoPretenso;
import persistencia.*;
import util.UtilSimulacion;
import vista.VentanaEmpleado;

public class ControladorEmpleado implements ActionListener, WindowListener {
	private VentanaEmpleado vista;
	private EmpleadoPretenso modelo;

	public ControladorEmpleado(VentanaEmpleado vista, EmpleadoPretenso modelo) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setActionListener(this);
		this.vista.setWindowListener(this);
		this.vista.llenarDatosEmpleado(modelo.getNombre(),modelo.getApellido(),modelo.geteMail(),modelo.getTelefono(),modelo.getEdad());
		this.vista.renderListaTicketsEmpleado(this.modelo.getTicketDeBusquedaDeEmpleo());
		if (modelo.getTicketDeBusquedaDeEmpleo() != null) {
			this.vista.renderListaElecciones(Sistema.getInstance().getListas().get(this.modelo.getTicketDeBusquedaDeEmpleo()).getOfertas());
		}
		this.vista.renderListaContratos(Sistema.getInstance().getContratos(),modelo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
			case "iniciarTICKETS":
				vista.cambiarPagina(1);
				break;
			case "iniciarPERFIL":
				vista.cambiarPagina(0);
				break;
			case "iniciarELECCIONES":
				vista.cambiarPagina(2);
				break;
			case "AGREGARTICKET":
				if (modelo.getTicketDeBusquedaDeEmpleo() == null) {
					vista.mostrarFormTicket();
				} else
					vista.lanzarVentanaEmergente("Ya creo un ticket.");
				break;
			case "ELIMINARTICKET":
				if (vista.getTicketSeleccionado() != null) {
					Sistema.getInstance().eliminaTicketDeEmpleadosPretensos((Ticket_de_Busqueda_de_Empleo) vista.getTicketSeleccionado());
					modelo.setTicketDeBusquedaDeEmpleo(null);
					vista.lanzarVentanaEmergente("Se elimino el ticket.");
					vista.limpiaLista(vista.getList_1());
				} else
					vista.lanzarVentanaEmergente("Seleccione el ticket a eliminar.");
				break;
			case "EMPLEADORELEGIDO":
				if (vista.getTicketEleccionesSeleccionado() != null) {
					vista.confirmarSeleccion();
					vista.lanzarVentanaEmergente("Se elegio un empleado.");
					modelo.getTicketDeBusquedaDeEmpleo().setEleccion((Ticket_de_Busqueda_de_Empleado) vista.getTicketEleccionesSeleccionado());
				} else
					vista.lanzarVentanaEmergente("Seleccion un ticket de la ronda de elecciones.");
				break;
			case "CREARTICKET":
				vista.getForm().obtenerDatos();
				if (vista.getForm().renumeracion.equals("")) {
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, "Complete todos los campos");
				} else
					if (!UtilSimulacion.esNumero(vista.getForm().renumeracion)) {
						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame, "Renumeracion tiene que ser un numero");
					} else {
						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame, "Se creo el ticket");
						LocacionFactory locacion = new LocacionFactory();
						ILocacion locacionFac = locacion.getLocacion(vista.getForm().locacion);
						Formulario_de_Busqueda formulario = new Formulario_de_Busqueda(locacionFac, Integer.parseInt(vista.getForm().renumeracion), vista.getForm().cargaHoraria, vista.getForm().tipoPuesto, vista.getForm().edad, vista.getForm().experiencia, vista.getForm().estudios);
						try {
							modelo.creaTicket(formulario, "Recursos humanos");
						} catch (Exception e2) {
							vista.lanzarVentanaEmergente(e2.getMessage());
						}
						vista.renderListaTicketsEmpleado(modelo.getTicketDeBusquedaDeEmpleo());
						vista.getForm().cleanForms();
						vista.getForm().dispose();
					}
				break;
			case "SUSPENDERTICKET":
				if (vista.getTicketSeleccionado() != null) {
					if (vista.getTicketSeleccionado().getState().getNombreEstado().equalsIgnoreCase("suspendido"))
						this.vista.lanzarVentanaEmergente("El ticket ya se encuentra suspendido");
					else {
						try {
							this.vista.getTicketSeleccionado().suspender();
							this.vista.renderListaTicketsEmpleado(modelo.getTicketDeBusquedaDeEmpleo());
						} catch (EstadoException e1) {
							e1.printStackTrace();
						}
					}
				} else
					this.vista.lanzarVentanaEmergente("Seleccione el ticket a suspender");
				break;
			case "ACTIVARTICKET":
				if (vista.getTicketSeleccionado() != null) {
					if (vista.getTicketSeleccionado().getState().getNombreEstado().equalsIgnoreCase("Activo"))
						this.vista.lanzarVentanaEmergente("El ticket ya se encuentra activado");
					else {
						try {
							this.vista.getTicketSeleccionado().activar();
							this.vista.renderListaTicketsEmpleado(modelo.getTicketDeBusquedaDeEmpleo());
						} catch (EstadoException e1) {
							e1.printStackTrace();
						}
					}
				} else
					this.vista.lanzarVentanaEmergente("Seleccione el ticket a activar");
				break;
			case "CERRARSESION":
				vista.creaOtraVentana("Login");
				vista.cerrarVentana();
				JOptionPane.showMessageDialog(null, "Te has deslogueado con exito");
				break;
			case "BAJA":
				Sistema.getInstance().eliminaEmpleado(modelo);
				this.modelo = null;
				vista.creaOtraVentana("Login");
				vista.cerrarVentana();
				JOptionPane.showMessageDialog(null, "Se ha eliminado el empleado con exito!");
				break;
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

		try {
			IPersistencia binPuntajes = new PersistenciaBIN();
			binPuntajes.abrirOutput("Puntajes.bin");
			PuntajesDTO puntajesDTO = Util.puntajesDTOFromPuntajes();
			binPuntajes.escribir(puntajesDTO);
			binPuntajes.cerrarOutput();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	//METODOS NO USADOS
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
