package prueba;

import excepciones.DatosMalIngresadosException;
import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.usuarios.*;
import modelo.Sistema;

public class Prueba {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        UsuarioFactory usuarioFactory = new UsuarioFactory();

        //SE CREAN Y SE REGISTRAN
        try {
            usuarioFactory.creaUsuario("Guillermo","Guille<3","Agencia");
            //--------------------------------------------------------------------------------------
            usuarioFactory.creaUsuario("Empleado01","111","Empleado Pretenso");
            usuarioFactory.creaUsuario("Empleado02","222","Empleado Pretenso");
            usuarioFactory.creaUsuario("Empleado03","333","Empleado Pretenso");
            usuarioFactory.creaUsuario("Empleado04","444","Empleado Pretenso");
            usuarioFactory.creaUsuario("Empleado05","555","Empleado Pretenso");
            usuarioFactory.creaUsuario("EmpleadorJuridico1","666","Persona Juridica");
            usuarioFactory.creaUsuario("EmpleadorFisico1","777","Persona Fisica");
            usuarioFactory.creaUsuario("EmpleadorJuridico2","888","Persona Juridica");
            usuarioFactory.creaUsuario("EmpleadorFisico2","999","Persona Fisica");
            usuarioFactory.creaUsuario("EmpleadorFisico3","101010","Persona Fisica");
        }
        catch (DatosMalIngresadosException e1) {
            System.out.println("El parametro '" + e1.getMessage() + "' ingresado es incorrecto.");
        }

        try {
            sistema.login("Empleado01","123"); //Usuario correcto
//            sistema.login("Incorrecto","123"); //Usuario incorrecta
            sistema.login("EmpleadorFisico1","xxxxxxx"); //Contrasena incorrecta
        }
        catch (ErrorDeContrasenaException e2) {
            System.out.println(e2.getMessage());
        }
        catch (ErrorDeUsuarioException e1) {
            System.out.println(e1.getMessage());
        }

        System.out.println("SE CREAN FORMULARIOS DE BUSQUEDA DE EMPLEOS ");

        // Remuneracion, cargaHoraria, TipoPuesto [0,1,2],Rango Etario 1, Rango Etario 2, ExperienciaPrevia [0,1,2], estudiosCursados [0,1,2]
        Formulario_de_Busqueda fbt1 = new Formulario_de_Busqueda(90000,6,0,20,40,2,2);
        Formulario_de_Busqueda fbt2 = new Formulario_de_Busqueda(10000,8,0,20,25,1,0);
        Formulario_de_Busqueda fbt3 = new Formulario_de_Busqueda(15000,5,2,25,32,0,1);
        Formulario_de_Busqueda fbt4 = new Formulario_de_Busqueda(12000,8,1,20,25,0,2);
        Formulario_de_Busqueda fbt5 = new Formulario_de_Busqueda(20000,8,1,50,60,1,2);

        System.out.println("SE CREAN LOS TICKETS DE BUSQUEDA DE EMPLEOS ");



        System.out.println("SE CARGAN LOS TICKETS DE BUSQUEDA DE EMPLEOS AL SISTEMA");



        System.out.println("SE CREAN FORMULARIOS DE BUSQUEDA DE LOS EMPLEADOS ");

        // Remuneracion, cargaHoraria, TipoPuesto [0,1,2],Rango Etario 1, Rango Etario 2, ExperienciaPrevia [0,1,2], estudiosCursados [0,1,2]
        Formulario_de_Busqueda fbt1 = new Formulario_de_Busqueda(90000,6,0,50,60,0,0);
        Formulario_de_Busqueda fbt2 = new Formulario_de_Busqueda(220000,8,1,40,50,2,0);
        Formulario_de_Busqueda fbt3 = new Formulario_de_Busqueda(180000,8,1,20,30,1,1);
        Formulario_de_Busqueda fbt4 = new Formulario_de_Busqueda(120000,6,2,30,40,1,1);
        Formulario_de_Busqueda fbt5 = new Formulario_de_Busqueda(80000,4,0,30,50,2,2);


        System.out.println("SE CREAN FORMULARIOS DE BUSQUEDA DE LOS EMPLEADORES ");

        Formulario_de_Busqueda fbe1 = new Formulario_de_Busqueda(200000,8,0,20,30,1,2);
        Formulario_de_Busqueda fbe2 = new Formulario_de_Busqueda(1200000,8,2,20,40,2,2);
        Formulario_de_Busqueda fbe3 = new Formulario_de_Busqueda(85000,4,1,40,60,1,1);
        Formulario_de_Busqueda fbe4 = new Formulario_de_Busqueda(50000,4,1,40,45,0,0);
        Formulario_de_Busqueda fbe5 = new Formulario_de_Busqueda(150000,8,2,20,25,1,1);

        System.out.println("CADA EMPLEADOR CARGA SU TABLA DE PESOS ");

        int [] peso1 = new int[7]; peso1[0]=0;peso1[1]=2;peso1[2]=2;peso1[3]=1;peso1[4]=1;peso1[5]=1;peso1[6]=3;
        int [] peso2 = new int[7]; peso2[0]=1;peso2[1]=3;peso2[2]=3;peso2[3]=2;peso2[4]=2;peso2[5]=1;peso2[6]=1;
        int [] peso3 = new int[7]; peso3[0]=3;peso3[1]=2;peso3[2]=2;peso3[3]=3;peso3[4]=1;peso3[5]=2;peso3[6]=1;
        int [] peso4 = new int[7]; peso4[0]=3;peso4[1]=3;peso4[2]=2;peso4[3]=2;peso4[4]=2;peso4[5]=2;peso4[6]=2;
        int [] peso5 = new int[7]; peso5[0]=2;peso5[1]=3;peso5[2]=1;peso5[3]=1;peso5[4]=2;peso5[5]=3;peso5[6]=3;


        System.out.println("SE CREAN LOS TICKETS DE BUSQUETA DE EMPLEADO ");

        sistema.getEmpleadores().get(0).creaTicket(fbt1,"Bombero",peso1);
        Ticket_de_Busqueda_de_Empleado te2 = new Ticket_de_Busqueda_de_Empleado(fbe2,"Camarero",peso2);
        Ticket_de_Busqueda_de_Empleado te3 = new Ticket_de_Busqueda_de_Empleado(fbe3,"Camarero",peso3);
        Ticket_de_Busqueda_de_Empleado te4 = new Ticket_de_Busqueda_de_Empleado(fbe4,"Bombero",peso4);
        Ticket_de_Busqueda_de_Empleado te5 = new Ticket_de_Busqueda_de_Empleado(fbe5,"Taxista",peso5);

        System.out.println("SE AGREGAN LOS TICKETS DE EMPLEADORES AL SISTEMA ");

        sistema.getTicketsDeEmpleadores().put(te1, empleador1);
        sistema.getTicketsDeEmpleadores().put(te2, empleador2);
        sistema.getTicketsDeEmpleadores().put(te3, empleador3);
        sistema.getTicketsDeEmpleadores().put(te4, empleador4);
        sistema.getTicketsDeEmpleadores().put(te5, empleador5);

        System.out.println("SE AGREGAN LOS TICKETS A CADA EMPLEADOR ");

        empleador1.ticketsDeBusquedaDeEmpleado.add(te1);
        empleador2.ticketsDeBusquedaDeEmpleado.add(te2);
        empleador3.ticketsDeBusquedaDeEmpleado.add(te3);
        empleador4.ticketsDeBusquedaDeEmpleado.add(te4);
        empleador5.ticketsDeBusquedaDeEmpleado.add(te5);
    }
}
