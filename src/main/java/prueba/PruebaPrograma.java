package prueba;

import controlador.ControladorEmpleados;
import controlador.ControladorLogin;
import modelo.Sistema;
import modelo.usuarios.Agencia;
import modelo.usuarios.Empleado_Pretenso;
import modelo.usuarios.Usuario;
import vista.VentanaEmpleado;
import vista.VentanaEmpleados;
import vista.VentanaLogin;

public class PruebaPrograma {
    public static void main(String[] args) {
            VentanaEmpleado vista = new VentanaEmpleado();
            ControladorEmpleados controlador = new ControladorEmpleados(vista);
            vista.arranca();
            vista.llenarDatosEmpleado("Juan", "Salinas", "juan@gmail.com", "2341234", 16);
//    	        Sistema.getInstance().setAgencia(new Agencia("Guille","<3"));
//    	        VentanaLogin ventanaLogin = new VentanaLogin();
//    	        ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
//    	        ventanaLogin.ejecutar();
    	    
    }
  }
