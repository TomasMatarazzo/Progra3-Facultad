package prueba;

import excepciones.DatosMalIngresadosException;
import excepciones.ErrorDeUsuarioException;
import modelo.Tickets.Formulario_de_Busqueda;
import modelo.Usuarios.Agencia;
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

    }
}
