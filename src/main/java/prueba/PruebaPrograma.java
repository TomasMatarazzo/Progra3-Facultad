package prueba;

import controladores.ControladorLogin;
import modelo.Sistema;
import modelo.excepciones.EstadoException;
import modelo.usuarios.Agencia;
import persistencia.*;
import vista.VentanaLogin;
import javax.swing.*;
import java.io.IOException;

public class PruebaPrograma {
    public static void main(String[] args) {
        //CARGO EL SISTEMA CON LOS ARCHIVOS BINARIOS
        try {
            IPersistencia bin = new PersistenciaBIN();
            bin.abrirInput("Sistema.bin");
            SistemaDTO sistemaDTO = (SistemaDTO) bin.leer();
            Util.sistemaFromSistemaDTO(sistemaDTO);
            IPersistencia binPuntajes = new PersistenciaBIN();
            binPuntajes.abrirInput("Puntajes.bin");
            PuntajesDTO puntajesDTO = (PuntajesDTO) binPuntajes.leer();
            Util.puntajeFromPuntajeDTO(puntajesDTO);
        } catch (EstadoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Se ha creado un archivo binario nuevo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //INICIO EL PROGRAMA
        Sistema.getInstance().setAgencia(new Agencia("Guille","123"));
        VentanaLogin ventanaLogin = new VentanaLogin();
        ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
        ventanaLogin.ejecutar();
    }
}
