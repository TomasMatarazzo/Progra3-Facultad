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
		this.vista.setControlador(this);
		vista.llenarDatosEmpleador(modelo.getRazonSocial(),modelo.getNombre(),modelo.getRubro(),modelo.getNombreUsuario());
		vista.renderListaTickets(modelo.getTicketsDeBusquedaDeEmpleado());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("iniciarTICKETS")) {
			vista.cambiarPagina(1);
		}else if (e.getActionCommand().equals("iniciarPERFIL")) {
			vista.cambiarPagina(0);
		}else if (e.getActionCommand().equals("iniciarELECCIONES")) {
			vista.cambiarPagina(2);
			vista.renderListaElecciones(Sistema.getInstance().getListas().get(modelo.getTicketsDeBusquedaDeEmpleado().get(0)).getOfertas());
			//vista.renderListaElecciones();
		}else if (e.getActionCommand().equals("CONTRATOS")){
			vista.cambiarPagina(3);
		}else if (e.getActionCommand().equals("CERRARSESION")){
			vista.lanzarVentanaEmergente("a");
		}
		else if (e.getActionCommand().equals("AGREGARTICKET")) {
			if ( modelo.getTicketsDeBusquedaDeEmpleado() != null || modelo.getTicketsDeBusquedaDeEmpleado().size() != 0) {
//				Sistema.getInstance().agregaTicketDeEmpleadores(modelo, vista.getTicketSeleccionado());
//				modelo.setTicketDeBusquedaDeEmpleo(vista.getTicketSeleccionado());
				vista.mostrarFormTicket();
			}else {
				System.out.println("AGREGANDOO " +modelo.getTicketsDeBusquedaDeEmpleado());
				System.out.println("AGREGANDOO" +modelo.getTicketsDeBusquedaDeEmpleado().size());
				vista.lanzarVentanaEmergente("Ya creo un ticket.");
			}
		}else if (e.getActionCommand().equals("ELIMINARTICKET")) {
			// VERIFICA QUE SE HAYA SELECCIONADO UN TICKET
			if (vista.getTicketSeleccionado() != null) {
				Sistema.getInstance().eliminaTicketDeEmpleadores(modelo,vista.getTicketSeleccionado() );
//				Sistema.getInstance().eliminaTicketDeEmpleadosPretensos(vista.getTicketSeleccionado());
				modelo.eliminarTicket(vista.getTicketSeleccionado());
				vista.lanzarVentanaEmergente("Se elimino el ticket.");
				System.out.println(modelo.getTicketsDeBusquedaDeEmpleado());
				vista.renderListaTickets(modelo.getTicketsDeBusquedaDeEmpleado());
			}
			else 
				vista.lanzarVentanaEmergente("Seleccione el ticket a eliminar.");
			
		}else if (e.getActionCommand().equals("EMPLEADORELEGIDO")) {
			if (vista.getTicketEleccionesSeleccionado() != null) {
				vista.lanzarVentanaEmergente("Se elegio un empleado.");
				vista.confirmarSeleccion();
//				Sistema.getInstance().getEmpleadosPretensos().get(0).getTicketDeBusquedaDeEmpleo().setEleccion(sistema.getEmpleadores().get(1).getTicketsDeBusquedaDeEmpleado().get(0));
			}
			else
				vista.lanzarVentanaEmergente("Seleccion un ticket de la ronda de elecciones.");
		}else if (e.getActionCommand().equals("CREARTICKET")) {
			vista.getForm().obtenerDatos();
			if (vista.getForm().renumeracion.equals("") ){
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Complete todos los campos");
			} else if (!Util.esNumero(vista.getForm().renumeracion) ){
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Renumeracion tiene que ser un numero");
			}else {
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Se creo el ticket");
		        vista.ocultarFormTicket();
		        LocacionFactory locacion = new LocacionFactory();
		        ILocacion locacionFac = locacion.getLocacion("indistinto");
		        Formulario_de_Busqueda formulario = new Formulario_de_Busqueda(locacionFac,Integer.parseInt(vista.getForm().renumeracion),vista.getForm().cargaHoraria,vista.getForm().tipoPuesto,vista.getForm().edad,vista.getForm().experiencia,vista.getForm().estudios);
				try {
					modelo.creaTicket(formulario, "Bombero", modelo.getPesoPuntajes());
					System.out.println("se creo un ticket");
				}
		        catch(Exception exc) {
		        	exc.getMessage();
		        }
		        vista.renderListaTickets(modelo.getTicketsDeBusquedaDeEmpleado());
		        vista.getForm().cleanForms();
			}
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
