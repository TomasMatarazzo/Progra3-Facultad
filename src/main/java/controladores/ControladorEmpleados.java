package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Sistema;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.locaciones.ILocacion;
import modelo.tickets.locaciones.LocacionFactory;
import modelo.usuarios.Empleado_Pretenso;
import util.Util;
import vista.VentanaEmpleado;

public class ControladorEmpleados implements ActionListener {
	private VentanaEmpleado vista;
	private Empleado_Pretenso modelo;

	public ControladorEmpleados(VentanaEmpleado vista2, Empleado_Pretenso modelo) {
		this.modelo = modelo;
		this.vista = vista2;
		this.vista.setControlador(this);
		vista.llenarDatosEmpleado(modelo.getNombre(),modelo.getApellido(),modelo.geteMail(), modelo.getTelefono(),modelo.getEdad());
		vista.renderListaTickets(modelo.getTicketDeBusquedaDeEmpleo());
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("iniciarTICKETS")) {
			vista.cambiarPagina(1);
		}else if (e.getActionCommand().equals("iniciarPERFIL")) {
			vista.cambiarPagina(0);
		}else if (e.getActionCommand().equals("iniciarELECCIONES")) {
			vista.cambiarPagina(2);
		}else if (e.getActionCommand().equals("AGREGARTICKET")) {
			if (modelo.getTicketDeBusquedaDeEmpleo() == null) {
//				Sistema.getInstance().agregaTicketDeEmpleadosPretensos(modelo, vista.getTicketSeleccionado());
//				modelo.setTicketDeBusquedaDeEmpleo(vista.getTicketSeleccionado());
				vista.mostrarFormTicket();
			}else 
				vista.lanzarVentanaEmergente("Ya creo un ticket.");
			
		}else if (e.getActionCommand().equals("ELIMINARTICKET")) {
			// VERIFICA QUE SE HAYA SELECCIONADO UN TICKET
			if (vista.getTicketSeleccionado() != null) {
				Sistema.getInstance().eliminaTicketDeEmpleadosPretensos(vista.getTicketSeleccionado());
				modelo.setTicketDeBusquedaDeEmpleo(null);
				vista.lanzarVentanaEmergente("Se elimino el ticket.");
				System.out.println(modelo.getTicketDeBusquedaDeEmpleo());
				vista.renderListaTickets(modelo.getTicketDeBusquedaDeEmpleo());
			}
			else 
				vista.lanzarVentanaEmergente("Seleccione el ticket a eliminar.");
			
		}else if (e.getActionCommand().equals("EMPLEADORELEGIDO")) {
			if (vista.getTicketEleccionesSeleccionado() != null) {
				vista.confirmarSeleccion();
				vista.lanzarVentanaEmergente("Se elegio un empleado.");
			}
			else
				vista.lanzarVentanaEmergente("Seleccion un ticket de la ronda de elecciones.");
		}else if (e.getActionCommand().equals("CREARTICKET")) {
			vista.getForm().obtenerDatos();
			if (vista.getForm().renumeracion.equals("") ){
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Complete todos los campos");
			} else if (!Util.esNumero(vista.getForm().renumeracion)){
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Renumeracion tiene que ser un numero");
			}
			else{
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Se creo el ticket");
		        LocacionFactory locacion = new LocacionFactory();
		        ILocacion locacionFac = locacion.getLocacion("indistinto");
		        Formulario_de_Busqueda formulario = new Formulario_de_Busqueda(locacionFac,Integer.parseInt(vista.getForm().renumeracion),vista.getForm().cargaHoraria,vista.getForm().tipoPuesto,vista.getForm().edad,vista.getForm().experiencia,vista.getForm().estudios);
				try {
					modelo.creaTicket(formulario, "Bombero");
					System.out.println(modelo.getTicketDeBusquedaDeEmpleo());
				}
		        catch(Exception exc) {
		        	exc.getMessage();
		        }
		        vista.renderListaTickets(modelo.getTicketDeBusquedaDeEmpleo());
		        vista.getForm().cleanForms();
		}
		}
	}
}
