package modelo;

///GREGORIAN CALENDAR CON LA FECHA DE ALTA --> COMPLETAR
public abstract class Ticket {
    protected Formulario_de_Busqueda formularioDeBusqueda;
    protected String fechaDeAlta;
    protected String estado; // activo-suspendido-cancelado-finalizado

    //CONSTRUCTOR
    public Ticket(Formulario_de_Busqueda formularioDeBusqueda, String fechaDeAlta) {
        this.formularioDeBusqueda = formularioDeBusqueda;
        this.fechaDeAlta = fechaDeAlta;
        this.estado = "Activo";
    }

    //FUNCIONALIDADES
    public void altaTicket() {
        if (this.estado != "Cancelado") // Una vez cancelado no se puede volver a activar.
            this.estado = "Activo";
    }

    public void bajaTicket() {
        this.estado = "Cancelado";
    }

    public void modificaTicket() {
        //Un ticket deja de estar activo y pasa a suspendido (y viceversa) por decisión del propietario.
        this.estado = "Suspendido";
    }

    public void finalizaTicket() {
        this.estado = "Finalizado";
    }

}
