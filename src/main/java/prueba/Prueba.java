package prueba;

import excepciones.DatosMalIngresadosException;
import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import modelo.usuarios.*;
import modelo.Sistema;

public class Prueba {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        Agencia agencia = Agencia.getInstance("bla","bla");
        UsuarioFactory usuarioFactory = new UsuarioFactory();
        Usuario u0 = null;
        Usuario u1 = null;
        Usuario u2 = null;
        Usuario u3 = null;
        Usuario u4 = null;
        Usuario u5 = null;

        try {
            u0 = usuarioFactory.crearUsuario("Administrador","Guille<3","Agencia");
            u1 = usuarioFactory.crearUsuario("Empleado01","123","Empleado Pretenso");
            u2 = usuarioFactory.crearUsuario("EmpleadorJuridico1","456","Persona Juridica");
            u3 = usuarioFactory.crearUsuario("EmpleadorFisico1","789","Persona Fisica");
            u4 = usuarioFactory.crearUsuario("EmpleadorJuridico2","101","Persona Juridica");
            u5 = usuarioFactory.crearUsuario("EmpleadorFisico2","112","Persona Fisica");
        }
        catch (DatosMalIngresadosException e1) {
            System.out.println("El parametro '" + e1.getMessage() + "' ingresado es incorrecto.");
        }

        try {
            //POR CONVENCION AGENCIA ES EL PRIMER USUARIO
            sistema.registrarUsuario(u0);
            sistema.registrarUsuario(u1);
            sistema.registrarUsuario(u2);
            sistema.registrarUsuario(u3);
            sistema.registrarUsuario(u4);
            sistema.registrarUsuario(u5);
        }
        catch (ErrorDeUsuarioException e1) {
            System.out.println(e1.getMessage());
        }

        try {
            sistema.login("Empleado01","123"); //Usuario correcto
            sistema.login("Incorrecto","123"); //Usuario incorrecta
//            sistema.login("EmpleadorFisico1","xxxxxxx"); //Contrasena incorrecta
        }
        catch (ErrorDeContrasenaException e2) {
            System.out.println(e2.getMessage());
        }
        catch (ErrorDeUsuarioException e1) {
            System.out.println(e1.getMessage());
        }

        agencia.muestraEmpleadores();
        agencia.muestraSolicitudesEmpleadores();
        agencia.muestraEmpleadosPretensos();
        agencia.muestraSolicitudEmpleadosPretensos();
    }
}
