package prueba;

import excepciones.DatosMalIngresadosException;
import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import interfaces.ILocacion;
import modelo.tickets.Formulario_de_Busqueda;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.tickets.Locaciones.LocacionFactory;
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
            
        System.out.println("SE CREAN LAS LOCACIONES DE LOS TRABAJOS ");
        
        LocacionFactory lc = new LocacionFactory();
        
        ILocacion home = lc.getLocacion("HOMEOFFICE");
        ILocacion presencial = lc.getLocacion("PRESENCIAL");
        ILocacion indistinto = lc.getLocacion("INDISTINTO");

        System.out.println("SE CREAN FORMULARIOS DE BUSQUEDA DE LOS EMPLEADOS ");
        
        // Remuneracion, cargaHoraria, TipoPuesto [0,1,2],Rango Etario, ExperienciaPrevia [0,1,2], estudiosCursados [0,1,2]
        Formulario_de_Busqueda fbt1 = new Formulario_de_Busqueda(indistinto,90000,6,0,40,2,2);
        Formulario_de_Busqueda fbt2 = new Formulario_de_Busqueda(presencial,10000,8,0,25,1,0);
        Formulario_de_Busqueda fbt3 = new Formulario_de_Busqueda(presencial,15000,5,2,32,0,1);
        Formulario_de_Busqueda fbt4 = new Formulario_de_Busqueda(indistinto,12000,8,1,25,0,2);
        Formulario_de_Busqueda fbt5 = new Formulario_de_Busqueda(home,20000,8,1,50,1,2);

        System.out.println("SE CREAN LOS TICKETS DE BUSQUEDA DE EMPLEOS ");

        sistema.getEmpleadosPretensos().get(0).creaTicket(fbt1, "Bombero");
        sistema.getEmpleadosPretensos().get(1).creaTicket(fbt2, "Camarero");
        sistema.getEmpleadosPretensos().get(2).creaTicket(fbt3, "Camarero");
        sistema.getEmpleadosPretensos().get(3).creaTicket(fbt4, "Bombero");
        sistema.getEmpleadosPretensos().get(4).creaTicket(fbt5, "Taxista");

        System.out.println("SE CREAN FORMULARIOS DE BUSQUEDA DE LOS EMPLEADORES ");

        Formulario_de_Busqueda fbe1 = new Formulario_de_Busqueda(indistinto,200000,8,0,30,1,2);
        Formulario_de_Busqueda fbe2 = new Formulario_de_Busqueda(home,1200000,8,2,20,2,2);
        Formulario_de_Busqueda fbe3 = new Formulario_de_Busqueda(presencial,85000,4,1,60,1,1);
        Formulario_de_Busqueda fbe4 = new Formulario_de_Busqueda(indistinto,50000,4,1,40,0,0);
        Formulario_de_Busqueda fbe5 = new Formulario_de_Busqueda(presencial,150000,8,2,25,1,1);

        System.out.println("CADA EMPLEADOR CARGA SU TABLA DE PESOS ");

        int [] peso1 = new int[7]; peso1[0]=0;peso1[1]=2;peso1[2]=2;peso1[3]=1;peso1[4]=1;peso1[5]=1;peso1[6]=3;
        int [] peso2 = new int[7]; peso2[0]=1;peso2[1]=3;peso2[2]=3;peso2[3]=2;peso2[4]=2;peso2[5]=1;peso2[6]=1;
        int [] peso3 = new int[7]; peso3[0]=3;peso3[1]=2;peso3[2]=2;peso3[3]=3;peso3[4]=1;peso3[5]=2;peso3[6]=1;
        int [] peso4 = new int[7]; peso4[0]=3;peso4[1]=3;peso4[2]=2;peso4[3]=2;peso4[4]=2;peso4[5]=2;peso4[6]=2;
        int [] peso5 = new int[7]; peso5[0]=2;peso5[1]=3;peso5[2]=1;peso5[3]=1;peso5[4]=2;peso5[5]=3;peso5[6]=3;

        Ticket_de_Busqueda_de_Empleado tbe = new Ticket_de_Busqueda_de_Empleado(fbe1,"Bombero",peso1);

        System.out.println("SE CREAN LOS TICKETS DE BUSQUETA DE EMPLEADO ");

        sistema.getEmpleadores().get(0).creaTicket(fbe1,"Bombero",peso1);
        sistema.getEmpleadores().get(1).creaTicket(fbe2,"Taxista",peso2);
        sistema.getEmpleadores().get(2).creaTicket(fbe3,"Camarero",peso3);
        sistema.getEmpleadores().get(3).creaTicket(fbe4,"Taxista",peso4);
        sistema.getEmpleadores().get(4).creaTicket(fbe5,"Bombero",peso5);
        

        System.out.println(" RONDA DE ELECCIONES ");
        
        System.out.println(" ELECCIONES DE LOS EMPLEADOS PRETENSOS");
        
        System.out.println(" El empleado0 elige al ticket0 del empleador1");
        sistema.getEmpleadosPretensos().get(0).getTicketDeBusquedaDeEmpleo().setEleccion(sistema.getEmpleadores().get(1).getTicketsDeBusquedaDeEmpleado().get(0));
        
        System.out.println(" El empleado1 elige al ticket0 del empleador1");
        sistema.getEmpleadosPretensos().get(1).getTicketDeBusquedaDeEmpleo().setEleccion(sistema.getEmpleadores().get(1).getTicketsDeBusquedaDeEmpleado().get(0));
        
        System.out.println(" El empleado2 elige al ticket0 del empleador0");
        sistema.getEmpleadosPretensos().get(2).getTicketDeBusquedaDeEmpleo().setEleccion(sistema.getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(0));
        
        System.out.println(" El empleado3 elige al ticket0 del empleador4");
        sistema.getEmpleadosPretensos().get(3).getTicketDeBusquedaDeEmpleo().setEleccion(sistema.getEmpleadores().get(4).getTicketsDeBusquedaDeEmpleado().get(0));
        
        System.out.println(" El empleado4 elige al ticket0 del empleador1");
        sistema.getEmpleadosPretensos().get(4).getTicketDeBusquedaDeEmpleo().setEleccion(sistema.getEmpleadores().get(1).getTicketsDeBusquedaDeEmpleado().get(0));
        
        System.out.println(" ELECCIONES DE LOS EMPlADORES");
        
        System.out.println(" El empleador0 (su ticket0) elige al empleado4");
        sistema.getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(0).setEleccion(sistema.getEmpleadosPretensos().get(4).getTicketDeBusquedaDeEmpleo());
        
        System.out.println(" El empleador1 (su ticket0) elige al empleado4");
        sistema.getEmpleadores().get(1).getTicketsDeBusquedaDeEmpleado().get(0).setEleccion(sistema.getEmpleadosPretensos().get(4).getTicketDeBusquedaDeEmpleo());

        System.out.println(" El empleador2 (su ticket0) elige al empleado0");
        sistema.getEmpleadores().get(2).getTicketsDeBusquedaDeEmpleado().get(0).setEleccion(sistema.getEmpleadosPretensos().get(0).getTicketDeBusquedaDeEmpleo());
        
        System.out.println(" El empleado3 (su ticket0) elige al empleado4");
        sistema.getEmpleadores().get(3).getTicketsDeBusquedaDeEmpleado().get(0).setEleccion(sistema.getEmpleadosPretensos().get(1).getTicketDeBusquedaDeEmpleo());
    
        System.out.println(" El empleado4 NO elige a ningun empleado pretenso");
        
        sistema.rondaContrataciones();
        
        System.out.println(" CONTRATOS");
        for (int a = 0; a< sistema.getContratos().size() ;a++) {
        	System.out.println("CONTRATO "+(a+1));
        	System.out.println("EMPLEADOR "+ sistema.getContratos().get(a).getEmpleador());
        	System.out.println("EMPLEADO PRETENSO "+ sistema.getContratos().get(a).getEmpleado_pretenso());
        	System.out.println("REMUNERACION "+ sistema.getContratos().get(a).getRemuneracion());
        }
    }
}
