package modelo.usuarios.empleadores;

import modelo.excepciones.DatosMalIngresadosException;
import modelo.tickets.locaciones.ILocacion;
import modelo.Sistema;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.TicketSimplificado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.locaciones.LocacionFactory;
import modelo.usuarios.UsuarioComun;

import java.util.ArrayList;

public abstract class Empleador extends UsuarioComun implements Runnable {
    private String razonSocial; //Seria el NOMBRE
    private String rubro; // salud, comercio local o comercio internacional
    private int[] pesoPuntajes;
    //Tickets
    private ArrayList<Ticket_de_Busqueda_de_Empleado> ticketsDeBusquedaDeEmpleado = new ArrayList<>();

    //CONSTRUCTORES
    public Empleador(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    public Empleador(String nombreUsuario, String contrasena, String razonSocial, String rubro) {
        super(nombreUsuario, contrasena);
        this.razonSocial = razonSocial;
        this.rubro = rubro;
        this.pesoPuntajes = new int[7];
    }


    //GETTERS & SETTERS & ADDERS
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public ArrayList<Ticket_de_Busqueda_de_Empleado> getTicketsDeBusquedaDeEmpleado() {
        return ticketsDeBusquedaDeEmpleado;
    }

    public void setTicketsDeBusquedaDeEmpleado(ArrayList<Ticket_de_Busqueda_de_Empleado> ticketsDeBusquedaDeEmpleado) {
        this.ticketsDeBusquedaDeEmpleado = ticketsDeBusquedaDeEmpleado;
    }

    public int[] getPesoPuntajes() {
        return pesoPuntajes;
    }

    public void setPesoPuntajes(int[] pesoPuntajes) {
        this.pesoPuntajes = pesoPuntajes;
    }

    //TO STRING
    @Override
    public String toString() {
        return  "   nombreUsuario: '" + nombreUsuario +
                "   contrasena: '" + contrasena + //Esta bien mostrarla?
                "   razonSocial: '" + razonSocial +
                "   rubro: '" + rubro +
                "   puntaje: " + puntaje;
    }

    //FUNCIONALIDADES
    @Override
    public void loguearse() {
        System.out.println("El usuario [" + nombreUsuario + "] se ha logueado con exito.");
        setChanged();
        notifyObservers("Empleado");
    }

    public abstract double calculaPorcentajeComision();

    /**
     * TEXTO
     * Pre: Los atributos tipoPersona y rubro deben estar inicializados correctamente
     * Post: Devuelve el resultado del producto entre el porcentaje correspondiente al empleador y la suma de las remuneraciones de los contratos finalizados.
     * @return monto * porcentaje
     */
    @Override
    public double calculaComision(double remuneracion) {
        double porcentaje;

        porcentaje = calculaPorcentajeComision();

        //Por cada punto obtenido se le resta un 1% al valor de la comisión
        if (this.puntaje > 0)
            porcentaje -= 0 + (0.01 * this.puntaje);

        return remuneracion * porcentaje;
    }

    public void creaTicket(Formulario_de_Busqueda formulario, String tipoTrabajo, int[] pesoAspectos) {
        Ticket_de_Busqueda_de_Empleado nuevo;

        nuevo = new Ticket_de_Busqueda_de_Empleado(formulario,tipoTrabajo,pesoAspectos);
        this.ticketsDeBusquedaDeEmpleado.add(nuevo);
        Sistema.getInstance().agregaTicketDeEmpleadores(this,nuevo);
    }

    public void gestionaTicket(Ticket_de_Busqueda_de_Empleado ticket,String estado) {
        try {
            if (!estado.equalsIgnoreCase("FINALIZADO")) {
                if (estado.equalsIgnoreCase("ACTIVO"))
                    if (ticket.getEstado().equalsIgnoreCase("SUSPENDIDO"))
                        ticket.setEstado(estado);
                    else
                        throw new DatosMalIngresadosException("No es posible activar un ticket de estado: " + ticket.getEstado());
                else
                if (estado.equalsIgnoreCase("SUSPENDIDO"))
                    if (ticket.getEstado().equalsIgnoreCase("ACTIVO"))
                        ticket.setEstado(estado);
                    else
                        throw new DatosMalIngresadosException("No es posible suspender un ticket de estado: " + ticket.getEstado());
                else
                if (estado.equalsIgnoreCase("CANCELADO")) {
                    this.puntaje--;
                    ticket.setEstado(estado);
                }
            } else
                throw new DatosMalIngresadosException("No tiene los permisos para realizar esta accion.");
        } catch (DatosMalIngresadosException e) {
            System.out.println(e.getMessage());
        }
    }

    public void muestraLista() {
        for (Ticket_de_Busqueda_de_Empleado ticket_de_busqueda_de_empleado : ticketsDeBusquedaDeEmpleado)
            if (ticket_de_busqueda_de_empleado.getEstado().equalsIgnoreCase("ACTIVO"))
                System.out.println("Lista del usuario [" + this.nombreUsuario + "]: (en un mal formato)\n" + Sistema.getInstance().getListas().get(ticket_de_busqueda_de_empleado).toString());
    }

    public TicketSimplificado generaTicketRandom() {
        TicketSimplificado ts = null;
        int a,b;
        LocacionFactory lc = new LocacionFactory();
        ILocacion loc = null;
        a = (int) Math.round(2*Math.random());
        switch (a) {
            case 0 -> loc = lc.getLocacion("HOMEOFFICE");
            case 1 -> loc = lc.getLocacion("PRESENCIAL");
            case 2 -> loc = lc.getLocacion("INDISTINTO");
        }
        a = (int) Math.round((Sistema.getInstance().getTiposDeTrabajo().size()-1)*Math.random());
        ts = new TicketSimplificado(new Formulario_de_Busqueda(loc,0,0,0,0,0,0),Sistema.getInstance().getTiposDeTrabajo().get(a));
        return ts;
    }

    @Override
    public void run() {
        TicketSimplificado ts;
        for (int t =0; t<3; t++) {
            ts = generaTicketRandom();
            Sistema.getInstance().getAgencia().PoneBolsa(ts, this);
        }
    }
}
