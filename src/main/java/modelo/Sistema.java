package modelo;

import modelo.excepciones.ErrorDeContrasenaException;
import modelo.excepciones.ErrorDeUsuarioException;
import modelo.excepciones.EstadoException;
import modelo.listas.Contrato;
import modelo.tickets.Ticket;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.usuarios.Agencia;
import modelo.usuarios.EmpleadoPretenso;
import modelo.usuarios.Usuario;
import modelo.usuarios.empleadores.Empleador;
import modelo.listas.Lista;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa la totalidad del sistema, encargada de administrar los distintos datos durante el tiempo de ejecucion.
 */
public class Sistema{
    private static Sistema instance = null;
    private Agencia agencia = null;
    private ArrayList<Empleador> empleadores = new ArrayList<>();
    private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<>();
    private ArrayList<String> tiposDeTrabajo = new ArrayList<>();
    private HashMap<Ticket_de_Busqueda_de_Empleado,Empleador> ticketsDeEmpleadores = new HashMap<>();
    private HashMap<Ticket_de_Busqueda_de_Empleo, EmpleadoPretenso> ticketsDeEmpleadosPretensos = new HashMap<>();
    private HashMap<Ticket,Lista> listas = new HashMap<>();
    private ArrayList<Contrato> contratos = new ArrayList<>();

    //PATRON SINGLETON
    private Sistema() {
    }

    public static Sistema getInstance() {
        if (instance == null)
            instance = new Sistema();
        return instance;
    }

    //GETTERS & SETTERS & ADDERS
    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public ArrayList<Empleador> getEmpleadores() {
        return empleadores;
    }

    public ArrayList<EmpleadoPretenso> getEmpleadosPretensos() {
        return empleadosPretensos;
    }

    public ArrayList<String> getTiposDeTrabajo() {
        return tiposDeTrabajo;
    }

    public HashMap<Ticket_de_Busqueda_de_Empleado, Empleador> getTicketsDeEmpleadores() {
        return ticketsDeEmpleadores;
    }

    public HashMap<Ticket_de_Busqueda_de_Empleo, EmpleadoPretenso> getTicketsDeEmpleadosPretensos() {
        return ticketsDeEmpleadosPretensos;
    }

    public void setEmpleadores(ArrayList<Empleador> empleadores) {
        this.empleadores = empleadores;
    }

