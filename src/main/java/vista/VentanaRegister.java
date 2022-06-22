package vista;

import controladores.ControladorLogin;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class VentanaRegister extends JFrame implements IVistaRegister {
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
    private JLabel labelCamposOpcionales;

    public JRadioButton getSaludRadioButton() {
        return saludRadioButton;
    }

    public void setSaludRadioButton(JRadioButton saludRadioButton) {
        this.saludRadioButton = saludRadioButton;
    }

    public JRadioButton getComercioLocalRadioButton() {
        return comercioLocalRadioButton;
    }

    public void setComercioLocalRadioButton(JRadioButton comercioLocalRadioButton) {
        this.comercioLocalRadioButton = comercioLocalRadioButton;
    }

    public JRadioButton getComercioInternacionalRadioButton() {
        return comercioInternacionalRadioButton;
    }

    public void setComercioInternacionalRadioButton(JRadioButton comercioInternacionalRadioButton) {
        this.comercioInternacionalRadioButton = comercioInternacionalRadioButton;
    }

    public JRadioButton getEmpleadoRadioButton() {
        return empleadoRadioButton;
    }

    public void setEmpleadoRadioButton(JRadioButton empleadoRadioButton) {
        this.empleadoRadioButton = empleadoRadioButton;
    }

    public JRadioButton getEmpleadorRadioButton() {
        return empleadorRadioButton;
    }

    public void setEmpleadorRadioButton(JRadioButton empleadorRadioButton) {
        this.empleadorRadioButton = empleadorRadioButton;
    }

    public JRadioButton getFisicaRadioButton() {
        return fisicaRadioButton;
    }

    public void setFisicaRadioButton(JRadioButton fisicaRadioButton) {
        this.fisicaRadioButton = fisicaRadioButton;
    }

    public JRadioButton getJuridicaRadioButton() {
        return juridicaRadioButton;
    }

    public void setJuridicaRadioButton(JRadioButton juridicaRadioButton) {
        this.juridicaRadioButton = juridicaRadioButton;
    }

    public JTextField getTextoNombreDeUsuario() {
        return textoNombreDeUsuario;
    }

    public void setTextoNombreDeUsuario(JTextField textoNombreDeUsuario) {
        this.textoNombreDeUsuario = textoNombreDeUsuario;
    }

    public JTextField getTextoContrasena() {
        return textoContrasena;
    }

    public void setTextoContrasena(JTextField textoContrasena) {
        this.textoContrasena = textoContrasena;
    }

    public JTextField getTextoNombre() {
        return textoNombre;
    }

    public void setTextoNombre(JTextField textoNombre) {
        this.textoNombre = textoNombre;
    }

    public JTextField getTextoApellido() {
        return textoApellido;
    }

    public void setTextoApellido(JTextField textoApellido) {
        this.textoApellido = textoApellido;
    }

    public JTextField getTextoTelefono() {
        return textoTelefono;
    }

    public void setTextoTelefono(JTextField textoTelefono) {
        this.textoTelefono = textoTelefono;
    }

    public JTextField getTextoEdad() {
        return textoEdad;
    }

    public void setTextoEdad(JTextField textoEdad) {
        this.textoEdad = textoEdad;
    }

    public JTextField getTextoEMail() {
        return textoEMail;
    }

    public void setTextoEMail(JTextField textoEMail) {
        this.textoEMail = textoEMail;
    }

    public JTextField getTextoRazonSocial() {
        return textoRazonSocial;
    }

    public void setTextoRazonSocial(JTextField textoRazonSocial) {
        this.textoRazonSocial = textoRazonSocial;
    }

    public JButton getBotonRegistrarse() {
        return botonRegistrarse;
    }

    public void setBotonRegistrarse(JButton botonRegistrarse) {
        this.botonRegistrarse = botonRegistrarse;
    }

    @Override
    public void setActionListener(ActionListener controlador) {
        this.empleadoRadioButton.addActionListener(controlador);
        this.empleadorRadioButton.addActionListener(controlador);

        //AGREGAR EL RESTO

        this.botonRegistrarse.addActionListener(controlador);
    }

    @Override
    public void setKeyListener(KeyListener controlador) {
        this.textoNombreDeUsuario.addKeyListener(controlador);
        this.textoContrasena.addKeyListener(controlador);
    }

    @Override
    public void ejecutar() {
        setTitle("My Linkedn - Grupo 5");
        pack(); //Coloca los componentes
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setLocationRelativeTo(null);
        botonRegistrarse.setEnabled(false);
    }

    @Override
    public void ocultar() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(false);
    }

    public void muestraOpcionEmpleado() {
        panelDatosEmpleado.setVisible(true);
        panelDatosEmpleador.setVisible(false);
        fisicaRadioButton.setSelected(false);
        juridicaRadioButton.setSelected(false);
    }

    public void muestraOpcionEmpleador() {
        panelDatosEmpleado.setVisible(false);
        panelDatosEmpleador.setVisible(true);
        fisicaRadioButton.setSelected(true);
    }

    @Override
    public void creaOtraVentana(String ventana) {
        if (ventana.equalsIgnoreCase("Login")) {
            VentanaLogin ventanaLogin = new VentanaLogin();
            ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
            this.ocultar();
            ventanaLogin.ejecutar();
        }
    }

    @Override
    public void lanzarVentanaEmergente(String mensaje) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, mensaje);
    }
}
