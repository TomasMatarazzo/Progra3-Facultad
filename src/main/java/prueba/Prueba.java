package prueba;

import excepciones.DatosMalIngresadosException;
import excepciones.ErrorDeUsuarioException;
import modelo.Tickets.Formulario_de_Busqueda;
import modelo.Usuarios.Agencia;
import modelo.Tickets.Ticket;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.Tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.Usuarios.Empleado_Pretenso;
import modelo.Usuarios.Empleador;
import modelo.Sistema;

public class Prueba {
    public static void main(String[] args) throws DatosMalIngresadosException, ErrorDeUsuarioException {
        Sistema sistema = Sistema.getInstance();
        Agencia agencia = Agencia.getInstance();

        Empleado_Pretenso u1 = new Empleado_Pretenso("Mario","Bros123");

        //POR CONVENCION AGENCIA ES EL PRIMER USUARIO
        sistema.registrarUsuario(agencia);
        sistema.registrarUsuario(u1);
        sistema.registrarUsuario(new Empleador("pepito", "xxxxxxx"));

        Formulario_de_Busqueda f1 = new Formulario_de_Busqueda("Presencial",1000,"Completa","Junior","mas de 50","Mucha","Terciario");
        Formulario_de_Busqueda form1 = new Formulario_de_Busqueda(1,40000,0,0,2,3,3);
        Formulario_de_Busqueda form2= new Formulario_de_Busqueda(1,40000,1,1,1,3,3);
        Formulario_de_Busqueda form3= new Formulario_de_Busqueda(1,40000,2,2,2,0,0);

        int [] array = {1,0,1,1,1,0,0};


       Ticket ticket1 = new Ticket_de_Busqueda_de_Empleado(form1, new GregorianCalendar(),1,array);
       Ticket ticket2 = new Ticket_de_Busqueda_de_Empleo(form2, new GregorianCalendar(), array,"Nashe");
       Ticket ticket3 = new Ticket_de_Busqueda_de_Empleo(form3, new GregorianCalendar(),array,"Nashe2");

        System.out.printf("\n" + ticket1.puntajeTotal(ticket2));
        System.out.printf("\n" + ticket1.puntajeTotal(ticket3));

    }
}
