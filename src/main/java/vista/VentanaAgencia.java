package vista;

import controladores.ControladorLogin;
import modelo.usuarios.Usuario;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

public class VentanaAgencia extends JFrame implements IVistaAgencia, KeyListener,Observer {
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
    private JButton botonCalcularComisiones;
    private JList<String> listaComisiones;
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
    private JLabel labelLinkdn;
    private JPanel panelPerfil;
    private JPanel panelIngresarDatos;
    private JPanel panelVerDatos;
    private JPanel panelComisiones;
    private JLabel labelTiposDeTrabajo;
    private JLabel labelTiposDePuestos;
    private JLabel labelTitulo1;
    private JLabel labelRangoLaboral;
    private JLabel labelTitulo2;
    private JLabel labelTitulo3;
    private JButton botonDesloguearse;
    private JScrollPane comisionesScrollPane;
    private JScrollPane datosAlmacenadosScrollPane;
    private Usuario observado;
    //MODELOS PARA LISTAS
    DefaultListModel<String> modeloTiposDeTrabajo = new DefaultListModel<> ();
    DefaultListModel<String>  modeloRangosLaborales = new DefaultListModel<>();
    DefaultListModel<String>  modeloTiposDePuestos = new DefaultListModel<>();
    DefaultListModel<String>  modeloDatosAlmacenados = new DefaultListModel<>();
    DefaultListModel<String>  modeloComisiones = new DefaultListModel<>();

    @Override
    public void setActionListener(ActionListener controlador) {
        botonPerfil.addActionListener(controlador);
        botonIngresarDatos.addActionListener(controlador);
        botonVerDatos.addActionListener(controlador);
        botonComisiones.addActionListener(controlador);
        botonDesloguearse.addActionListener(controlador);
        botonDarDeBaja.addActionListener(controlador);
        botonRondaDeContrataciones.addActionListener(controlador);
        botonRondaDeEncuentrosLaborales.addActionListener(controlador);
        botonAgregarDatos.addActionListener(controlador);
        botonCalcularComisiones.addActionListener(controlador);
        boxDatosCargados.addActionListener(controlador);

        panelVentanas.getSelectedIndex();
    }

    @Override
    public void setKeyListener() {
        textoTiposDeTrabajo.addKeyListener(this);
        textoRangoLaboral.addKeyListener(this);
        textoTiposDePuestos.addKeyListener(this);
    }

    @Override
    public String getTipoDeTrabajo() {
        return textoTiposDeTrabajo.getText();
    }

    @Override
    public int getRangoLaboral() {
        int aux = -1;

        if (!textoRangoLaboral.getText().isEmpty()) {
            try {
                aux = Integer.parseInt(textoRangoLaboral.getText());
            } catch (NumberFormatException e1) {
                lanzarVentanaEmergente("ERROR: Ingrese un valor numerico entero en el campo Rango Laboral");
                textoRangoLaboral.setText("");
            }
        }

        return aux;
    }

    @Override
    public String getTipoDePuesto() {
        return textoTiposDePuestos.getText();
    }

    @Override
    public void setWindowListener(WindowListener controlador) {
        this.addWindowListener(controlador);
    }

    @Override
    public void ejecutar() {
        setTitle("My Linkedn - Grupo 10");
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
    public void cerrarVentana() {
        setVisible(false); //Oculto la ventana
        dispose(); //Cierro la ventana
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
    public int getIndiceSeleccionado() {
        return boxDatosCargados.getSelectedIndex();
    }

    @Override
    public void cambiarPagina(int pagina) {
        panelVentanas.setSelectedIndex(pagina);
    }

    @Override
    public void cambiarTitulo(String nombreAgencia) {
        textoBienvenido.setText("Bienvenido, " + nombreAgencia);
    }

    @Override
    public void cambiarTotal(double total) {
        if (total == 0)
            textoTotal.setText("Total a cobrar: -" );
        else
            textoTotal.setText("Total a cobrar: " + total);
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
    public void cargarModelo(DefaultListModel<String> modelo, String dato) {
        modelo.add(modelo.size(),dato); //Agrego al final
    }

    @Override
    public void limpiaModelo(String aux) {
        if (aux.equalsIgnoreCase("Comisiones"))
            modeloComisiones.removeAllElements();
        else
            if (aux.equalsIgnoreCase("Datos Almacenados"))
                modeloDatosAlmacenados.removeAllElements();
    }

    @Override
    public void mostrarDatos(String dato) {
        if (dato.equalsIgnoreCase("Datos Almacenados"))
            listaDatosAlmacenados.setModel(modeloDatosAlmacenados);
        else
            if (dato.equalsIgnoreCase("Comisiones"))
                listaComisiones.setModel(modeloComisiones);
    }

    public void setObservado(Usuario usuario) {
        this.observado = usuario;
        usuario.addObserver(this);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (textoTiposDeTrabajo.getText().isEmpty() && textoRangoLaboral.getText().isEmpty() && textoTiposDePuestos.getText().isEmpty())
            botonAgregarDatos.setEnabled(false);
        else
            botonAgregarDatos.setEnabled(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (modeloRangosLaborales.size() == 2) {
            textoRangoLaboral.setText("");
            textoRangoLaboral.setEnabled(false);
        }
        if (modeloTiposDePuestos.size() == 3) {
            textoTiposDePuestos.setText("");
            textoTiposDePuestos.setEnabled(false);
        }
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

    //METODOS NO USADOS
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
