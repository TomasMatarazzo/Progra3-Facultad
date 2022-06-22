package modelo.usuarios;

import modelo.excepciones.DatosMalIngresadosException;
import modelo.excepciones.EstadoException;
import modelo.excepciones.TicketYaCreadoException;
import modelo.Sistema;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import simulacion.BolsaDeTrabajo;
import simulacion.TicketSimplificado;
import util.Util;

import java.io.Serializable;

public class EmpleadoPretenso extends UsuarioComun implements Runnable, Serializable {
    //Datos personales:
    private String nombre;
    private String apellido;
    private String telefono;
    private int edad;
    private String eMail;
    //Ticket
    private Ticket_de_Busqueda_de_Empleo ticketDeBusquedaDeEmpleo;
    private TicketSimplificado ticketSimplificado;

    //CONSTRUCTORES

    public EmpleadoPretenso() {
    }

    public EmpleadoPretenso(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
        this.ticketDeBusquedaDeEmpleo = null;
        this.ticketSimplificado = null;
    }

    public EmpleadoPretenso(String nombreUsuario, String contrasena, String nombre, String apellido, String telefono, int edad, String eMail) {
        super(nombreUsuario, contrasena);
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.eMail = eMail;
        this.ticketDeBusquedaDeEmpleo = null;
        this.ticketSimplificado=null;
    }

    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    

    public void setTicketDeBusquedaDeEmpleo(Ticket_de_Busqueda_de_Empleo ticketDeBusquedaDeEmpleo) {
		this.ticketDeBusquedaDeEmpleo = ticketDeBusquedaDeEmpleo;
	}

	public Ticket_de_Busqueda_de_Empleo getTicketDeBusquedaDeEmpleo() {
        return ticketDeBusquedaDeEmpleo;
    }

	
    //TO STRING
    @Override
    public String toString() {
        return  "   nombreUsuario: " + nombreUsuario +
                "   contrasena: " + contrasena + //La muestro?
                "   nombre: " + nombre +
                "   apellido: " + apellido +
                "   telefono: " + telefono +
                "   edad: " + edad +
                "   eMail: " + eMail +
                "   puntaje: " + puntaje;
    }

    //FUNCIONALIDADES
    @Override
    public void loguearse() {
        setChanged();
        notifyObservers("Empleado Pretenso");
    }

    /**
     * Este método calcula la comisión a cobrar al Empleado pretenso según el tipo de Puesto Laboral.<br>
     * <b>pre: </b> Ticket de busqueda de empleado debe estar inicializada (!=null).<br>
     * @param remuneracion: tipo double, representa la remuneración en bruto
     * @return un double que representa la comisión
     */
    @Override
    public double calculaComision(double remuneracion) {
        double porcentaje;

        if (this.ticketDeBusquedaDeEmpleo.getFormularioDeBusqueda().getTipoPuestoLaboral() == 0)
            porcentaje = 0.80;
        else if (this.ticketDeBusquedaDeEmpleo.getFormularioDeBusqueda().getTipoPuestoLaboral() == 1)
            porcentaje = 0.90;
        else //Es puesto laboral GERENCIAL
            porcentaje = 1.00;

        //Por cada punto obtenido se le resta un 1% al valor de la comisión
        if (this.puntaje > 0)
            porcentaje -= (0.01 * this.puntaje);

        return remuneracion * porcentaje;
    }

