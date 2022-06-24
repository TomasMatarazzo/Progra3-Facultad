package vista;

import controladores.ControladorLogin;
import modelo.excepciones.DatosMalIngresadosException;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

public class VentanaRegister extends JFrame implements IVistaRegister, KeyListener {
    private JPanel panelPrincipal;
    private JPanel panelTipos;
    private JRadioButton empleadoRadioButton;
    private JRadioButton empleadorRadioButton;
    private JPanel panelDatos;
    private JPanel panelObligatorio;
    private JPanel panelOpcional;
    private JTextField textoNombreDeUsuario;
    private JTextField textoContrasena;
    private JPanel panelExtras;
    private JPanel panelRegister;
    private JButton botonRegistrarse;
    private JPanel panelDatosEmpleado;
    private JTextField textoNombre;
    private JTextField textoApellido;
    private JTextField textoTelefono;
    private JTextField textoEdad;
    private JTextField textoEMail;
    private JTextField textoRazonSocial;
    private JRadioButton saludRadioButton;
    private JRadioButton comercioLocalRadioButton;
    private JRadioButton comercioInternacionalRadioButton;
    private JPanel panelDatosEmpleador;
    private JRadioButton fisicaRadioButton;
    private JRadioButton juridicaRadioButton;
    private JPanel panelRubros;
    private JPanel panelPersonas;
    private JPanel panelRazonSocial;
    private JLabel labelTipoDePersona;
    private JLabel labelRubro;
    private JLabel labelRazonSocial;
    private JLabel labelCamposObligatorios;
    private JButton botonVolver;

    @Override
    public void setActionListener(ActionListener controlador) {
        this.empleadoRadioButton.addActionListener(controlador);
        this.empleadorRadioButton.addActionListener(controlador);
        this.botonVolver.addActionListener(controlador);
        this.botonRegistrarse.addActionListener(controlador);
    }

    @Override
    public void setKeyListener() {
        this.textoNombreDeUsuario.addKeyListener(this);
        this.textoContrasena.addKeyListener(this);
    }

    @Override
    public void setWindowListener(WindowListener controlador) {
        this.addWindowListener(controlador);
    }

    @Override
    public void creaOtraVentana(String ventana) {
        if (ventana.equalsIgnoreCase("Login")) {
            VentanaLogin ventanaLogin = new VentanaLogin();
            ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
            this.cerrarVentana();
            ventanaLogin.ejecutar();
        }
    }

    @Override
    public void lanzarVentanaEmergente(String mensaje) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, mensaje);
    }

    @Override
    public boolean esEmpleado() {
        return empleadoRadioButton.isSelected();
    }

    @Override
    public String getTipoUsuario() {
        if (empleadoRadioButton.isSelected())
            return empleadoRadioButton.getActionCommand();
        else {
            if (fisicaRadioButton.isSelected())
                return fisicaRadioButton.getActionCommand();
            else
                return juridicaRadioButton.getActionCommand();
        }
    }

    @Override
    public String getNombreUsuario() {
        return textoNombreDeUsuario.getText();
    }

    @Override
    public String getContrasena() {
        return textoContrasena.getText();
    }

    @Override
    public String getNombre() {
        return textoNombre.getText();
    }

    @Override
    public String getApellido() {
        return textoApellido.getText();
    }

    @Override
    public String getTelefono() {
        return textoTelefono.getText();
    }

    @Override
    public int getEdad() throws DatosMalIngresadosException {
        int edad = 0;

        if (!textoEdad.getText().isEmpty()) {
            try {
                edad = Integer.parseInt(textoEdad.getText());
            } catch (NumberFormatException e1) {
                textoEdad.setText("");
                throw new DatosMalIngresadosException("Ingrese un valor adecuado para la Edad");
            }
        }

        return edad;
    }

    @Override
    public String getEmail() {
        return textoEMail.getText();
    }

    @Override
    public String getRazonSocial() {
        return textoRazonSocial.getText();
    }

    @Override
    public String getRubro() {
        if (saludRadioButton.isSelected())
            return saludRadioButton.getActionCommand();
        else
            if (comercioLocalRadioButton.isSelected())
                return comercioLocalRadioButton.getActionCommand();
            else
                if (comercioInternacionalRadioButton.isSelected())
                    return comercioInternacionalRadioButton.getActionCommand();
                else
                    return  "-";
    }

    @Override
    public void ejecutar() {
        setTitle("My Linkedn - Grupo 10");
        pack(); //Coloca los componentes
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,550); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setLocationRelativeTo(null);
        botonRegistrarse.setEnabled(false);
    }

    @Override
    public void cerrarVentana() {
        setVisible(false); //Oculto la ventana
        dispose(); //Cierro la ventana
    }

    public void muestraOpcionEmpleado() {
        panelDatosEmpleado.setVisible(true);
        panelDatosEmpleador.setVisible(false);
        fisicaRadioButton.setSelected(false);
        juridicaRadioButton.setSelected(false);
    }

    public void muestraOpcionEmpleador() {
        panelDatosEmpleador.setVisible(true);
        panelDatosEmpleado.setVisible(false);
        fisicaRadioButton.setSelected(true);
    }

    @Override
    public void nombreUsuarioInvalido() {
        textoNombreDeUsuario.setText("");
        botonRegistrarse.setEnabled(false);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (textoNombreDeUsuario.getText().isEmpty() || textoContrasena.getText().isEmpty()) {
            botonRegistrarse.setEnabled(false);
        } else {
            botonRegistrarse.setEnabled(true);
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
