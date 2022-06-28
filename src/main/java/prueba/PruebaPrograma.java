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
        } catch (EstadoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Se ha creado un archivo binario nuevo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            IPersistencia binPuntajes = new PersistenciaBIN();
            binPuntajes.abrirInput("Puntajes.bin");
            PuntajesDTO puntajesDTO = (PuntajesDTO) binPuntajes.leer();
            System.out.println(puntajesDTO.toString());
            Util.puntajeFromPuntajeDTO(puntajesDTO);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Se ha creado un archivo binario nuevo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int [] peso1 = new int[7]; peso1[0]=0; peso1[1]=2; peso1[2]=2; peso1[3]=1; peso1[4]=1; peso1[5]=1; peso1[6]=3;
        int [] peso2 = new int[7]; peso2[0]=1; peso2[1]=3; peso2[2]=3; peso2[3]=2; peso2[4]=2; peso2[5]=1; peso2[6]=1;
        int [] peso3 = new int[7]; peso3[0]=3; peso3[1]=2; peso3[2]=2; peso3[3]=3; peso3[4]=1; peso3[5]=2; peso3[6]=1;
        int [] peso4 = new int[7]; peso4[0]=3; peso4[1]=3; peso4[2]=2; peso4[3]=2; peso4[4]=2; peso4[5]=2; peso4[6]=2;
        int [] peso5 = new int[7]; peso5[0]=2; peso5[1]=3; peso5[2]=1; peso5[3]=1; peso5[4]=2; peso5[5]=3; peso5[6]=3;

        Sistema.getInstance().getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(0).setPesoAspectos(peso1);
        Sistema.getInstance().getTicketsDeEmpleadores().remove(Sistema.getInstance().getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(0));
        Sistema.getInstance().getTicketsDeEmpleadores().put(Sistema.getInstance().getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(0),Sistema.getInstance().getEmpleadores().get(0));

        Sistema.getInstance().getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(1).setPesoAspectos(peso2);
        Sistema.getInstance().getTicketsDeEmpleadores().remove(Sistema.getInstance().getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(1));
        Sistema.getInstance().getTicketsDeEmpleadores().put(Sistema.getInstance().getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(1),Sistema.getInstance().getEmpleadores().get(0));

        Sistema.getInstance().getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(2).setPesoAspectos(peso3);
        Sistema.getInstance().getTicketsDeEmpleadores().remove(Sistema.getInstance().getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(2));
        Sistema.getInstance().getTicketsDeEmpleadores().put(Sistema.getInstance().getEmpleadores().get(0).getTicketsDeBusquedaDeEmpleado().get(2),Sistema.getInstance().getEmpleadores().get(0));

        Sistema.getInstance().getEmpleadores().get(1).getTicketsDeBusquedaDeEmpleado().get(0).setPesoAspectos(peso4);
        Sistema.getInstance().getTicketsDeEmpleadores().remove(Sistema.getInstance().getEmpleadores().get(1).getTicketsDeBusquedaDeEmpleado().get(0));
        Sistema.getInstance().getTicketsDeEmpleadores().put(Sistema.getInstance().getEmpleadores().get(1).getTicketsDeBusquedaDeEmpleado().get(0),Sistema.getInstance().getEmpleadores().get(1));

        Sistema.getInstance().getEmpleadores().get(2).getTicketsDeBusquedaDeEmpleado().get(0).setPesoAspectos(peso2);
        Sistema.getInstance().getTicketsDeEmpleadores().remove(Sistema.getInstance().getEmpleadores().get(2).getTicketsDeBusquedaDeEmpleado().get(0));
        Sistema.getInstance().getTicketsDeEmpleadores().put(Sistema.getInstance().getEmpleadores().get(2).getTicketsDeBusquedaDeEmpleado().get(0),Sistema.getInstance().getEmpleadores().get(2));

        //INICIO EL PROGRAMA
        Sistema.getInstance().setAgencia(new Agencia("Guille","123"));
        VentanaLogin ventanaLogin = new VentanaLogin();
        ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
        ventanaLogin.ejecutar();
    }
}
