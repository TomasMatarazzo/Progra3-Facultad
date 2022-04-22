package prueba;

import modelo.Usuarios.Empleado_Pretenso;
import modelo.Usuarios.Empleadores.Empleador;
import modelo.Sistema;
import modelo.Usuarios.Usuario;

public class Prueba {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();

        Usuario u1 = new Empleado_Pretenso("Mario","Bros");

        sistema.registrarUsuario(u1);
        sistema.registrarUsuario(new Empleador("pepito", "pescador"));


    }
}
