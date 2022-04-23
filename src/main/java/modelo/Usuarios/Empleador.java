package modelo.Usuarios;

import modelo.Tickets.Formulario_de_Busqueda;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Empleador extends Usuario {
    private String razonSocial; //Seria el NOMBRE
    private String tipoPersona; // fisica o juridica
    private String rubro; // salud, comercio local o comercio internacional
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
    }

    //GETTERS & ADDERS
    public String getRazonSocial() {
        return razonSocial;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public String getRubro() {
        return rubro;
    }

    public ArrayList<Ticket_de_Busqueda_de_Empleado> getTicketsDeBusquedaDeEmpleado() {
        return ticketsDeBusquedaDeEmpleado;
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
    public void creaTicket(Formulario_de_Busqueda formulario, GregorianCalendar fechaAlta, int cantidadEmpleadosSolicitados,int[] vecPesos) {
        Ticket_de_Busqueda_de_Empleado nuevo = new Ticket_de_Busqueda_de_Empleado(formulario,fechaAlta,cantidadEmpleadosSolicitados,vecPesos);
        ticketsDeBusquedaDeEmpleado.add(nuevo);
    }

    /**
     * TEXTO
     * Pre: Los atributos tipoPersona y rubro deben estar inicializados correctamente
     * Post: Devuelve el resultado del producto entre el porcentaje correspondiente al empleador y la suma de las remuneraciones de los contratos finalizados.
     * @return monto * porcentaje
     */
    @Override
    public double calculaComision() { //LA HAGO PROTECTED?
        double monto = 0, porcentaje;

        for (int i = 0;i < this.ticketsDeBusquedaDeEmpleado.size();i++) {
            if (this.ticketsDeBusquedaDeEmpleado.get(i).getEstado().equalsIgnoreCase("FINALIZADO"))
            monto += this.ticketsDeBusquedaDeEmpleado.get(i).getFormularioDeBusqueda().getRemuneracion();
        }

        if (this.tipoPersona.equalsIgnoreCase("FISICA")) {
            if (this.rubro.equalsIgnoreCase("SALUD"))
                porcentaje = 0.60;
            else if (this.rubro.equalsIgnoreCase("COMERCIO LOCAL"))
                porcentaje = 0.70;
            else //Es rubro COMERCIO INTERNACIONAL
                porcentaje = 0.80;
        } else {//Es persona juridica
            if (this.rubro.equalsIgnoreCase("SALUD"))
                porcentaje = 0.80;
            else if (this.rubro.equalsIgnoreCase("COMERCIO LOCAL"))
                porcentaje = 0.90;
            else //Es rubro COMERCIO INTERNACIONAL
                porcentaje = 1.00;
        }

        //Por cada punto obtenido se le resta un 1% al valor de la comisión
        if (this.puntaje > 0)
            porcentaje -= 0 + (0.01 * this.puntaje);

        return monto * porcentaje;
    }

}
