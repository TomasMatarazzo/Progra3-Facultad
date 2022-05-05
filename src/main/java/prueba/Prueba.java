package prueba;

import excepciones.DatosMalIngresadosException;
import excepciones.ErrorDeContrasenaException;
import excepciones.ErrorDeUsuarioException;
import modelo.usuarios.*;
import modelo.Sistema;

public class Prueba {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        UsuarioFactory usuarioFactory = new UsuarioFactory();
        Usuario u0 = null;
        Usuario u1 = null;
        Usuario u2 = null;
        Usuario u3 = null;
        Usuario u4 = null;
        Usuario u5 = null;

        try {
            usuarioFactory.creaUsuario("Administrador","Guille<3","Agencia");
            usuarioFactory.creaUsuario("Empleado01","123","Empleado Pretenso");
            usuarioFactory.creaUsuario("EmpleadorJuridico1","456","Persona Juridica");
            usuarioFactory.creaUsuario("EmpleadorFisico1","789","Persona Fisica");
            usuarioFactory.creaUsuario("EmpleadorJuridico2","101","Persona Juridica");
            usuarioFactory.creaUsuario("EmpleadorFisico2","112","Persona Fisica");
        }
        catch (DatosMalIngresadosException e1) {
            System.out.println("El parametro '" + e1.getMessage() + "' ingresado es incorrecto.");
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
    }
}
