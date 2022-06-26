package simulacion;

import java.util.ArrayList;
import java.util.Observable;
import modelo.tickets.Ticket;
import modelo.usuarios.EmpleadoPretenso;
import modelo.usuarios.UsuarioComun;

public class BolsaDeTrabajo extends Observable{

	private static BolsaDeTrabajo instancia = null;	
	private ArrayList <TicketSimplificado> bolsa = new ArrayList<>();
	
	private BolsaDeTrabajo() {	}
	
	public static BolsaDeTrabajo getInstancia() {
		if (instancia == null)
			instancia = new BolsaDeTrabajo();
		return instancia;
	}

	public TicketSimplificado coincidenciaTipoTrabajo(Ticket t) {
        int c = 0;
        TicketSimplificado aux, retorno = null;
        if (this.bolsa.size()!= 0) {
            aux = this.bolsa.get(c);
            c++;
            while (aux!=null && c<this.bolsa.size() && retorno== null) {
                if (aux.getTipoDeTrabajo().equalsIgnoreCase(t.getTipoDeTrabajo()))
                    retorno = aux;
                aux = this.bolsa.get(c);
                c++;
            }
        }
        return retorno;
    }
	
    public void agregarABolsaDeTrabajo(TicketSimplificado t){
        this.bolsa.add(t);
    }

    public void eliminarABolsaDeTrabajo(TicketSimplificado t){
        this.bolsa.remove(t);
    }

    //METODOS SYNCHRONIZED
    public synchronized TicketSimplificado SacaBolsa(Ticket t, EmpleadoPretenso u) {
        TicketSimplificado aux = coincidenciaTipoTrabajo(t);
        while ((aux == null) || (aux!=null && aux.getEstado().equalsIgnoreCase("Finalizado")) || (aux!=null && aux.getEstado().equalsIgnoreCase("Suspenso"))) {
            try {
            	setChanged();
                notifyObservers(u.getNombreUsuario()+" Esperara por algun trabajo de su Tipo");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        aux.setEstado("Suspenso");
        this.eliminarABolsaDeTrabajo(aux);
        setChanged();
	    notifyObservers(u.getNombreUsuario()+" Saca un trabajo de la bolsa para evaluar su locación");	
        notifyAll();
        return aux;
    }
    
    public synchronized void DevulveABolsa(TicketSimplificado t, UsuarioComun u){
    	if (t.getEstado().equalsIgnoreCase("Finalizado")) {
    		setChanged();
    		notifyObservers(u.getNombreUsuario()+" OBTUVO EL TRABAJO!!!");
    	} else {
    		t.setEstado("Activo");
    		this.agregarABolsaDeTrabajo(t);
    		setChanged();
    		notifyObservers(u.getNombreUsuario()+" Devolvio el trabajo a la bolsa por no coincidir su Locacion");
    	}
        notifyAll();
    }

    public synchronized void PoneBolsa(TicketSimplificado t, UsuarioComun u){
        this.agregarABolsaDeTrabajo(t);
        setChanged();
        notifyObservers(u.getNombreUsuario()+" Puso un trabajo En la bolsa de Trabajo");
        notifyAll();
    }
}