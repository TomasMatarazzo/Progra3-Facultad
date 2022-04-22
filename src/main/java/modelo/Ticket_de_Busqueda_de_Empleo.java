package modelo;

public class Ticket_de_Busqueda_de_Empleo extends Ticket{
    private String resultado; // exito-fracaso

    //CONSTRUCTOR
    public Ticket_de_Busqueda_de_Empleo(Formulario_de_Busqueda formularioDeBusqueda, String fechaDeAlta, String resultado) {
        super(formularioDeBusqueda, fechaDeAlta);
        this.resultado = resultado;
    }
}
