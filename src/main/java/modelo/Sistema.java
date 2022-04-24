package modelo;

import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.Usuarios.ListaDeContratos;
import modelo.Usuarios.Contrato;
import modelo.Usuarios.Eleccion;
import modelo.Usuarios.Usuario;
import modelo.listas.Listas;
import java.util.ArrayList;

import excepciones.EstadoInvalidoException;
import modelo.Usuarios.Eleccion;

public class Sistema {
    private static Sistema instance = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Ticket_de_Busqueda_de_Empleado> ticketsBusquedaEmpleados = new ArrayList<Ticket_de_Busqueda_de_Empleado>();
    private ArrayList<Ticket_de_Busqueda_de_Empleo> ticketsBusquedaEmpleo = new ArrayList<Ticket_de_Busqueda_de_Empleo>();
    private ArrayList<Listas> listas = new ArrayList<Listas>();

    //PATRON SINGLETON
    private Sistema() {
    }

    public static Sistema getInstance() {
        if (instance == null)
            instance = new Sistema();
        return instance;
    }

    //GETTERS & ADDERS
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    //FUNCIONALIDADES
    public void registrarUsuario(Usuario nuevo) {
        //VALIDAR REGISTRO
        usuarios.add(nuevo);
    }

    public boolean buscaUsuario(Usuario usuario) 
    {
        return false;
    }
    
    public void rondaContrataciones (Eleccion trabajadores, Eleccion empresa, ListaDeContratos listaDeContratos) throws EstadoInvalidoException {
    	int a,idEmpleado,idEmpleador;
    	for (a=0; a < trabajadores.getTabla().size();a++) {
			if (trabajadores.getTabla().get(empresa.getTabla().get(a)) == a)
			{	
				idEmpleado = IdUsuarioEmpleadoApartirDeNroTicket(a,this.ticketsBusquedaEmpleo);
				idEmpleador = IdUsuarioEmpleadorApartirDeNroTicket(a,this.ticketsBusquedaEmpleados);
				Contrato contrato = new Contrato(idEmpleado,idEmpleador);
				listaDeContratos.getContratos().add(contrato);
				this.ticketsBusquedaEmpleo.get(a).modificaTicket();
				this.ticketsBusquedaEmpleados.get(trabajadores.getTabla().get(a)).modificaTicket();
				this.usuarios.get(idEmpleador).setPuntaje(this.usuarios.get(idEmpleador).getPuntaje()+50);
				this.usuarios.get(idEmpleado).setPuntaje(this.usuarios.get(idEmpleado).getPuntaje()+10);
				this.usuarios.get(idEmpleador).calculoComision(this.ticketsBusquedaEmpleados.get(trabajadores.getTabla().get(a)));  //calculo de Comision, no se guarda en ningun lugar
				this.usuarios.get(idEmpleado).calculoComision(this.ticketsBusquedaEmpleo.get(empresa.getTabla().get(a)));			//calculo de Comision, no se guarda en ningun lugar
			}
		}
    }
    
    public int IdUsuarioEmpleadoApartirDeNroTicket (int nroTicket, ArrayList<Ticket_de_Busqueda_de_Empleo> ticketBusquedaEmpleo) {
    	int m=0;
		while (ticketBusquedaEmpleo.get(m).getIDTicket() != nroTicket)
			m++;
		return m;
    }
    public int IdUsuarioEmpleadorApartirDeNroTicket (int nroTicket, ArrayList<Ticket_de_Busqueda_de_Empleado> ticketBusquedaEmpleado) {
    	int m=0;
		while (ticketBusquedaEmpleado.get(m).getIDTicket() != nroTicket)
			m++;
		return m;
    }
    
}
