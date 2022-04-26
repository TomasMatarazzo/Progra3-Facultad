package modelo;

import modelo.Tickets.Ticket;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.Usuarios.Contrato;
import modelo.Usuarios.Eleccion;
import modelo.Usuarios.IGeneraTicket;
import modelo.Usuarios.Usuario;
import modelo.listas.Listas;
import java.util.ArrayList;

import excepciones.EstadoInvalidoException;
import modelo.Usuarios.Eleccion;

public class Sistema {
    private static Sistema instance = null;
    private ArrayList<IGeneraTicket> usuarios = new ArrayList<IGeneraTicket>();
    private ArrayList<Ticket_de_Busqueda_de_Empleado> ticketsBusquedaEmpleados = new ArrayList<Ticket_de_Busqueda_de_Empleado>();
    private ArrayList<Ticket_de_Busqueda_de_Empleo> ticketsBusquedaEmpleo = new ArrayList<Ticket_de_Busqueda_de_Empleo>();
    private ArrayList<Listas> listas = new ArrayList<Listas>();
    private ArrayList<Contrato> contratos = new ArrayList<Contrato>();
    //PATRON SINGLETON()
    private Sistema() {
    }

    public static Sistema getInstance() {
        if (instance == null)
            instance = new Sistema();
        return instance;
    }

    //GETTERS & ADDERS
    public ArrayList<IGeneraTicket> getUsuarios() {
        return usuarios;
    }

    //FUNCIONALIDADES
    public void registrarUsuario(IGeneraTicket nuevo) {
        //VALIDAR REGISTRO
        usuarios.add(nuevo);
    }

    public int buscaUsuarioApartirDeIdUsuario(int idUsuario) {
    	int w=0;
    	while (this.usuarios.get(w).getIdUsuario() != idUsuario)
    		w++;
        return w;
    }
    
    public void rondaContrataciones (ArrayList<Ticket_de_Busqueda_de_Empleado> empresas,ArrayList<Ticket_de_Busqueda_de_Empleo> trabajadores) throws EstadoInvalidoException 
    {
    	int a,idTicketTrabajadorElegido,posUsuarioEmpresa,posUsuarioTrabajador;
    	for (a=0; a < empresas.size();a++) {
    		if (empresas.get(a).getEstado().equalsIgnoreCase("activo")) {
	    		idTicketTrabajadorElegido = busquedaTicket(empresas.get(a).getDecision());
				if (trabajadores.get(idTicketTrabajadorElegido).getEstado().equalsIgnoreCase("activo")) {
					if (empresas.get(a).getIDTicket()==trabajadores.get(idTicketTrabajadorElegido).getDecision() && empresas.get(a).getDecision()==trabajadores.get(idTicketTrabajadorElegido).getIDTicket()) {
						Contrato contrato = new Contrato(trabajadores.get(a).getIdUsuario(),empresas.get(idTicketTrabajadorElegido).getIdUsuario());
						this.contratos.add(contrato);
						this.ticketsBusquedaEmpleados.get(a).finalizaTicket();
						this.ticketsBusquedaEmpleo.get(idTicketTrabajadorElegido).finalizaTicket();
						posUsuarioEmpresa = buscaUsuarioApartirDeIdUsuario(empresas.get(a).getIdUsuario());
						posUsuarioTrabajador = buscaUsuarioApartirDeIdUsuario(trabajadores.get(idTicketTrabajadorElegido).getIdUsuario());
						this.usuarios.get(posUsuarioEmpresa).setPuntaje(this.usuarios.get(posUsuarioEmpresa).getPuntaje()+50);
						//this.usuarios.get(posUsuarioEmpresa).calculoComision(this.ticketsBusquedaEmpleados.get(a));  //calculo de Comision, no se guarda en ningun lugar
						this.usuarios.get(posUsuarioTrabajador).setPuntaje(this.usuarios.get(posUsuarioTrabajador).getPuntaje()+10);
						//this.usuarios.get(posUsuarioTrabajador).calculoComision(this.ticketsBusquedaEmpleo.get(idTicketTrabajadorElegido));			//calculo de Comision, no se guarda en ningun lugar
					}
				}
    		}
		}
    }
    
    
    
    public int busquedaTicket (int ticket) {
    	int q=0;
    	while (this.ticketsBusquedaEmpleo.get(q).getIDTicket()!=ticket)
    		q++;
    	return q;
    }
    
    
     // Utilizando Clase nuevo de elecciones con HasMap
    public void rondaContrataciones (Eleccion trabajadores,Eleccion empresa) throws EstadoInvalidoException {
    	int a,idEmpleado,idEmpleador;
    	for (a=0; a < trabajadores.getTabla().size();a++) {
			if (trabajadores.getTabla().get(empresa.getTabla().get(a))== a){
					//.getTabla(.get(empresa.getTabla().get(a)) == a)	
				idEmpleado = IdUsuarioEmpleadoApartirDeNroTicket(a,this.ticketsBusquedaEmpleo);
				idEmpleador = IdUsuarioEmpleadorApartirDeNroTicket(a,this.ticketsBusquedaEmpleados);
				Contrato contrato = new Contrato(idEmpleado,idEmpleador);
				this.contratos.add(contrato);
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
