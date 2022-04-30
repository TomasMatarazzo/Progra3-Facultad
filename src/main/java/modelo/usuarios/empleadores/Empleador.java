package modelo.usuarios.empleadores;

import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.usuarios.UsuarioComun;

import java.util.ArrayList;

public abstract class Empleador extends UsuarioComun {
    private String razonSocial; //Seria el NOMBRE
    private String tipoPersona; // fisica o juridica
    private String rubro; // salud, comercio local o comercio internacional
    private int[] pesoPuntajes;
    //Tickets
    private ArrayList<Ticket_de_Busqueda_de_Empleado> ticketsDeBusquedaDeEmpleado = new ArrayList<>();

    //CONSTRUCTORES
    public Empleador(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    public Empleador(String nombreUsuario, String contrasena, String tipoPersona, String razonSocial, String rubro) {
        super(nombreUsuario, contrasena);
        this.razonSocial = razonSocial;
        this.tipoPersona = tipoPersona;
        this.rubro = rubro;
        this.pesoPuntajes = new int[7];
    }


    //GETTERS & SETTERS & ADDERS
    public String getRazonSocial() {
        return razonSocial;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public String getRubro() {
        return rubro;
    }

    public void setDatos(String tipoPersona, String razonSocial, String rubro) {
        this.razonSocial = razonSocial;
        this.tipoPersona = tipoPersona;
        this.rubro = rubro;
    }

    public ArrayList<Ticket_de_Busqueda_de_Empleado> getTicketsDeBusquedaDeEmpleado() {
        return ticketsDeBusquedaDeEmpleado;
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
        return "Empleador: " +
                "   IDUsuario: " + IDUsuario +
                "   nombreUsuario: '" + nombreUsuario +
                "   contrasena: '" + contrasena + //Esta bien mostrarla?
                "   razonSocial: '" + razonSocial +
                "   tipoPersona: '" + tipoPersona +
                "   rubro: '" + rubro +
                "   puntaje: " + puntaje;
    }

    //FUNCIONALIDADES
    public abstract double calculaPorcentajeComision();

    /**
     * TEXTO
     * Pre: Los atributos tipoPersona y rubro deben estar inicializados correctamente
     * Post: Devuelve el resultado del producto entre el porcentaje correspondiente al empleador y la suma de las remuneraciones de los contratos finalizados.
     * @return monto * porcentaje
     */
    @Override
    public double calculaComision() {
        double monto = 0, porcentaje;

        for (int i = 0;i < this.ticketsDeBusquedaDeEmpleado.size();i++)
            if (this.ticketsDeBusquedaDeEmpleado.get(i).getEstado().equalsIgnoreCase("FINALIZADO"))
                monto += 999999; //FALTA SACAR DE CONTRATOS

        porcentaje = calculaPorcentajeComision();

        //Por cada punto obtenido se le resta un 1% al valor de la comisión
        if (this.puntaje > 0)
            porcentaje -= 0 + (0.01 * this.puntaje);

        return monto * porcentaje;
    }

}