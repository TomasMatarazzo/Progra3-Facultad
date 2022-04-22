package prueba;

import modelo.Empleado_Pretenso;
import modelo.Empleador;
import modelo.Sistema;
import modelo.Usuario;

public class Prueba {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();

        Usuario u1 = new Empleado_Pretenso("Mario","Bros");

        sistema.registrarUsuario(u1);
        sistema.registrarUsuario(new Empleador("pepito", "pescador"));


    }
}