    public void setEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadosPretensos) {
        this.empleadosPretensos = empleadosPretensos;
    }

    public void setTicketsDeEmpleadores(HashMap<Ticket_de_Busqueda_de_Empleado, Empleador> ticketsDeEmpleadores) {
        this.ticketsDeEmpleadores = ticketsDeEmpleadores;
    }

    public void setTicketsDeEmpleadosPretensos(HashMap<Ticket_de_Busqueda_de_Empleo, EmpleadoPretenso> ticketsDeEmpleadosPretensos) {
        this.ticketsDeEmpleadosPretensos = ticketsDeEmpleadosPretensos;
    }

    public void agregaEmpleador(Empleador nuevo) {
        empleadores.add(nuevo);
    }

    public void agregaEmpleadoPretenso(EmpleadoPretenso nuevo) {
        empleadosPretensos.add(nuevo);
    }

    public void agregaTiposDeTrabajo(String nuevo) {
        tiposDeTrabajo.add(nuevo);
    }

    public void agregaTicketDeEmpleadosPretensos(EmpleadoPretenso usuario, Ticket_de_Busqueda_de_Empleo ticket) {
        ticketsDeEmpleadosPretensos.put(ticket,usuario);
    }

    public void agregaTicketDeEmpleadores(Empleador usuario,Ticket_de_Busqueda_de_Empleado ticket) {
        ticketsDeEmpleadores.put(ticket,usuario);
    }

    public void eliminaEmpleador(Empleador elim) {
        empleadores.remove(elim);
    }

    public void eliminaEmpleado(EmpleadoPretenso elim) {
        empleadosPretensos.remove(elim);
    }

    public void eliminaTicketDeEmpleadosPretensos( Ticket_de_Busqueda_de_Empleo ticket) {
    	ticketsDeEmpleadosPretensos.remove(ticket);
    }	
    public void eliminaTicketDeEmpleadores(Empleador usuario,Ticket_de_Busqueda_de_Empleado ticket) {
    	ticketsDeEmpleadores.remove(ticket);
    }
    
    public void seleccionarEmpleadorRondaContrataciones( Ticket_de_Busqueda_de_Empleado ticket) {
    	// Con cambiar la referencia bastara??
    	ticketsDeEmpleadores.get(ticket);
    }

    public HashMap<Ticket,Lista> getListas() {
        return listas;
    }

    public void setListas(HashMap<Ticket, Lista> listas) {
        this.listas = listas;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    //FUNCIONALIDADES
    /**
     * Registra un nuevo empleador en el sistema, ya sea una persona fisica o una persona juridica.
     * <b>Pre: </b> nuevo debe ser distinto de null <br>
     * <b>Post: </b> el nuevo empleador se agrega al ArrayList de empleadores<br>
     * @param nuevo: de tipo Empleador, representa un usuario en el sistema
     * @throws ErrorDeUsuarioException
     */
    public void registrarUsuario(Empleador nuevo) throws ErrorDeUsuarioException {
        for (int i = 0; i < empleadores.size(); i++) {
            if (empleadores.get(i).getNombreUsuario().equalsIgnoreCase(nuevo.getNombreUsuario()))
                throw new ErrorDeUsuarioException("El nombre de usuario ingresado ya existe.");
        }
        agregaEmpleador(nuevo);
    }

    /**
     * Registra un nuevo empleado pretenso en el sistema.
     * <b>Pre: </b> nuevo debe ser distinto de null <br>
     * <b>Post: </b> el nuevo empleado pretenso se agrega al ArrayList de empeladosPretensos<br>
     * @param nuevo: de tipo Empleado_Pretenso, representa un usuario en el sistema
     * @throws ErrorDeUsuarioException
     */
    public void registrarUsuario(EmpleadoPretenso nuevo) throws ErrorDeUsuarioException {
        for (int i = 0; i < empleadosPretensos.size(); i++) {
            if (empleadosPretensos.get(i).getNombreUsuario().equalsIgnoreCase(nuevo.getNombreUsuario()))
                throw new ErrorDeUsuarioException("El nombre de usuario ingresado ya existe.");
        }
        agregaEmpleadoPretenso(nuevo);
    }

    /**
     * Loguea un usuario registrado en el sistema.
     * <b>Pre: </b> nombreUsuario y contrasena deben ser distinto de null o vacio <br>
     * <b>Post: </b> el usuario se loguea con exito y se pasa la referencia a la ventana correspondiente, en caso contrario se lanza una excepcion<br>
     * @param nombreUsuario: de tipo String, representa el nombre que tendra el usuario en el sistema
     * @param contrasena: de tipo String, representa la contrasena que tendra el usuario en el sistema
     * @throws ErrorDeContrasenaException
     * @throws ErrorDeUsuarioException
     */
    public Usuario login(String nombreUsuario, String contrasena) throws ErrorDeContrasenaException, ErrorDeUsuarioException {
        int i = 0;

        if (agencia != null)
            if (nombreUsuario.equalsIgnoreCase(agencia.getNombreUsuario()) && contrasena.equalsIgnoreCase(agencia.getContrasena()))
                return agencia;


        while (i < empleadores.size()) {
            if (empleadores.get(i).getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                if (empleadores.get(i).getContrasena().equalsIgnoreCase(contrasena)) {
                    return empleadores.get(i);
                } else
                    throw new ErrorDeContrasenaException("La contrasena ingresada es incorrecta.");
            else
                i++;
        }

        i = 0;
        while (i < empleadosPretensos.size()) {
            if (empleadosPretensos.get(i).getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                if (empleadosPretensos.get(i).getContrasena().equalsIgnoreCase(contrasena)) {
                    return empleadosPretensos.get(i);
                } else
                    throw new ErrorDeContrasenaException("La contrasena ingresada es incorrecta.");
            else
                i++;
        }

        throw new ErrorDeUsuarioException("El usuario ingresado es incorrecto.");
    }

    /**
     * Metodo ronda de encuentros laborales
     * Para cada ticket dentro del hashmap ticketDeEmpleadores, generamos una clase lista que tendra un tree set
     * de tickets de empleados ordenadas segun el puntaje obtenido y tambien tendra a ese mismo ticket como parametro.
     * La clase lista generada sera almacenada dentro de listasEncuentroLaborales.
     * Para los tickets de empleados se hara lo mismo , pero su lista estara compuesta de tickets de empleadores.
     *
     * <b>post:</b> listaEncuentrosLaborales se encuentra cargada para la ronda de Contrataciones. <br>
     *
     */
    public void rondaEncuentrosLaborales() {
        double puntaje;
        
        for(Ticket_de_Busqueda_de_Empleado ticketEmpleador:ticketsDeEmpleadores.keySet()){
            Lista nuevalista = new Lista();
            for ( Ticket_de_Busqueda_de_Empleo ticketEmpleado: ticketsDeEmpleadosPretensos.keySet()){
                puntaje = ticketEmpleador.puntajeTotal(ticketEmpleado);
                ticketEmpleado.setPuntajeTotal(puntaje);
                if (ticketEmpleador.getTipoDeTrabajo().equalsIgnoreCase(ticketEmpleado.getTipoDeTrabajo())){
                    nuevalista.getOfertas().add(ticketEmpleado);
                }

            }
            Ticket ultimoTicketEmpleado = nuevalista.getOfertas().last();
            Ticket primerTicketEmpleado = nuevalista.getOfertas().first();
            ticketsDeEmpleadosPretensos.get(ultimoTicketEmpleado).setPuntaje(ticketsDeEmpleadosPretensos.get(ultimoTicketEmpleado).getPuntaje()+ 5);
            ticketsDeEmpleadosPretensos.get(primerTicketEmpleado).setPuntaje(ticketsDeEmpleadosPretensos.get(primerTicketEmpleado).getPuntaje() - 5);

            listas.put(ticketEmpleador,nuevalista);
        }

        for(Ticket_de_Busqueda_de_Empleo ticketEmpleado:ticketsDeEmpleadosPretensos.keySet()){
            Lista nuevalista = new Lista();
            for(Ticket_de_Busqueda_de_Empleado ticketEmpleador:ticketsDeEmpleadores.keySet()){
                puntaje = ticketEmpleador.puntajeTotal(ticketEmpleado);
                ticketEmpleador.setPuntajeTotal(puntaje);
                if (ticketEmpleador.getTipoDeTrabajo().equalsIgnoreCase(ticketEmpleado.getTipoDeTrabajo())){
                    nuevalista.getOfertas().add(ticketEmpleador);
                }
            }
            Ticket ultimoTicketEmpresa = nuevalista.getOfertas().last(); // EN REALIDAD ES TICKET DE UNA EMPRESA
            ticketsDeEmpleadores.get(ultimoTicketEmpresa).setPuntaje(ticketsDeEmpleadores.get(ultimoTicketEmpresa).getPuntaje() + 10);
            listas.put(ticketEmpleado,nuevalista);
        }
    }

    /**
     * Metodo Ronda Contrataciones
     * Recorre todos los Tickets de busqueda de Empleo, generados por los Empleados Pretensos, y verifica
     * que la eleccion de ese Ticket coincida con la elección del tickets Elegido. De ser así, genera un
     * nuevo contrato entre ambas partes, suma los puntajes a cada uno de los usuarios y cambia el
     * estado de ambos tickets a finalizado.<br>
     *
     * Ademas, genera un HashMap, el cual se modificará y utilizará para verificar cuales de los
     * Empleadores no fueron elegidos, para, de ser así, restar puntos de usuario.
     *
     * <b>pre:</b> lista de empleadores inicializada (!= null). Lista de Contratos inicializada (!=null)
     * Lista de Tickets de Empleados Pretensos y de Empleadores inicializada (!=null).<br>
     * <b>post:</b> Se ha verificado la existencia de coincidencias de elecciones entre Empleados
     * Pretensos y Empleadores <br>
     * @throws EstadoException 
     */
    public void rondaContrataciones() throws EstadoException {
        HashMap <Empleador,Boolean> elegidos = empleadosElegidos();
        for (Ticket_de_Busqueda_de_Empleo clave:Sistema.getInstance().ticketsDeEmpleadosPretensos.keySet()) {
            if ((clave.getEstado().equalsIgnoreCase("Activo")) && (clave.getEleccion()!=null  && clave.getEleccion().getEstado().equalsIgnoreCase("Activo"))) {
                if (clave.getEleccion()!= null && clave == clave.getEleccion().getEleccion()) {
                    elegidos.replace(this.ticketsDeEmpleadores.get(clave.getEleccion()), true);
                    Contrato contrato = new Contrato(this.ticketsDeEmpleadores.get(clave.getEleccion()),this.ticketsDeEmpleadosPretensos.get(clave),clave.getEleccion().getRemuneracion());
                    this.contratos.add(contrato);
                    clave.setEstado("Finalizado");
                    clave.finalizar();
                    clave.getEleccion().setEstado("Finalizado");
                    clave.getEleccion().finalizar();
                    this.ticketsDeEmpleadores.get(clave.getEleccion()).setPuntaje(this.ticketsDeEmpleadores.get(clave.getEleccion()).getPuntaje()+50);
                    this.ticketsDeEmpleadosPretensos.get(clave).setPuntaje(this.ticketsDeEmpleadosPretensos.get(clave).getPuntaje()+10);
                }
            }
        }

        for (Empleador clave:elegidos.keySet())
            if (!elegidos.get(clave))
                clave.setPuntaje(clave.getPuntaje()-20);
    }

    /**
     * Este Metodo inicializa un hashMap con todos los Empleadores con tickets activos como llave
     * y asigna falso a todos los valores.<br>
     * <b>pre:</b> lista de empleadores inicializada (!= null).<br>
     * <b>post:</b> se ha inicializado HashMap. <br>
     *
     * @return HashMap <Empleador,Boolean>
     */
    private HashMap<Empleador,Boolean> empleadosElegidos() {
        HashMap <Empleador,Boolean> elegidos = new HashMap<>();
        if (this.getEmpleadores().size() != 0) {
            for (int i = 0;i < this.getEmpleadores().size();i++)
                if (tieneTicketsActivos(this.getEmpleadores().get(i)))
                    elegidos.put(this.getEmpleadores().get(i),false);
        }
        return elegidos;
    }

    /**
     * Este Metodo verifica que el empleador tenga tickets en estado activo.<br>
     * <b>pre:</b> lista de empleadores inicializada (!= null).<br>
     * <b>post:</b> se ha verificado la existencia de tickets activos para el empleador.<br>
     *
     * @param empleador Es la referencia a un Empleador. empleador != null
     * @return valor booleano
     */
    private boolean tieneTicketsActivos (Empleador empleador) {
        boolean respuesta = false;
        int cont = 0;
        if (empleador.getTicketsDeBusquedaDeEmpleado() != null) {
            while (cont<empleador.getTicketsDeBusquedaDeEmpleado().size() && !respuesta) {
                if (empleador.getTicketsDeBusquedaDeEmpleado().get(cont).getEstado().equalsIgnoreCase("Activo"))
                    respuesta = true;
                cont++;
            }
        }
        return respuesta;
    }
}
