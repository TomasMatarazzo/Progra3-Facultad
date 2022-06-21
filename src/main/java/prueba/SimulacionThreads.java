package prueba;

import modelo.excepciones.DatosMalIngresadosException;
import modelo.excepciones.ErrorDeUsuarioException;
import modelo.excepciones.EstadoException;
import modelo.excepciones.TicketYaCreadoException;
import modelo.tickets.locaciones.ILocacion;
import controladores.ControladorThreads;
import modelo.Sistema;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.locaciones.LocacionFactory;
import modelo.usuarios.UsuarioFactory;
import vista.VentanaSimulacionThreads;

public class SimulacionThreads {

	public static void main(String[] args) throws EstadoException {
        Sistema sistema = Sistema.getInstance();
        UsuarioFactory usuarioFactory = new UsuarioFactory();

        try {
            usuarioFactory.creaUsuario("Guillermo","Guille<3","Agencia");
            
            //--------------------------------------------------------------------------------------
            usuarioFactory.creaUsuario("Empleado01","111","Empleado Pretenso");
            usuarioFactory.creaUsuario("Empleado02","222","Empleado Pretenso");
            usuarioFactory.creaUsuario("Empleado03","333","Empleado Pretenso");
            usuarioFactory.creaUsuario("Empleado04","444","Empleado Pretenso");
            usuarioFactory.creaUsuario("Empleado05","555","Empleado Pretenso");
            usuarioFactory.creaUsuario("EmpleadorJuridico1","666","Persona Juridica");
            usuarioFactory.creaUsuario("EmpleadorFisico1","777","Persona Fisica");
            usuarioFactory.creaUsuario("EmpleadorJuridico2","888","Persona Juridica");
            usuarioFactory.creaUsuario("EmpleadorFisico2","999","Persona Fisica");
            usuarioFactory.creaUsuario("EmpleadorFisico3","101010","Persona Fisica");
        } catch (DatosMalIngresadosException e1) {
            System.out.println("El parametro " + e1.getMessage() + " ingresado es incorrecto.");
        } catch (ErrorDeUsuarioException e2) {
       
        }
       
        sistema.getAgencia().agregarTipoDeTrabajo("Camarero");
        sistema.getAgencia().agregarTipoDeTrabajo("Bombero");
/*        sistema.getAgencia().confeccionarRangoEtario(40,50);
        sistema.getAgencia().confeccionarTipoDePuesto("JR","SR","MANAGMENT");*/

        LocacionFactory lc = new LocacionFactory();

        ILocacion home = lc.getLocacion("HOMEOFFICE");
        ILocacion presencial = lc.getLocacion("PRESENCIAL");
        ILocacion indistinto = lc.getLocacion("INDISTINTO");

        Formulario_de_Busqueda fbt1 = new Formulario_de_Busqueda(indistinto,90000,0,0,0,2,2);
        Formulario_de_Busqueda fbt2 = new Formulario_de_Busqueda(presencial,10000,1,0,1,1,0);
        Formulario_de_Busqueda fbt3 = new Formulario_de_Busqueda(presencial,15000,2,2,1,0,1);
        Formulario_de_Busqueda fbt4 = new Formulario_de_Busqueda(indistinto,12000,2,1,2,0,2);
        Formulario_de_Busqueda fbt5 = new Formulario_de_Busqueda(home,20000,0,1,2,1,2);

        try {
            sistema.getEmpleadosPretensos().get(0).creaTicket(fbt1, "Bombero");
            sistema.getEmpleadosPretensos().get(1).creaTicket(fbt2, "Camarero");
            sistema.getEmpleadosPretensos().get(2).creaTicket(fbt3, "Camarero");
            sistema.getEmpleadosPretensos().get(3).creaTicket(fbt4, "Bombero");
            sistema.getEmpleadosPretensos().get(4).creaTicket(fbt5, "Camarero");
        } catch (TicketYaCreadoException e) {
            System.out.println(e.getMessage());
        }
 
        VentanaSimulacionThreads frame = new VentanaSimulacionThreads();
        
        ControladorThreads controlThread = new ControladorThreads(frame);
        
        frame.setVisible(true);   
	}
}