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
import modelo.usuarios.empleadores.Empleador;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import util.Util;
import vista.VentanaEmpleador;

public class ControladorEmpleador implements ActionListener, WindowListener{
	private VentanaEmpleador vista;
	private Empleador modelo;

	public ControladorEmpleador(VentanaEmpleador vista2, Empleador modelo) {
		this.modelo = modelo;
		this.vista = vista2;
		this.vista.setActionListener(this);
		vista.llenarDatosEmpleador(modelo.getRazonSocial(),"caca",modelo.getRubro(),modelo.getNombreUsuario());
		vista.renderListaTickets(modelo.getTicketsDeBusquedaDeEmpleado());
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
				vista.renderVentanaVistas(3,Sistema.getInstance().getListas().get(modelo.getTicketsDeBusquedaDeEmpleado().get(0)).getOfertas());
				//vista.renderListaElecciones(Sistema.getInstance().getListas().get(modelo.getTicketsDeBusquedaDeEmpleado().get(0)).getOfertas());
				//vista.renderListaElecciones();
				break;
			case "CONTRATOS":
				vista.cambiarPagina(3);
				break;
			case "AGREGARTICKET":
				if ( modelo.getTicketsDeBusquedaDeEmpleado() != null || modelo.getTicketsDeBusquedaDeEmpleado().size() != 0) {
//				Sistema.getInstance().agregaTicketDeEmpleadores(modelo, vista.getTicketSeleccionado());
//				modelo.setTicketDeBusquedaDeEmpleo(vista.getTicketSeleccionado());
					vista.mostrarFormTicket();
				}else {
					System.out.println("AGREGANDOO " +modelo.getTicketsDeBusquedaDeEmpleado());
					System.out.println("AGREGANDOO" +modelo.getTicketsDeBusquedaDeEmpleado().size());
					vista.lanzarVentanaEmergente("Ya creo un ticket");
				}
				break;
			case "ELIMINARTICKET":
				if (vista.getTicketSeleccionado() != null) {
					Sistema.getInstance().eliminaTicketDeEmpleadores(modelo,(Ticket_de_Busqueda_de_Empleado)vista.getTicketSeleccionado() );
//				Sistema.getInstance().eliminaTicketDeEmpleadosPretensos(vista.getTicketSeleccionado());
					modelo.eliminarTicket((Ticket_de_Busqueda_de_Empleado)vista.getTicketSeleccionado());
					vista.lanzarVentanaEmergente("Se elimino el ticket.");
					System.out.println(modelo.getTicketsDeBusquedaDeEmpleado());
					vista.renderListaTickets(modelo.getTicketsDeBusquedaDeEmpleado());
				}
				else
					vista.lanzarVentanaEmergente("Seleccione el ticket a eliminar.");
				break;
			case "EMPLEADORELEGIDO":
				if (vista.getTicketEleccionesSeleccionado() != null ) {
					vista.lanzarVentanaEmergente("Se elegio un empleado.");
					vista.confirmarSeleccion();
					modelo.getTicketsDeBusquedaDeEmpleado().get(vista.getTabSeleccionado()).setEleccion( (Ticket_de_Busqueda_de_Empleo)vista.getTicketEleccionesSeleccionado());
				} else
					vista.lanzarVentanaEmergente("Seleccion un ticket de la ronda de elecciones.");
				break;
			case "CREARTICKET":
				vista.getForm().obtenerDatos();
				if (vista.getForm().renumeracion.equals("") ){
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, "Complete todos los campos");
				} else {
					if (!Util.esNumero(vista.getForm().renumeracion)) {
						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame, "Renumeracion tiene que ser un numero");
					} else {
						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame, "Se creo el ticket");
						vista.ocultarFormTicket();
						LocacionFactory locacion = new LocacionFactory();
						ILocacion locacionFac = locacion.getLocacion("indistinto");
						Formulario_de_Busqueda formulario = new Formulario_de_Busqueda(locacionFac, Integer.parseInt(vista.getForm().renumeracion), vista.getForm().cargaHoraria, vista.getForm().tipoPuesto, vista.getForm().edad, vista.getForm().experiencia, vista.getForm().estudios);
						modelo.creaTicket(formulario, "Bombero", modelo.getPesoPuntajes());
						vista.renderListaTickets(modelo.getTicketsDeBusquedaDeEmpleado());
						vista.getForm().cleanForms();
					}
				}
				break;
			case "SUSPENDERTICKET":
				if (vista.getTicketSeleccionado() != null) {
					if (vista.getTicketSeleccionado().getEstado().equalsIgnoreCase("suspender"))
						this.vista.lanzarVentanaEmergente("El ticket ya se encuentra suspendido");
					else {
						try {
							this.vista.getTicketSeleccionado().suspender();
							this.vista.renderListaElecciones(null);
						} catch (EstadoException e1) {
							e1.printStackTrace();
						}
					}
				} else
					this.vista.lanzarVentanaEmergente("Seleccione el ticket a suspender");
				break;
			case "CERRARSESION":
				vista.creaOtraVentana("Login");
				vista.cerrarVentana();
				JOptionPane.showMessageDialog(null, "Te has deslogueado con exito");
				break;
			case "BAJA":
				Sistema.getInstance().eliminaEmpleador(modelo);
				this.modelo = null;
				vista.creaOtraVentana("Login");
				vista.cerrarVentana();
				JOptionPane.showMessageDialog(null, "Se ha eliminado el Empleador con exito!");
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
	}

	//METODOS QUE NO SE USAN
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