    /**
     * Crea un ticket de busqueda de empleo
     * <b>Pre: </b> tipoTrabajo debe ser distinto de null y no estar vacio <br>
     * <b>Post: </b> Agrega el ticket de busqueda de empleo al sistema y al propio usuario, en caso contrario, lanza una excepcion <br>
     * @param formulario: de tipo Formulario_de_Busqueda, contiene los datos relacionados al empleo
     * @param tipoTrabajo: de tipo String, representa el tipo de trabajo solicitado
     * @throws TicketYaCreadoException
     */
    public void creaTicket(Formulario_de_Busqueda formulario,String tipoTrabajo) throws TicketYaCreadoException {
        if (this.ticketDeBusquedaDeEmpleo == null || this.ticketDeBusquedaDeEmpleo.getEstado().equalsIgnoreCase("CANCELADO") || this.ticketDeBusquedaDeEmpleo.getEstado().equalsIgnoreCase("FINALIZADO")) {
            this.ticketDeBusquedaDeEmpleo = new Ticket_de_Busqueda_de_Empleo(formulario,tipoTrabajo);
            Sistema.getInstance().agregaTicketDeEmpleadosPretensos(this,this.ticketDeBusquedaDeEmpleo);
        } else
            throw new TicketYaCreadoException("Ticket de busqueda de empleo ya existente.");
    }

    /**
     * Cambia y cerifica el estado del ticket del usuario
     * <b>Pre: </b> estado debe ser distinto de null y no estar vacio <br>
     * <b>Post: </b> se cambio el estado del ticket del empleado pretenso <br>
     * @param estado: de tipo String, representa el tipo de estado que quiero que tenga el ticket.
     * @throws EstadoException 
     * @throws DatosMalIngresadosException cuando el dato ingresado como parametro es incorrecto
     */
    public void gestionaTicket(String estado) throws EstadoException {
    	String mayu = estado;
    	mayu.toUpperCase();
    	switch (estado) {
    	case "ACTIVO" : 
    		this.getTicketDeBusquedaDeEmpleo().activar();
    		this.ticketDeBusquedaDeEmpleo.setEstado(mayu);
    		break;
    	case "SUSPENDIDO" : 
    		this.getTicketDeBusquedaDeEmpleo().suspender();
    		this.ticketDeBusquedaDeEmpleo.setEstado(mayu);
    		break;
    	case "CANCELADO" : 
    		this.getTicketDeBusquedaDeEmpleo().cancelar();
    		this.ticketDeBusquedaDeEmpleo.setEstado(mayu);
    		this.puntaje--;
    		break;
    	case "FINALIZADO" : 
    		this.getTicketDeBusquedaDeEmpleo().finalizar();
    		this.ticketDeBusquedaDeEmpleo.setEstado(mayu);
    		break;
    	}
    }

    /**
     * Este método muestra la lista de asignación del empleado pretenso.<br>
     * <b>pre:</b> ticket de busqueda de empleo (!= null). Lista de asignacion (!=null). Empleado-Pretenso inicializado (!=null)<br>
     */
    public void muestraLista() {
        if (ticketDeBusquedaDeEmpleo.getEstado().equalsIgnoreCase("ACTIVO"))
            System.out.println("Lista del usuario [" + this.nombreUsuario + "]: (en un mal formato)\n" + Sistema.getInstance().getListas().get(this.ticketDeBusquedaDeEmpleo).toString());
    }

    public TicketSimplificado getTicketSimplificado() {
        return ticketSimplificado;
    }

    public void setTicketSimplificado(TicketSimplificado ticketSimplificado) {
        this.ticketSimplificado = ticketSimplificado;
    }

    @Override
    public void run(){
        int i=0;
        TicketSimplificado aux=null;
        while ((i < 10) && (this.ticketSimplificado == null)){	
          aux = BolsaDeTrabajo.getInstancia().SacaBolsa(this.ticketDeBusquedaDeEmpleo,this);
          if(aux.getFormularioDeBusqueda().puntajeLocacion(this.ticketDeBusquedaDeEmpleo.getFormularioDeBusqueda().getLocacion())==1) {
        	  aux.setEstado("Finalizado");
        	  this.ticketSimplificado =aux;
          }
          Util.espera(2000);
          BolsaDeTrabajo.getInstancia().DevulveABolsa(aux, this);
          Util.espera(2000);
          i++;
        }
    }
    
}
