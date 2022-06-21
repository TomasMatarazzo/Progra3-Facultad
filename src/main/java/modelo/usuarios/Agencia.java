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
    private ArrayList <TicketSimplificado> bolsaDeTrabajo;

    public Agencia(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
        this.total = 0;
        this.bolsaDeTrabajo=new ArrayList<>();
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
        System.out.println("El usuario [" + nombreUsuario + "] se ha logueado con exito.");
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
            notifyObservers(Sistema.getInstance().getEmpleadores().get(i).toString());
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

        System.out.println("Comision a cobrar a cada Empleador: ");
        for (int i = 0;i < Sistema.getInstance().getContratos().size();i++) {
            aux = Sistema.getInstance().getContratos().get(i).getEmpleador().calculaComision(Sistema.getInstance().getContratos().get(i).getRemuneracion());
            this.total += aux;
            setChanged();
            notifyObservers("Usuario: " + Sistema.getInstance().getEmpleadores().get(i).getNombreUsuario() + " ~ Comision = $" + aux);
        }

        System.out.println("Comision a cobrar a cada Empleado pretenso: ");
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
    public synchronized void SacaBolsa(Ticket t, Empleado_Pretenso u)
    {
        TicketSimplificado aux;
        while (((aux = coincidenciaTipoTrabajo(t)) == null))
        {
            try
            {
            	setChanged();
                notifyObservers(u.getNombreUsuario()+" Esperara por algun trabajo de su Tipo");
            	//System.out.println("El Empleado Pretenso "+ u.getNombreUsuario() + " Esperara a que haya En la bolsa de Trabajo algún trabajo de Su tipo Buscado");
                wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        setChanged();
        if(aux.getFormularioDeBusqueda().puntajeLocacion(t.getFormularioDeBusqueda().getLocacion())==1){
             u.setTicketSimplificado(aux);
             notifyObservers(u.getNombreUsuario()+" CONSIGUIO EL TRABAJO!!!");
             Sistema.getInstance().getAgencia().eliminarABolsaDeTrabajo(aux);
        }else
        	notifyObservers(u.getNombreUsuario()+" No consiguio el Trabajo por no coincidir la Locacion ");
        	
        notifyAll();
    }

    public synchronized void PoneBolsa(TicketSimplificado t, UsuarioComun u){
        this.agregarABolsaDeTrabajo(t);
        setChanged();
        notifyObservers(u.getNombreUsuario()+" Puso un trabajo En la bolsa de Trabajo");
        //System.out.println("El Usuario "+ u.getNombreUsuario() + " Puso un trabajo En la bolsa de Trabajo");
        notifyAll();
    }
}