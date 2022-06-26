package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controladores.ControladorLogin;
import modelo.listas.Contrato;
import modelo.tickets.Ticket;
import modelo.tickets.Ticket_de_Busqueda_de_Empleo;
import modelo.tickets.locaciones.LocacionFactory;
import modelo.usuarios.EmpleadoPretenso;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;

public class VentanaEmpleado extends JFrame implements IVistaUsuarioComun, ActionListener {
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnProfile;
	private JButton ticketsButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton eleccionesButton;
	private JTabbedPane pantallasTab ;
	private JPanel tab1;
	private JSeparator separator;
	private JLabel lblEtiqueta;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel LabelEdad;
	private JSeparator separator_1;
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel mailLabel;
	private JLabel edadLabel;
	private JLabel telefonoLabel;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_6;
	private JScrollPane scrollPane;
	private JList<Ticket_de_Busqueda_de_Empleo> list_1 = new JList<>();
	private JPanel panel_4;
	private JButton agregarTicketButton;
	private JButton eliminarTicketButton;
	private JButton btnSuspender;
    private LocacionFactory lc = new LocacionFactory();
	private JLabel lblEtiqueta_1;
	private JSeparator separator_7;
	private JLabel lblNewLabel_7;
	private JLabel cantTicketsLabel;
	private JLabel nombreCompletooLabel;
	private JPanel tab3;
	private JScrollPane scrollPane_1;
	private JButton seleccionarEmpleadorButton;
	private JLabel lblEtiqueta_2;
	private JSeparator separator_5;
	private JLabel lblNewLabel;
	private JLabel nombreCompletooLabel_1;
	private JList<Ticket> listaElecciones;
	private FormTickets form;
	private JPanel tab2;
	private JButton cerrarSesionBtn;
	private JButton btnDarDeBaja;
	private JButton btnContratos;
	private JButton btnActivar;
	private JPanel tab4;
	private JScrollPane scrollPane_2;
	private JButton seleccionarEmpleadorButton_1;
	private JLabel lblEtiqueta_3;
	private JSeparator separator_8;
	private JLabel lblNewLabel_8;
	private JLabel nombreCompletooLabel_2;

	// Ventaja Emergente
	public void confirmarSeleccion() {
		lblNewLabel.setText("Empleado seleccionado , espere los resultados");
		this.listaElecciones.setVisible(false);
		this.seleccionarEmpleadorButton.setVisible(false);
	}

