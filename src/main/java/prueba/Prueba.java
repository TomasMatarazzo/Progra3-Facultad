package prueba;
import modelo.Tickets.Decorators.TicketHomeOfficeDecorator;
import modelo.Tickets.Decorators.TicketPresencialDecorator;
import modelo.Tickets.Formulario_de_Busqueda;
import modelo.Tickets.Ticket;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.Usuarios.Empleado_Pretenso;
import modelo.Usuarios.Empleadores.Empleador;
import modelo.Sistema;

import java.util.GregorianCalendar;

public class Prueba {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();

        Empleado_Pretenso u1 = new Empleado_Pretenso("Mario","123456789");

        sistema.registrarUsuario(u1);
        sistema.registrarUsuario(new Empleador("pepito", "xxxxxxx"));

        Formulario_de_Busqueda form1 = new Formulario_de_Busqueda(1,40000,0,0,2,3,3);
        Formulario_de_Busqueda form2= new Formulario_de_Busqueda(1,40000,1,1,1,3,3);
        Formulario_de_Busqueda form3= new Formulario_de_Busqueda(1,40000,2,2,2,0,0);

        int [] array = {1,0,1,1,1,0,0};


       Ticket ticket1 = new Ticket_de_Busqueda_de_Empleado(form1, new GregorianCalendar(),1,array);
       Ticket ticket2 = new Ticket_de_Busqueda_de_Empleo(form2, new GregorianCalendar(), array,"Nashe");
       Ticket ticket3 = new Ticket_de_Busqueda_de_Empleo(form3, new GregorianCalendar(),array,"Nashe2");


        //ticket2 = new TicketHomeOfficeDecorator(ticket2);
        //ticket3 = new TicketPresencialDecorator(ticket3);
        System.out.printf("\n" + ticket1.puntajeTotal(ticket2));
        System.out.printf("\n" + ticket1.puntajeTotal(ticket3));

    }
}
