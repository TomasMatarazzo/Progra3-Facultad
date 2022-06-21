package modelo.usuarios;

import modelo.Sistema;
import modelo.constantes.Puntajes;
import modelo.tickets.Ticket;
import modelo.tickets.TicketSimplificado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import java.util.ArrayList;

public class Agencia extends Usuario {
    private double total;
    

    public Agencia(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
        this.total = 0;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    //FUNCIONALIDADES
    @Override
    public void loguearse() {
        setChanged();
        notifyObservers("Agencia");
    }

    public void muestraEmpleadores() {
        for (int i = 0;i < Sistema.getInstance().getEmpleadores().size();i++) {
            setChanged();
            notifyObservers(Sistema.getInstance().getEmpleadores().get(i).toString());
        }

    }

    public void muestraSolicitudesEmpleadores() {
        for (Ticket_de_Busqueda_de_Empleado i : Sistema.getInstance().getTicketsDeEmpleadores().keySet()) {
            setChanged();
            notifyObservers(i.toString());
        }
    }

    public void muestraEmpleadosPretensos() {
        for (int i = 0;i < Sistema.getInstance().getEmpleadosPretensos().size();i++) {
            setChanged();
            notifyObservers(Sistema.getInstance().getEmpleadosPretensos().get(i).toString());
        }
    }

    public void muestraSolicitudEmpleadosPretensos() {
        for (Ticket_de_Busqueda_de_Empleo i : Sistema.getInstance().getTicketsDeEmpleadosPretensos().keySet()) {
            setChanged();
            notifyObservers(i.toString());
        }
    }

    public void calculaComisiones() {
        double aux;

        for (int i = 0;i < Sistema.getInstance().getContratos().size();i++) {
            aux = Sistema.getInstance().getContratos().get(i).getEmpleador().calculaComision(Sistema.getInstance().getContratos().get(i).getRemuneracion());
            this.total += aux;
            setChanged();
            notifyObservers("Usuario: " + Sistema.getInstance().getEmpleadores().get(i).getNombreUsuario() + " ~ Comision = $" + aux);
        }
        
        for (int i = 0;i < Sistema.getInstance().getEmpleadosPretensos().size();i++) {
            aux = Sistema.getInstance().getContratos().get(i).getEmpleado_pretenso().calculaComision(Sistema.getInstance().getContratos().get(i).getRemuneracion());
            this.total += aux;
            setChanged();
            notifyObservers("\tUsuario: " + Sistema.getInstance().getEmpleadosPretensos().get(i).getNombreUsuario() + " ~ Comision = $" + aux);
        }
    }

    public void agregarTipoDeTrabajo(String trabajo) {
        Sistema.getInstance().agregaTiposDeTrabajo(trabajo);
    }

    public void confeccionarRangoEtario(int edad){
        if (Puntajes.getEdad1() == -1)
            Puntajes.setEdad1(edad);
        else
            if (Puntajes.getEdad2() == -1)
                Puntajes.setEdad2(edad);
            else if (edad > Puntajes.getEdad1())
                Puntajes.setEdad2(edad);
            else
                Puntajes.setEdad1(edad);
    }

    public void confeccionarTipoDePuesto(String puesto){
        if (Puntajes.getPuesto1().isEmpty())
            Puntajes.setPuesto1(puesto);
        else
            if (Puntajes.getPuesto2().isEmpty())
                Puntajes.setPuesto2(puesto);
            else
                if (Puntajes.getPuesto3().isEmpty())
                    Puntajes.setPuesto3(puesto);
                else {
                    Puntajes.setPuesto3(Puntajes.getPuesto2());
                    Puntajes.setPuesto2(Puntajes.getPuesto1());
                    Puntajes.setPuesto1(puesto);
                }
    }

    
}