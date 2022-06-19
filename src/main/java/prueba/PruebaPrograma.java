package prueba;

import controladores.ControladorLogin;
import modelo.Sistema;
import modelo.usuarios.Agencia;
import vista.VentanaLogin;

public class PruebaPrograma {
    public static void main(String[] args) {
        Sistema.getInstance().setAgencia(new Agencia("Guille","<3"));
        VentanaLogin ventanaLogin = new VentanaLogin();
        ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
        ventanaLogin.ejecutar();
    }
}
