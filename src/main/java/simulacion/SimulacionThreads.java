package simulacion;

import modelo.excepciones.DatosMalIngresadosException;
import modelo.excepciones.ErrorDeUsuarioException;
import modelo.excepciones.EstadoException;
import modelo.excepciones.TicketYaCreadoException;
import modelo.tickets.locaciones.ILocacion;
import modelo.Sistema;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.locaciones.LocacionFactory;
import modelo.usuarios.UsuarioFactory;

public class SimulacionThreads {
	public static void main() throws EstadoException {
        Sistema sistema = Sistema.getInstance();
        UsuarioFactory usuarioFactory = new UsuarioFactory();

        try {
            usuarioFactory.creaUsuario("Empleado01","111","Empleado");
            usuarioFactory.creaUsuario("Empleado02","222","Empleado");
            usuarioFactory.creaUsuario("Empleado03","333","Empleado");
            usuarioFactory.creaUsuario("Empleado04","444","Empleado");
            usuarioFactory.creaUsuario("Empleado05","555","Empleado");
            usuarioFactory.creaUsuario("EMPLEADOR1","666","Persona Juridica");
            usuarioFactory.creaUsuario("EMPLEADOR2","777","Persona Fisica");
            usuarioFactory.creaUsuario("EMPLEADOR3","888","Persona Juridica");
            usuarioFactory.creaUsuario("EMPLEADOR4","999","Persona Fisica");
            usuarioFactory.creaUsuario("EMPLEADOR5","101010","Persona Fisica");
        } catch (DatosMalIngresadosException e1) {
            System.out.println("El parametro " + e1.getMessage() + " ingresado es incorrecto.");
        } catch (ErrorDeUsuarioException e2) {
       
        }
       
        sistema.getAgencia().agregarTipoDeTrabajo("Camarero");
        sistema.getAgencia().agregarTipoDeTrabajo("Bombero");

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

        VentanaSimulacionThreads ventanaSimulacionThreads = new VentanaSimulacionThreads();
        ControladorThreads controladorThreads = new ControladorThreads(ventanaSimulacionThreads);
        ventanaSimulacionThreads.setVisible(true);
	}

    public static void detenerSimulacion() {

    }
}