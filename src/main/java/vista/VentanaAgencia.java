package vista;

import controladores.ControladorLogin;
import modelo.usuarios.Usuario;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class VentanaAgencia extends JFrame implements IVistaAgencia, Observer {
    private JPanel panelPrincipal;
    private JTabbedPane panelVentanas;
    private JButton botonComisiones;
    private JButton botonVerDatos;
    private JButton botonIngresarDatos;
    private JButton botonPerfil;
    private JPanel panelMenu;
    private JButton botonDarDeBaja;
    private JButton botonRondaDeEncuentrosLaborales;
    private JButton botonRondaDeContrataciones;
    private JPanel panelRondas;
    private JPanel panelTitulo;
    private JTextField textoTiposDeTrabajo;
    private JList<String> listaTiposDeTrabajo;
    private JList<String>  listaTiposDePuestos;
    private JList<String>  listaRangoLaboral;
    private JComboBox<String> boxDatosCargados;
    private JList<String> listaDatosAlmacenados;
    private JPanel panelTiposDeTrabajo;
    private JPanel panelTiposDePuestos;
    private JPanel panelTextoprincipal;
    private JPanel panelAgregarDatos;
    private JButton calcularComisionesButton;
    private JList listaComisiones;
    private JPanel panelTextoPrincipal;
    private JPanel panelLista;
    private JLabel textoBienvenido;
    private JLabel textoAgencia;
    private JPanel panelRangoLaboral;
    private JButton botonAgregarDatos;
    private JTextField textoRangoLaboral;
    private JTextField textoTiposDePuestos;
    private JPanel panelTotal;
    private JLabel textoTotal;
    private JPanel panelTituloVerDatos;
    private JPanel PanelDatosAlmacenados;
    private Usuario observado;
    //MODELOS PARA LISTAS
    DefaultListModel modeloTiposDeTrabajo = new DefaultListModel();
    DefaultListModel modeloRangosLaborales = new DefaultListModel();
    DefaultListModel modeloTiposDePuestos = new DefaultListModel();
    DefaultListModel modeloDatosAlmacenados = new DefaultListModel<>();
    DefaultListModel modeloComisiones = new DefaultListModel<>();

    public JLabel getTextoTotal() {
        return textoTotal;
    }

    public JList<String> getListaDatosAlmacenados() {
        return listaDatosAlmacenados;
    }

    public JList getListaComisiones() {
        return listaComisiones;
    }

    public DefaultListModel getModeloDatosAlmacenados() {
        return modeloDatosAlmacenados;
    }

    public DefaultListModel getModeloComisiones() {
        return modeloComisiones;
    }

    public DefaultListModel getModeloTiposDeTrabajo() {
        return modeloTiposDeTrabajo;
    }

    public DefaultListModel getModeloRangosLaborales() {
        return modeloRangosLaborales;
    }

    public DefaultListModel getModeloTiposDePuestos() {
        return modeloTiposDePuestos;
    }

    public JComboBox getBoxDatosCargados() {
        return boxDatosCargados;
    }

    public void setBoxDatosCargados(JComboBox boxDatosCargados) {
        this.boxDatosCargados = boxDatosCargados;
    }

    public JTextField getTextoTiposDeTrabajo() {
        return textoTiposDeTrabajo;
    }

    public void setTextoTiposDeTrabajo(JTextField textoTiposDeTrabajo) {
        this.textoTiposDeTrabajo = textoTiposDeTrabajo;
    }

    public JTextField getTextoRangoLaboral() {
        return textoRangoLaboral;
    }

    public void setTextoRangoLaboral(JTextField textoRangoLaboral) {
        this.textoRangoLaboral = textoRangoLaboral;
    }

    public JTextField getTextoTiposDePuestos() {
        return textoTiposDePuestos;
    }

    public void setTextoTiposDePuestos(JTextField textoTiposDePuestos) {
        this.textoTiposDePuestos = textoTiposDePuestos;
    }

    public JButton getBotonAgregarDatos() {
        return botonAgregarDatos;
    }

    public void setBotonAgregarDatos(JButton botonAgregarDatos) {
        this.botonAgregarDatos = botonAgregarDatos;
    }

    public JButton getBotonComisiones() {
        return botonComisiones;
    }

    public void setBotonComisiones(JButton botonComisiones) {
        this.botonComisiones = botonComisiones;
    }

    public JButton getBotonVerDatos() {
        return botonVerDatos;
    }

    public void setBotonVerDatos(JButton botonVerDatos) {
        this.botonVerDatos = botonVerDatos;
    }

    public JButton getBotonIngresarDatos() {
        return botonIngresarDatos;
    }

    public void setBotonIngresarDatos(JButton botonIngresarDatos) {
        this.botonIngresarDatos = botonIngresarDatos;
    }

    public JButton getBotonPerfil() {
        return botonPerfil;
    }

    public void setBotonPerfil(JButton botonPerfil) {
        this.botonPerfil = botonPerfil;
    }

    public JButton getBotonDarDeBaja() {
        return botonDarDeBaja;
    }

    public void setBotonDarDeBaja(JButton botonDarDeBaja) {
        this.botonDarDeBaja = botonDarDeBaja;
    }

    public JButton getBotonRondaDeEncuentrosLaborales() {
        return botonRondaDeEncuentrosLaborales;
    }

    public void setBotonRondaDeEncuentrosLaborales(JButton botonRondaDeEncuentrosLaborales) {
        this.botonRondaDeEncuentrosLaborales = botonRondaDeEncuentrosLaborales;
    }

    public JButton getBotonRondaDeContrataciones() {
        return botonRondaDeContrataciones;
    }

    public void setBotonRondaDeContrataciones(JButton botonRondaDeContrataciones) {
        this.botonRondaDeContrataciones = botonRondaDeContrataciones;
    }

    public JLabel getTextoBienvenido() {
        return textoBienvenido;
    }

    public void setTextoBienvenido(JLabel textoBienvenido) {
        this.textoBienvenido = textoBienvenido;
    }

    public JLabel getTextoAgencia() {
        return textoAgencia;
    }

    public void setTextoAgencia(JLabel textoAgencia) {
        this.textoAgencia = textoAgencia;
    }

    @Override
    public void setActionListener(ActionListener controlador) {
        botonPerfil.addActionListener(controlador);
        botonIngresarDatos.addActionListener(controlador);
        botonVerDatos.addActionListener(controlador);
        botonComisiones.addActionListener(controlador);
        botonDarDeBaja.addActionListener(controlador);
        botonRondaDeContrataciones.addActionListener(controlador);
        botonRondaDeEncuentrosLaborales.addActionListener(controlador);
        botonAgregarDatos.addActionListener(controlador);
        boxDatosCargados.addActionListener(controlador);
    }

    @Override
    public void setKeyListener(KeyListener controlador) {
        textoTiposDeTrabajo.addKeyListener(controlador);
        textoRangoLaboral.addKeyListener(controlador);
        textoTiposDePuestos.addKeyListener(controlador);
    }

    @Override
    public void ejecutar() {
        setTitle("My Linkedn - Grupo 5");
        pack(); //Coloca los componentes
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800,500); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setLocationRelativeTo(null);

        botonAgregarDatos.setEnabled(false);
        listaTiposDeTrabajo.setModel(modeloTiposDeTrabajo);
        listaRangoLaboral.setModel(modeloRangosLaborales);
        listaTiposDePuestos.setModel(modeloTiposDePuestos);
        listaDatosAlmacenados.setModel(modeloDatosAlmacenados);
        listaComisiones.setModel(modeloComisiones);
    }

    @Override
    public void ocultar() {
        this.setVisible(false);
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

    @Override
    public void cambiarPagina(int pagina) {
        panelVentanas.setSelectedIndex(pagina);
    }

    @Override
    public void agregarDatos(String tipoTrabajo, String rangoLaboral, String tipoPuesto) {
        if (!tipoTrabajo.isEmpty()) {
            modeloTiposDeTrabajo.add(modeloTiposDeTrabajo.size(), tipoTrabajo);
            textoTiposDeTrabajo.setText("");
        }
        if (!rangoLaboral.isEmpty() && modeloRangosLaborales.size() < 2) {
            modeloRangosLaborales.add(modeloRangosLaborales.size(), rangoLaboral);
            textoRangoLaboral.setText("");
        }
        if (!tipoPuesto.isEmpty() && modeloTiposDePuestos.size() < 3) {
            modeloTiposDePuestos.add(modeloTiposDePuestos.size(), tipoPuesto);
            textoTiposDePuestos.setText("");
        }
    }

    @Override
    public void cargarModelo(DefaultListModel modelo, String dato) {
        modeloDatosAlmacenados.add(modeloDatosAlmacenados.size(),dato);
    }

    @Override
    public void limpiaModelo(DefaultListModel modelo) {
        modelo.removeAllElements();
    }

    @Override
    public void mostrarDatos(JList lista, DefaultListModel modelo) {
        lista.setModel(modelo);
    }

    public void setObservado(Usuario usuario) {
        this.observado = usuario;
        usuario.addObserver(this);
    }

    @Override
    public void update(Observable usuario, Object texto) {
        if (usuario != observado)
            throw new IllegalArgumentException();
        else {
            if (panelVentanas.getSelectedIndex() == 2) {
                cargarModelo(modeloDatosAlmacenados, (String) texto);
            }
            if (panelVentanas.getSelectedIndex() == 3) {
                cargarModelo(modeloComisiones, (String) texto);
            }
        }
    }
}
