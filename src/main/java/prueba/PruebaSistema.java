package prueba;

import modelo.excepciones.EstadoException;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.Util;

import java.io.IOException;

public class PruebaSistema {
    public static void main(String[] args) {
        try {
            System.out.println("llegue");
            IPersistencia bin = new PersistenciaBIN();
            bin.abrirInput("sistema.bin");
            SistemaDTO sistemaDTO = (SistemaDTO) bin.leer();
            Util.sistemaFromSistemaDTO(sistemaDTO);
            System.out.println("Clinica recuperada");
        }

         catch (EstadoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

