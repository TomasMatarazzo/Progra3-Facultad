package modelo.usuarios;

import excepciones.DatosMalIngresadosException;
import excepciones.TicketYaCreadoException;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;

public class Empleado_Pretenso extends UsuarioComun {
    //Datos personales:
    private String nombre;
    private String apellido;
    private String telefono;
    private int edad;
    private String eMail;
    //Ticket
    private Ticket_de_Busqueda_de_Empleo ticketDeBusquedaDeEmpleo;

    //CONSTRUCTORES
    public Empleado_Pretenso(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
        this.ticketDeBusquedaDeEmpleo = null;
    }

    public Empleado_Pretenso(String nombreUsuario, String contrasena, String nombre, String apellido, String telefono, int edad, String eMail) {
        super(nombreUsuario, contrasena);
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.eMail = eMail;
        this.ticketDeBusquedaDeEmpleo = null;
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

    public Ticket_de_Busqueda_de_Empleo getTicketDeBusquedaDeEmpleo() {
        return ticketDeBusquedaDeEmpleo;
    }

    public void setDatos(String nombre, String apellido, String telefono, int edad, String eMail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.eMail = eMail;
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

    public void creaTicket(Formulario_de_Busqueda formulario,String tipoTrabajo) throws TicketYaCreadoException {
        if (this.ticketDeBusquedaDeEmpleo == null || this.ticketDeBusquedaDeEmpleo.getEstado().equalsIgnoreCase("CANCELADO") || this.ticketDeBusquedaDeEmpleo.getEstado().equalsIgnoreCase("FINALIZADO")) {
            this.ticketDeBusquedaDeEmpleo = new Ticket_de_Busqueda_de_Empleo(formulario,tipoTrabajo);
            sistema.agregaTicketDeEmpleadosPretensos(this,this.ticketDeBusquedaDeEmpleo);
        } else
            throw new TicketYaCreadoException("Ticket de busqueda de empleo ya existente.");
    }

    public void gestionaTicket(String estado) {
        try {
            if (!estado.equalsIgnoreCase("FINALIZADO")) {
                if (estado.equalsIgnoreCase("ACTIVO"))
                    if (this.ticketDeBusquedaDeEmpleo.getEstado().equalsIgnoreCase("SUSPENDIDO"))
                        this.ticketDeBusquedaDeEmpleo.setEstado(estado);
                    else
                        throw new DatosMalIngresadosException("No es posible activar un ticket de estado: " + this.ticketDeBusquedaDeEmpleo.getEstado());
                else
                    if (estado.equalsIgnoreCase("SUSPENDIDO"))
                        if (this.ticketDeBusquedaDeEmpleo.getEstado().equalsIgnoreCase("ACTIVO"))
                            this.ticketDeBusquedaDeEmpleo.setEstado(estado);
                        else
                            throw new DatosMalIngresadosException("No es posible suspender un ticket de estado: " + this.ticketDeBusquedaDeEmpleo.getEstado());
                    else
                        if (estado.equalsIgnoreCase("CANCELADO")) {
                            this.puntaje--;
                            this.ticketDeBusquedaDeEmpleo.setEstado(estado);
                        }
            } else
                throw new DatosMalIngresadosException("No tiene los permisos para realizar esta accion.");
        } catch (DatosMalIngresadosException e) {
            System.out.println(e.getMessage());
        }
    }

    public void muestraLista() {
        if (ticketDeBusquedaDeEmpleo.getEstado().equalsIgnoreCase("ACTIVO"))
            System.out.println("Lista del usuario [" + this.nombreUsuario + "]: (en un mal formato)\n" + sistema.getListas().get(this.ticketDeBusquedaDeEmpleo).toString());
    }
}
