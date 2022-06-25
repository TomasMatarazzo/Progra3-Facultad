package simulacion;

import controladores.ControladorLogin;
import vista.IVista;
import vista.VentanaLogin;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaSimulacionThreads extends JFrame implements IVista, Observer{
    private JPanel contentPane;
    private JButton btnComenzar;
	private JButton btnVolver;
    private JPanel panelOeste;
    private JPanel panel_Arriba;
    private JPanel panel_Centro;
    private JPanel panel_Sur;
    private JTextField textField;
    private JScrollPane scrollPane;
	private JTextArea textArea;
	private BolsaDeTrabajo bolsa;

    public VentanaSimulacionThreads() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 872, 676);
	this.contentPane = new JPanel();
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(this.contentPane);

	this.panelOeste = new JPanel();
	this.panelOeste.setPreferredSize(new Dimension(150, 100));
	this.contentPane.add(this.panelOeste, BorderLayout.WEST);
	this.panelOeste.setLayout(new GridLayout(3, 0, 0, 0));

	this.panel_Arriba = new JPanel();
	this.panelOeste.add(this.panel_Arriba);
	this.panel_Centro = new JPanel();
	this.panelOeste.add(this.panel_Centro);
	this.panel_Centro.setLayout(new BorderLayout(0, 0));

	this.textField = new JTextField();
	this.panel_Centro.add(this.textField);
	this.textField.setColumns(10);
	
	setPreferredSize(new Dimension(300, 300));
	getContentPane().setLayout(new BorderLayout(0, 0));
	
	this.scrollPane = new JScrollPane();
	getContentPane().add(this.scrollPane, BorderLayout.CENTER);

	this.panel_Sur = new JPanel();
	this.panel_Sur.setLayout(new GridLayout(1,2));

	this.btnComenzar = new JButton("Comenzar Simulacion");
	this.btnComenzar.setActionCommand("Comenzar");
	this.btnComenzar.setFocusable(false);
	this.panel_Sur.add(this.btnComenzar);

	this.btnVolver = new JButton("Volver");
	this.btnVolver.setActionCommand("Volver");
	this.btnVolver.setFocusable(false);
	this.panel_Sur.add(this.btnVolver);

	contentPane.add(this.panel_Sur, BorderLayout.SOUTH);
	
	this.textArea = new JTextArea();
	this.scrollPane.setViewportView(this.textArea);
	
	this.bolsa = BolsaDeTrabajo.getInstancia();
    this.bolsa.addObserver(this);
    }

	@Override
	public void setActionListener(ActionListener controlador) {
		this.btnComenzar.addActionListener(controlador);
		this.btnVolver.addActionListener(controlador);
	}

	@Override
	public void setWindowListener(WindowListener controlador) {
		this.addWindowListener(controlador);
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
	public void update(Observable o, Object arg) {
		if(o==this.bolsa) {
		    this.textArea.append(arg+"\n");
		}
		else throw new IllegalArgumentException();
	}

	//METODOS NO USADOS
	@Override
	public void ejecutar() {

	}

	@Override
	public void lanzarVentanaEmergente(String mensaje) {

	}
}
