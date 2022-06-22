package prueba;

import controladores.ControladorLogin;
import modelo.Sistema;
import modelo.excepciones.EstadoException;
import modelo.usuarios.Agencia;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.Util;
import vista.VentanaLogin;
import java.io.IOException;

public class PruebaPrograma {
    public static void main(String[] args) {
        //CARGO EL SISTEMA CON LOS ARCHIVOS BINARIOS
        try {
            IPersistencia bin = new PersistenciaBIN();
            bin.abrirInput("Sistema.bin");
            SistemaDTO sistemaDTO = (SistemaDTO) bin.leer();
            Util.sistemaFromSistemaDTO(sistemaDTO);
        } catch (EstadoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("no exite archivos previos");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //INICIO EL PROGRAMA
        Sistema.getInstance().setAgencia(new Agencia("Guille","<3"));
        VentanaLogin ventanaLogin = new VentanaLogin();
        ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
        ventanaLogin.ejecutar();
    }
}
