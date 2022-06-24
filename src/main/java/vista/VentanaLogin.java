package vista;

import controladores.ControladorAgencia;
import controladores.ControladorEmpleador;
import controladores.ControladorEmpleados;
import controladores.ControladorRegister;
import modelo.excepciones.EstadoException;
import modelo.usuarios.Agencia;
import modelo.usuarios.EmpleadoPretenso;
import modelo.usuarios.Usuario;
import modelo.usuarios.UsuarioFactoryExtendida;
import modelo.usuarios.empleadores.Empleador;
import simulacion.SimulacionThreads;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

public class VentanaLogin extends JFrame implements IVistaLogin, KeyListener, Observer {
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    private JPanel panelInferior;
    private JPanel PanelDatos;
    private JTextField textoNombreUsuario;
    private JButton botonRegistrarse;
    private JButton botonLogin;
    private JPanel panelRegistrarse;
    private JPanel panelLogin;
    private JPasswordField textoContrasena;
    private JLabel labelNombreUsuario;
    private JLabel labelContrasena;
    private JLabel labelTitulo;
    private JButton botonSimulacion;
    private JPanel panelSuperior;
    private JLabel labelTituloPrincipal;
    private Usuario observado;

    @Override
    public void setActionListener(ActionListener controlador) {
        this.botonLogin.addActionListener(controlador);
        this.botonRegistrarse.addActionListener(controlador);
        this.botonSimulacion.addActionListener(controlador);
    }

    @Override
    public void setKeyListener() {
        this.textoNombreUsuario.addKeyListener(this);
        this.textoContrasena.addKeyListener(this);
    }

    @Override
    public void setWindowListener(WindowListener controlador) {
        this.addWindowListener(controlador);
    }

    @Override
    public void setObservado(Usuario usuario) {
        this.observado = usuario;
        usuario.addObserver(this);
    }

    @Override
    public void ejecutar() {
        setTitle("My Linkedn - Grupo 10");
        pack(); //Coloca los componentes
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setLocationRelativeTo(null);
        botonLogin.setEnabled(false);
    }

    @Override
    public void cerrarVentana() {
        setVisible(false); //Oculto la ventana
        dispose(); //Cierro la ventana
    }

    @Override
    public void creaOtraVentana(String ventana) {
        switch (ventana) {
            case "Register":
                UsuarioFactoryExtendida modelo = new UsuarioFactoryExtendida();
                VentanaRegister vista = new VentanaRegister();
                ControladorRegister controladorRegister = new ControladorRegister(vista,modelo);
                vista.ejecutar();
                break;
            case "Empleado Pretenso":
                EmpleadoPretenso empleado = (EmpleadoPretenso) observado;
                VentanaEmpleado ventanaEmpleado = new VentanaEmpleado(empleado);
                ControladorEmpleados controladorEmpleados = new ControladorEmpleados(ventanaEmpleado,empleado);
                ventanaEmpleado.ejecutar();
                break;
            case "Empleador":
                Empleador empleador = (Empleador) observado;
                VentanaEmpleador ventanaEmpleador = new VentanaEmpleador(empleador);
                ControladorEmpleador controladorEmpleador = new ControladorEmpleador(ventanaEmpleador,empleador);
                ventanaEmpleador.ejecutar();
                break;
            case "Agencia":
                Agencia agencia = (Agencia) observado;
                VentanaAgencia ventanaAgencia = new VentanaAgencia();
                ControladorAgencia controladorAgencia = new ControladorAgencia(ventanaAgencia,agencia);
                ventanaAgencia.ejecutar();
                break;
            case "Simulacion":
                try {
                    SimulacionThreads.main();
                } catch (EstadoException e) {
                    e.printStackTrace();
                }
                break;
        }
        this.cerrarVentana();
    }

    @Override
    public void lanzarVentanaEmergente(String mensaje) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, mensaje);
    }

    @Override
    public String getNombreUsuario() {
        return textoNombreUsuario.getText();
    }

    @Override
    public String getContrasena() {
        return textoContrasena.getText();
    }

    @Override
    public void nombreUsuarioInvalido() {
        textoNombreUsuario.setText("");
        textoContrasena.setText("");
        botonLogin.setEnabled(false);
    }

    @Override
    public void contrasenaInvalida() {
        textoContrasena.setText("");
        botonLogin.setEnabled(false);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (textoNombreUsuario.getText().isEmpty() || textoContrasena.getText().isEmpty()) {
            botonLogin.setEnabled(false);
        } else {
            botonLogin.setEnabled(true);
        }
    }

    @Override
    public void update(Observable usuario, Object arg) {

        if (usuario != observado)
            throw new IllegalArgumentException();
        else {
            String tipoUsuario = (String) arg;
            creaOtraVentana(tipoUsuario);
        }
    }

    //METODOS NO USADOS
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
