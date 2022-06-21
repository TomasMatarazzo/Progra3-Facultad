package modelo.usuarios;

import modelo.Sistema;
import modelo.constantes.Puntajes;
import modelo.tickets.Ticket;
import modelo.tickets.TicketSimplificado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import util.Util;

import java.util.ArrayList;

public class Agencia extends Usuario{
	
    private ArrayList <TicketSimplificado> bolsaDeTrabajo;

    public Agencia(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
        this.bolsaDeTrabajo=new ArrayList<>();
    }

    //FUNCIONALIDADES
    @Override
    public void loguearse() {
        System.out.println("El usuario [" + nombreUsuario + "] se ha logueado con exito.");
        setChanged();
        notifyObservers("Agencia");
    }

    public void muestraEmpleadores() {
        System.out.println("Lista de empleadores: ");
        for (int i = 0;i < Sistema.getInstance().getEmpleadores().size();i++)
            System.out.println(Sistema.getInstance().getEmpleadores().get(i).toString());
    }

    public void muestraSolicitudesEmpleadores() {
        System.out.println("Lista de solicitudes de empleadores: ");
        for (Ticket_de_Busqueda_de_Empleado i : Sistema.getInstance().getTicketsDeEmpleadores().keySet())
            System.out.println(i.toString());
    }

    public void muestraEmpleadosPretensos() {
        System.out.println("Lista de empleados pretensos: ");
        for (int i = 0;i < Sistema.getInstance().getEmpleadosPretensos().size();i++)
            System.out.println(Sistema.getInstance().getEmpleadosPretensos().get(i).toString());
    }

    public void muestraSolicitudEmpleadosPretensos() {
        System.out.println("Lista de solicitudes de empleadores: ");
        for (Ticket_de_Busqueda_de_Empleo i : Sistema.getInstance().getTicketsDeEmpleadosPretensos().keySet())
            System.out.println(i.toString());
    }

    public void calculaComisiones() {
        double total = 0, aux;

        System.out.println("Comision a cobrar a cada Empleador: ");
        for (int i = 0;i < Sistema.getInstance().getContratos().size();i++) {
            aux = Sistema.getInstance().getContratos().get(i).getEmpleador().calculaComision(Sistema.getInstance().getContratos().get(i).getRemuneracion());
            System.out.println("\tUsuario: " + Sistema.getInstance().getEmpleadores().get(i).getNombreUsuario() + " ~ Comision = $" + aux);
            total += aux;
        }

        System.out.println("Comision a cobrar a cada Empleado pretenso: ");
        for (int i = 0;i < Sistema.getInstance().getEmpleadosPretensos().size();i++) {
            aux = Sistema.getInstance().getContratos().get(i).getEmpleado_pretenso().calculaComision(Sistema.getInstance().getContratos().get(i).getRemuneracion());
            System.out.println("\tUsuario: " + Sistema.getInstance().getEmpleadosPretensos().get(i).getNombreUsuario() + " ~ Comision = $" + aux);
            total += aux;
        }

        System.out.println("\nMonto total a cobrar = $" + total);
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
        if (Puntajes.getPuesto1() == "\0")
            Puntajes.setPuesto1(puesto);
        else
            if (Puntajes.getPuesto2() == "\0")
                Puntajes.setPuesto2(puesto);
            else
                if (Puntajes.getPuesto3() == "\0")
                    Puntajes.setPuesto3(puesto);
                else {
                    Puntajes.setPuesto3(Puntajes.getPuesto2());
                    Puntajes.setPuesto2(Puntajes.getPuesto1());
                    Puntajes.setPuesto1(puesto);
                }
    }

    public TicketSimplificado coincidenciaTipoTrabajo(Ticket t) {
        int c = 0;
        TicketSimplificado aux, retorno = null;
        if (this.bolsaDeTrabajo.size()!= 0) {
            aux = this.bolsaDeTrabajo.get(c);
            c++;
            while (aux!=null && c<this.bolsaDeTrabajo.size() && retorno== null) {
                if (aux.getTipoDeTrabajo().equalsIgnoreCase(t.getTipoDeTrabajo()))
                    retorno = aux;
                aux = this.bolsaDeTrabajo.get(c);
                c++;

            }
        }
        return retorno;
    }

    public void agregarABolsaDeTrabajo(TicketSimplificado t){
        this.bolsaDeTrabajo.add(t);
    }
    public void eliminarABolsaDeTrabajo(TicketSimplificado t){
        this.bolsaDeTrabajo.remove(t);
    }

    //METODOS SYNCHRONIZED
    public synchronized TicketSimplificado SacaBolsa(Ticket t, Empleado_Pretenso u)
    {
        TicketSimplificado aux=null;
        while (((aux = coincidenciaTipoTrabajo(t)) == null))
        {
            try
            {
            	setChanged();
                notifyObservers(u.getNombreUsuario()+" Esperara a que haya En la bolsa de Trabajo algún trabajo de Su tipo Buscado");
            	//System.out.println("El Empleado Pretenso "+ u.getNombreUsuario() + " Esperara a que haya En la bolsa de Trabajo algún trabajo de Su tipo Buscado");
                wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.eliminarABolsaDeTrabajo(aux);
        setChanged();
        notifyObservers(u.getNombreUsuario()+" Saco de la Bolsa un trabajo");
        //System.out.println("EL empleado "+u.getNombreUsuario()+" Saca de la Bolsa un trabajo para evaluar su Locacion");
        notifyAll();
        Util.espera(1000);
        return aux;
    }

    public synchronized void PoneBolsa(TicketSimplificado t, UsuarioComun u){
        this.agregarABolsaDeTrabajo(t);
        setChanged();
        notifyObservers(u.getNombreUsuario()+" Puso un trabajo En la bolsa de Trabajo");
        //System.out.println("El Usuario "+ u.getNombreUsuario() + " Puso un trabajo En la bolsa de Trabajo");
        notifyAll();
        Util.espera(1000);
    }
}