	public VentanaEmpleado(EmpleadoPretenso modelo) {
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(0, 0, 186, 464);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ticketsButton = new JButton("Tickets");
		ticketsButton.setSelected(true);
		ticketsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ticketsButton.setBackground(new Color(100, 149, 237));
		ticketsButton.setActionCommand("iniciarTICKETS");
		ticketsButton.setBorder(null);
		ticketsButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		ticketsButton.setBounds(0, 189, 186, 35);
		panel.add(ticketsButton);
		
		eleccionesButton = new JButton("Elecciones");
		eleccionesButton.setSelected(true);
		eleccionesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eleccionesButton.setBackground(new Color(100, 149, 237));
		eleccionesButton.setActionCommand("iniciarELECCIONES");
		eleccionesButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		eleccionesButton.setBorder(null);
		eleccionesButton.setBounds(0, 232, 186, 35);
		panel.add(eleccionesButton);
		
		btnProfile = new JButton("Perfil");
		btnProfile.setSelected(true);
		btnProfile.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnProfile.setBorder(null);
		btnProfile.setBackground(new Color(100, 149, 237));
		btnProfile.setActionCommand("iniciarPERFIL");
		btnProfile.setBounds(0, 146, 186, 35);
		panel.add(btnProfile);
		
		lblNewLabel_1 = new JLabel("My Linkedn");
		lblNewLabel_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(-14, 56, 200, 49);
		panel.add(lblNewLabel_1);
		
		cerrarSesionBtn = new JButton("Cerrar sesion");
		cerrarSesionBtn.addActionListener(this);
		cerrarSesionBtn.setSelected(true);
		cerrarSesionBtn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		cerrarSesionBtn.setBorder(null);
		cerrarSesionBtn.setBackground(new Color(100, 149, 237));
		cerrarSesionBtn.setActionCommand("CERRARSESION");
		cerrarSesionBtn.setBounds(0, 354, 186, 35);
		panel.add(cerrarSesionBtn);
		
		btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.setSelected(true);
		btnDarDeBaja.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnDarDeBaja.setBorder(null);
		btnDarDeBaja.setBackground(new Color(100, 149, 237));
		btnDarDeBaja.setActionCommand("BAJA");
		btnDarDeBaja.setBounds(0, 402, 186, 35);
		panel.add(btnDarDeBaja);
		
		btnContratos = new JButton("Contratos");
		btnContratos.addActionListener(this);
		btnContratos.setSelected(true);
		btnContratos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnContratos.setBorder(null);
		btnContratos.setBackground(new Color(100, 149, 237));
		btnContratos.setActionCommand("CONTRATOS");
		btnContratos.setBounds(0, 274, 186, 35);
		panel.add(btnContratos);
		
		pantallasTab = new JTabbedPane(JTabbedPane.TOP);
		pantallasTab.setBounds(187, 0, 599, 464);
		contentPane.add(pantallasTab);
		
		tab1 = new JPanel();
		tab1.setBackground(new Color(30, 144, 255));
		pantallasTab.addTab("Perfil", null, tab1, null);
		tab1.setLayout(null);
		
		lblEtiqueta = new JLabel("Empleado");
		lblEtiqueta.setForeground(new Color(253, 245, 230));
		lblEtiqueta.setFont(new Font("Segoe UI Light", Font.PLAIN, 39));
		lblEtiqueta.setBounds(27, 65, 238, 60);
		tab1.add(lblEtiqueta);
		
		separator = new JSeparator();
		separator.setBackground(new Color(245, 245, 245));
		separator.setForeground(new Color(253, 245, 230));
		separator.setBounds(27, 123, 176, 2);
		tab1.add(separator);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src/icons8-donald-trump-96.png"));
		lblNewLabel_2.setBounds(37, 133, 266, 183);
		tab1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setForeground(new Color(245, 245, 245));
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		lblNewLabel_3.setBounds(283, 65, 77, 36);
		tab1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Apellido");
		lblNewLabel_4.setForeground(new Color(253, 245, 230));
		lblNewLabel_4.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		lblNewLabel_4.setBounds(464, 65, 77, 36);
		tab1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setForeground(new Color(253, 245, 230));
		lblNewLabel_5.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		lblNewLabel_5.setBounds(283, 234, 77, 36);
		tab1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Telefono");
		lblNewLabel_6.setForeground(new Color(253, 245, 230));
		lblNewLabel_6.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		lblNewLabel_6.setBounds(464, 148, 77, 36);
		tab1.add(lblNewLabel_6);
		
		LabelEdad = new JLabel("Edad");
		LabelEdad.setForeground(new Color(253, 245, 230));
		LabelEdad.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		LabelEdad.setBounds(283, 148, 77, 36);
		tab1.add(LabelEdad);
		
		separator_1 = new JSeparator();
		separator_1.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		separator_1.setForeground(new Color(0, 0, 139));
		separator_1.setBackground(new Color(0, 0, 139));
		separator_1.setBounds(280, 100, 69, 40);
		tab1.add(separator_1);
		
		nombreLabel = new JLabel("Tomas");
		nombreLabel.setForeground(new Color(253, 245, 230));
		nombreLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		nombreLabel.setBounds(283, 104, 120, 36);
		tab1.add(nombreLabel);
		
		apellidoLabel = new JLabel("Matarazzo");
		apellidoLabel.setForeground(new Color(253, 245, 230));
		apellidoLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		apellidoLabel.setBounds(464, 104, 120, 36);
		tab1.add(apellidoLabel);
		
		mailLabel = new JLabel("tomasm208@hotmail.es");
		mailLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		mailLabel.setForeground(new Color(253, 245, 230));
		mailLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		mailLabel.setBounds(283, 267, 176, 49);
		tab1.add(mailLabel);
		
		edadLabel = new JLabel("24");
		edadLabel.setForeground(new Color(253, 245, 230));
		edadLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		edadLabel.setBounds(283, 190, 120, 36);
		tab1.add(edadLabel);
		
		telefonoLabel = new JLabel("2266473122");
		telefonoLabel.setForeground(new Color(253, 245, 230));
		telefonoLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		telefonoLabel.setBounds(464, 192, 120, 36);
		tab1.add(telefonoLabel);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 139));
		separator_2.setBackground(new Color(0, 0, 139));
		separator_2.setBounds(283, 177, 51, 49);
		tab1.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 0, 139));
		separator_3.setBackground(new Color(0, 0, 139));
		separator_3.setBounds(464, 177, 69, 40);
		tab1.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 0, 139));
		separator_4.setBackground(new Color(0, 0, 139));
		separator_4.setBounds(464, 100, 69, 40);
		tab1.add(separator_4);
		
		separator_6 = new JSeparator();
		separator_6.setForeground(new Color(0, 0, 139));
		separator_6.setBackground(new Color(0, 0, 139));
		separator_6.setBounds(283, 263, 69, 40);
		tab1.add(separator_6);
		
		tab2 = new JPanel();
		tab2.setBackground(new Color(30, 144, 255));
		pantallasTab.addTab("Tickets", null, tab2, null);
		tab2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 155, 539, 276);
		tab2.add(scrollPane);
		this.renderListaTicketsEmpleado(modelo.getTicketDeBusquedaDeEmpleo());
		list_1.setVisibleRowCount(3);
		scrollPane.setViewportView(list_1);
		
		panel_4 = new JPanel();
		scrollPane.setRowHeaderView(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		agregarTicketButton = new JButton("Agregar Ticket");
		agregarTicketButton.setActionCommand("AGREGARTICKET");
		agregarTicketButton.setBounds(31, 128, 89, 19);
		tab2.add(agregarTicketButton);
		
		eliminarTicketButton = new JButton("Cancelar");
		eliminarTicketButton.setActionCommand("ELIMINARTICKET");
		eliminarTicketButton.setBounds(128, 128, 87, 19);
		tab2.add(eliminarTicketButton);
		
		btnSuspender = new JButton("Suspender Ticket");
		btnSuspender.setActionCommand("SUSPENDERTICKET");
		btnSuspender.setBounds(223, 128, 100, 19);
		tab2.add(btnSuspender);
		
		lblEtiqueta_1 = new JLabel("Empleado: ");
		lblEtiqueta_1.setForeground(new Color(253, 245, 230));
		lblEtiqueta_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		lblEtiqueta_1.setBounds(31, 8, 238, 60);
		tab2.add(lblEtiqueta_1);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(new Color(253, 245, 230));
		separator_7.setBackground(new Color(245, 245, 245));
		separator_7.setBounds(31, 59, 115, 2);
		tab2.add(separator_7);
		
		lblNewLabel_7 = new JLabel("Cantidad de tickets: ");
		lblNewLabel_7.setForeground(new Color(240, 248, 255));
		lblNewLabel_7.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(31, 76, 187, 38);
		tab2.add(lblNewLabel_7);
		
		cantTicketsLabel = new JLabel("1");
		cantTicketsLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		cantTicketsLabel.setBounds(206, 72, 46, 44);
		tab2.add(cantTicketsLabel);
		
		nombreCompletooLabel = new JLabel("Tomas Matarazzo");
		nombreCompletooLabel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		nombreCompletooLabel.setBounds(164, 24, 231, 29);
		tab2.add(nombreCompletooLabel);
		
		btnActivar = new JButton("Activar");
		btnActivar.setActionCommand("ACTIVARTICKET");
		btnActivar.setBounds(335, 128, 100, 19);
		tab2.add(btnActivar);
		
		pantallasTab.setSelectedIndex(0);
		
		tab3 = new JPanel();
		tab3.setLayout(null);
		tab3.setBackground(new Color(30, 144, 255));
		pantallasTab.addTab("Elecciones", null, tab3, null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 155, 539, 276);
		tab3.add(scrollPane_1);
		
		
		seleccionarEmpleadorButton = new JButton("Confirmar Empleador");
		seleccionarEmpleadorButton.setActionCommand("EMPLEADORELEGIDO");
		seleccionarEmpleadorButton.setBounds(31, 128, 169, 19);
		tab3.add(seleccionarEmpleadorButton);
		
		lblEtiqueta_2 = new JLabel("Empleado: ");
		lblEtiqueta_2.setForeground(new Color(253, 245, 230));
		lblEtiqueta_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		lblEtiqueta_2.setBounds(31, 8, 238, 60);
		tab3.add(lblEtiqueta_2);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(new Color(253, 245, 230));
		separator_5.setBackground(new Color(245, 245, 245));
		separator_5.setBounds(31, 59, 115, 2);
		tab3.add(separator_5);
		
		lblNewLabel = new JLabel();
		this.renderListaElecciones( null);
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 76, 464, 38);
		tab3.add(lblNewLabel);
		
		nombreCompletooLabel_1 = new JLabel("Tomas Matarazzo");
		nombreCompletooLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		nombreCompletooLabel_1.setBounds(164, 24, 231, 29);
		tab3.add(nombreCompletooLabel_1);
		
		tab4 = new JPanel();
		tab4.setLayout(null);
		tab4.setBackground(new Color(30, 144, 255));
		pantallasTab.addTab("Contratos", null, tab4, null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(31, 155, 539, 276);
		tab4.add(scrollPane_2);
		
		seleccionarEmpleadorButton_1 = new JButton("Confirmar Empleador");
		seleccionarEmpleadorButton_1.setActionCommand("EMPLEADORELEGIDO");
		seleccionarEmpleadorButton_1.setBounds(31, 128, 169, 19);
		tab4.add(seleccionarEmpleadorButton_1);
		
		lblEtiqueta_3 = new JLabel("Empleado: ");
		lblEtiqueta_3.setForeground(new Color(253, 245, 230));
		lblEtiqueta_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		lblEtiqueta_3.setBounds(31, 8, 238, 60);
		tab4.add(lblEtiqueta_3);
		
		separator_8 = new JSeparator();
		separator_8.setForeground(new Color(253, 245, 230));
		separator_8.setBackground(new Color(245, 245, 245));
		separator_8.setBounds(31, 59, 115, 2);
		tab4.add(separator_8);
		
		lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setForeground(new Color(240, 248, 255));
		lblNewLabel_8.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(31, 76, 464, 38);
		tab4.add(lblNewLabel_8);
		
		nombreCompletooLabel_2 = new JLabel("Tomas Matarazzo");
		nombreCompletooLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		nombreCompletooLabel_2.setBounds(164, 24, 231, 29);
		tab4.add(nombreCompletooLabel_2);
		
		form = new FormTickets();
	}
	
	@Override
	public void setActionListener(ActionListener controlador) {
		this.ticketsButton.addActionListener(controlador);
		this.btnProfile.addActionListener(controlador);
		this.eleccionesButton.addActionListener(controlador);
		this.agregarTicketButton.addActionListener(controlador);
		this.eliminarTicketButton.addActionListener(controlador);
		this.seleccionarEmpleadorButton.addActionListener(controlador);
		this.form.crearTicketButton.addActionListener(controlador);
		this.cerrarSesionBtn.addActionListener(controlador);
		this.btnDarDeBaja.addActionListener(controlador);
		this.btnContratos.addActionListener(controlador);
		this.btnSuspender.addActionListener(controlador);
		this.btnActivar.addActionListener(controlador);
	}

	@Override
	public void setWindowListener(WindowListener controlador) {
		this.addWindowListener(controlador);
	}

	@Override
	public void ejecutar() {
		setTitle("My Linkedn - Grupo 10");
		pack(); //Coloca los componentes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		setVisible(true);
		setSize(800,500); //Dimensiones del JFrame
		setResizable(false); //No redimensionable
		setLocationRelativeTo(null);
	}

	@Override
	public void cerrarVentana() {
		this.setVisible(false);
		dispose();
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
	public void cambiarPagina(int i) {
		this.pantallasTab.setSelectedIndex(i);
	}
	
	// Formulario de los tickets
	@Override
	public void mostrarFormTicket() {
		this.form.setVisible(true);
	}
	
	@Override
	public void ocultarFormTicket() {
		this.form.setVisible(false);
	}

	@Override
	public FormTickets getForm() {
		return this.form;
	}
	
	// Listas de tickets
	@Override
	public void llenarDatosEmpleado(String nombre, String apellido, String email, String telefono , int edad) {
		this.nombreLabel.setText(nombre);
		this.apellidoLabel.setText(apellido);
		this.mailLabel.setText(email);
		this.telefonoLabel.setText(telefono);
		this.edadLabel.setText(String.valueOf(edad));
		this.nombreCompletooLabel.setText(nombre + " " + apellido);
		this.cantTicketsLabel.setText(Integer.toString(this.list_1.getWidth()));
		this.nombreCompletooLabel_1.setText(nombre + " " + apellido);
	}
	
	@Override
	public void renderListaTicketsEmpleado(Ticket ticket) {
		DefaultListModel<Ticket_de_Busqueda_de_Empleo> listaTicketsDefault = new DefaultListModel<>();
		listaTicketsDefault.addElement((Ticket_de_Busqueda_de_Empleo)ticket);
		if (list_1.getModel().getSize() != 0)
			((DefaultListModel) list_1.getModel()).removeAllElements();
		this.list_1.setModel(listaTicketsDefault);
		scrollPane.setViewportView(list_1);
	}

/*	public void renderListaContratos(ArrayList<Contrato> contratos) {
		DefaultListModel<Contrato> listaContratoDefault = new DefaultListModel<>();

		for(int i = 0 ; i < contratos.size() ; i++)
			listaContratoDefault.addElement(contratos.get(i));
		this.listaContratos.setModel(listaContratoDefault);
		scrollPane.setViewportView(listaContratos);
	}
	*/
	@Override
	public void renderListaElecciones(TreeSet<Ticket> list) {
		if (list == null || list.size() == 0) {
			lblNewLabel = new JLabel("Todavia no se efectuo la ronda de contratos laborales.");
		} else {
			lblNewLabel.setText("Ofertas laborales encontradas , seleccione una");
			DefaultListModel<Ticket> tickets = new DefaultListModel<Ticket>();
			Iterator <Ticket>it = list.iterator();
			while (it.hasNext())
				tickets.addElement(it.next());
			this.listaElecciones = new JList<Ticket>();
			
			// Inicializo vista con los tickets del modelo
			this.listaElecciones.setModel(tickets);
			listaElecciones.setVisibleRowCount(3);
			scrollPane_1.setViewportView(listaElecciones);
		}
	}

	@Override
	public Ticket getTicketSeleccionado() {
		return this.list_1.getSelectedValue();
	}

	@Override
	public Ticket getTicketEleccionesSeleccionado() {
		return (this.listaElecciones == null ? null : this.listaElecciones.getSelectedValue());
	}

	@Override
	public void llenarDatosEmpleador(String nombre, String tipoPersona, String rubro, String usuario) {

	}

	@Override
	public void setCantidadTickets(String cant) {
		this.cantTicketsLabel.setText(cant);
	}

	public void actionPerformed(ActionEvent e) {
	}
}