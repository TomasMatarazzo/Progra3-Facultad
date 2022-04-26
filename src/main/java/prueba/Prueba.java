package prueba;

import modelo.Tickets.Formulario_de_Busqueda;
import modelo.Usuarios.Eleccion;
import modelo.Usuarios.Empleado_Pretenso;
import modelo.Usuarios.Empleadores.Empleador;
import modelo.Sistema;

import java.util.GregorianCalendar;

public class Prueba {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();

        Empleado_Pretenso u1 = new Empleado_Pretenso("Mario","123456789");

        sistema.registrarUsuario(u1);
        //sistema.registrarUsuario(new Empleador("pepito", "xxxxxxx"));

        
        
        
        //Formulario_de_Busqueda f1 = new Formulario_de_Busqueda("Presencial","hasta V1","Completa","Junior","mas de 50","Mucha","Terciario");

        
    }
}
