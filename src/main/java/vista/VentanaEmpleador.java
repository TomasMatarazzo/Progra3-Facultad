package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controladores.ControladorLogin;
import modelo.tickets.Ticket;
import modelo.tickets.Ticket_de_Busqueda_de_Empleado;
import modelo.tickets.locaciones.LocacionFactory;
import java.awt.Color;
import javax.swing.JButton;
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
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class VentanaEmpleador extends JFrame implements IVistaUsuarioComun {
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnProfile;
	private JButton ticketsButton;
	private JButton eleccionesButton;
	private JTabbedPane pantallasTab ;
	private JLabel lblNewLabel_1;
	private JPanel tab1;
	private JLabel lblEtiqueta;
	private JSeparator separator;
	private JLabel lblNewLabel_3;
	private JLabel labelEntidad;
	private JLabel labelRubro;
	private JLabel labelUsuario;
	private JSeparator separator_1;
	private JLabel nombreLabel;
	private JLabel entidadLabel;
	private JLabel usuarioLabel;
	private JLabel rubroLabel;
	private JLabel lblNewLabel_2;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JScrollPane scrollPane;
	private JList<Ticket_de_Busqueda_de_Empleado> list_1 = new JList<>();
	private JPanel panel_4;
	private JButton agregarTicketButton;
	private JButton eliminarTicketButton;
	private JButton btnSuspenderTicket;
    private LocacionFactory lc = new LocacionFactory();
	private JLabel lblEtiqueta_1;
	private JSeparator separator_7;
	private JLabel lblNewLabel_7;
	private JLabel cantTicketsLabel;
	private JLabel nombreCompletooLabel;
	private JPanel tab3;
	private JButton seleccionarEmpleadorButton;
	private JLabel lblEtiqueta_2;
	private JSeparator separator_5;
	private JLabel lblNewLabel;
	private JLabel nombreCompletooLabel_1;
	private JList<Ticket> listaElecciones;
	private FormTickets form;
	private JButton btnCerrarSesion;
	private JButton btnContratos;
	private JPanel tab4;
	private JScrollPane scrollPane_2;
	private JLabel lblEtiqueta_3;
	private JSeparator separator_6;
	private JLabel contratosLbl;
	private JLabel nombreCompletooLabel_2;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane_3;
	private JPanel tab2;
	private JButton btnBaja;

	public VentanaEmpleador() {
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

		btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setSelected(true);
		btnCerrarSesion.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setBackground(new Color(100, 149, 237));
		btnCerrarSesion.setActionCommand("CERRARSESION");
		btnCerrarSesion.setBounds(0, 355, 186, 35);
		panel.add(btnCerrarSesion);

		btnContratos = new JButton("Contratos");
		btnContratos.setSelected(true);
		btnContratos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnContratos.setBorder(null);
		btnContratos.setBackground(new Color(100, 149, 237));
		btnContratos.setActionCommand("CONTRATOS");
		btnContratos.setBounds(0, 275, 186, 35);
		panel.add(btnContratos);

		btnBaja = new JButton("Dar de baja");
		btnBaja.setSelected(true);
		btnBaja.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnBaja.setBorder(null);
		btnBaja.setBackground(new Color(100, 149, 237));
		btnBaja.setActionCommand("CERRARSESION");
		btnBaja.setBounds(0, 403, 186, 35);
		btnBaja.setActionCommand("BAJA");
		panel.add(btnBaja);

		pantallasTab = new JTabbedPane(JTabbedPane.TOP);
		pantallasTab.setBounds(187, 0, 599, 464);
		contentPane.add(pantallasTab);

		tab1 = new JPanel();
		tab1.setBackground(new Color(30, 144, 255));
		pantallasTab.addTab("Perfil", null, tab1, null);
		tab1.setLayout(null);

		lblEtiqueta = new JLabel("Empleador");
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
		lblNewLabel_2.setBounds(27, 125, 266, 183);
		tab1.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setForeground(new Color(245, 245, 245));
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		lblNewLabel_3.setBounds(275, 125, 77, 36);
		tab1.add(lblNewLabel_3);

		labelEntidad = new JLabel("Entidad");
		labelEntidad.setForeground(new Color(253, 245, 230));
		labelEntidad.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		labelEntidad.setBounds(275, 215, 77, 36);
		tab1.add(labelEntidad);

		labelRubro = new JLabel("Rubro");
		labelRubro.setForeground(new Color(253, 245, 230));
		labelRubro.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		labelRubro.setBounds(446, 51, 77, 36);
		tab1.add(labelRubro);

		labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(new Color(253, 245, 230));
		labelUsuario.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		labelUsuario.setBounds(273, 51, 77, 36);
		tab1.add(labelUsuario);

		separator_1 = new JSeparator();
		separator_1.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		separator_1.setForeground(new Color(0, 0, 139));
		separator_1.setBackground(new Color(0, 0, 139));
		separator_1.setBounds(275, 159, 69, 40);
		tab1.add(separator_1);

		nombreLabel = new JLabel("Tomas");
		nombreLabel.setForeground(new Color(253, 245, 230));
		nombreLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		nombreLabel.setBounds(275, 169, 120, 36);
		tab1.add(nombreLabel);

		entidadLabel = new JLabel("Matarazzo");
		entidadLabel.setForeground(new Color(253, 245, 230));
		entidadLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		entidadLabel.setBounds(275, 259, 120, 36);
		tab1.add(entidadLabel);

		usuarioLabel = new JLabel("24");
		usuarioLabel.setForeground(new Color(253, 245, 230));
		usuarioLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		usuarioLabel.setBounds(273, 95, 164, 36);
		tab1.add(usuarioLabel);

		rubroLabel = new JLabel("2266473122");
		rubroLabel.setForeground(new Color(253, 245, 230));
		rubroLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		rubroLabel.setBounds(451, 95, 120, 36);
		tab1.add(rubroLabel);

		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 139));
		separator_2.setBackground(new Color(0, 0, 139));
		separator_2.setBounds(273, 87, 51, 49);
		tab1.add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 0, 139));
		separator_3.setBackground(new Color(0, 0, 139));
		separator_3.setBounds(446, 85, 69, 40);
		tab1.add(separator_3);

		separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 0, 139));
		separator_4.setBackground(new Color(0, 0, 139));
		separator_4.setBounds(275, 255, 69, 40);
		tab1.add(separator_4);

		tab2 = new JPanel();
		tab2.setBackground(new Color(30, 144, 255));
		pantallasTab.addTab("Tickets", null, tab2, null);
		tab2.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 155, 539, 276);
		tab2.add(scrollPane);
		//this.renderListaTickets(modelo.getTicketDeBusquedaDeEmpleo());
		list_1.setVisibleRowCount(3);
		scrollPane.setViewportView(list_1);
		this.scrollPane.setVisible(false);

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

		btnSuspenderTicket = new JButton("Suspender ticket");
		btnSuspenderTicket.setBounds(223, 128, 100, 19);
		tab2.add(btnSuspenderTicket);
		btnSuspenderTicket.setActionCommand("SUSPENDERTICKET");

		lblEtiqueta_1 = new JLabel("Empleador: ");
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

		//this.renderVentanaVistas(3);

		tab3 = new JPanel();
		tab3.setLayout(null);
		tab3.setBackground(new Color(30, 144, 255));
		pantallasTab.addTab("Elecciones", null, tab3, null);

		seleccionarEmpleadorButton = new JButton("Confirmar Empleador");
		seleccionarEmpleadorButton.setActionCommand("EMPLEADORELEGIDO");
		seleccionarEmpleadorButton.setBounds(31, 128, 169, 19);
		tab3.add(seleccionarEmpleadorButton);

		lblEtiqueta_2 = new JLabel("Empleador: ");
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
		this.renderListaElecciones(null);
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

		lblEtiqueta_3 = new JLabel("Empleador: ");
		lblEtiqueta_3.setForeground(new Color(253, 245, 230));
		lblEtiqueta_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		lblEtiqueta_3.setBounds(31, 8, 238, 60);
		tab4.add(lblEtiqueta_3);

		separator_6 = new JSeparator();
		separator_6.setForeground(new Color(253, 245, 230));
		separator_6.setBackground(new Color(245, 245, 245));
		separator_6.setBounds(31, 59, 115, 2);
		tab4.add(separator_6);

		contratosLbl = new JLabel();
		contratosLbl.setText("Espere a que se efectue la ronda de contratos laborales");
		contratosLbl.setForeground(new Color(240, 248, 255));
		contratosLbl.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		contratosLbl.setBounds(31, 76, 464, 38);
		tab4.add(contratosLbl);

		nombreCompletooLabel_2 = new JLabel("Tomas Matarazzo");
		nombreCompletooLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		nombreCompletooLabel_2.setBounds(164, 24, 231, 29);
		tab4.add(nombreCompletooLabel_2);

		form = new FormTickets();
		//this.renderVentanaVistas(3);
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
		this.btnContratos.addActionListener(controlador);
		this.btnCerrarSesion.addActionListener(controlador);
		this.btnSuspenderTicket.addActionListener(controlador);
		this.btnBaja.addActionListener(controlador);
	}
	
	@Override
	public void setWindowListener(WindowListener controlador) {
		this.addWindowListener(controlador);
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
	
	// Para el formulario

	@Override
	public FormTickets getForm() {
		return this.form;
	}

	@Override
	public void mostrarFormTicket() {
		this.form.setVisible(true);
	}

	@Override
	public void ocultarFormTicket() {
		this.form.setVisible(false);
	}
	
	// Ventanas

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
	public void cambiarPagina(int i) {
		this.pantallasTab.setSelectedIndex(i);
	}

	@Override
	public void setCantidadTickets(String cant) {
		this.cantTicketsLabel.setText(cant);
	}

	@Override
	public void llenarDatosEmpleador(String nombre, String tipoPersona, String rubro, String usuario) {
		if (nombre.equals(" "))
			this.nombreLabel.setText("-");
		else
			this.nombreLabel.setText(nombre);
		if (rubro.equals(" "))
			this.rubroLabel.setText("-");
		else
			this.rubroLabel.setText(rubro);
		this.usuarioLabel.setText(usuario);
		this.entidadLabel.setText(tipoPersona);
	}

	public void renderListaTicketsEmpleador(ArrayList<Ticket_de_Busqueda_de_Empleado> tickets) {
		DefaultListModel<Ticket_de_Busqueda_de_Empleado> listaTicketsDefault = new DefaultListModel<>();

		for(int i = 0 ; i < tickets.size() ; i++)
			listaTicketsDefault.addElement(tickets.get(i));
		if (list_1.getModel().getSize() != 0)
			((DefaultListModel) list_1.getModel()).removeAllElements();
		this.list_1.setModel(listaTicketsDefault);
		scrollPane.setViewportView(list_1);
		this.setCantidadTickets(Integer.toString(tickets.size()));
	}
	
	@Override
	public void renderListaElecciones(TreeSet<Ticket> list) {
		if (list == null || list.size() == 0)
			lblNewLabel = new JLabel("Todavia no se efectuo la ronda de contratos laborales.");
		else {
			lblNewLabel.setText("Ofertas laborales encontradas , seleccione una");
			DefaultListModel<Ticket> tickets = new DefaultListModel<Ticket>();
			Iterator <Ticket>it = list.iterator();
			while (it.hasNext())
				tickets.addElement(it.next());
			this.listaElecciones = new JList<Ticket>();
			this.listaElecciones.setModel(tickets);
			//scrollPane_1.setViewportView(listaElecciones);
		}
	}

	public void renderVentanaVistas(int cantidad, TreeSet<Ticket> list) {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(31, 155, 539, 276);
		for (int i = 0 ; i< cantidad ; i++) {
			tab3.add(tabbedPane);
			scrollPane_3 = new JScrollPane();
			tabbedPane.addTab("Ticket " + (1 + i), null, scrollPane_3, null);
			lblNewLabel.setText("Ofertas laborales encontradas , seleccione una");
			DefaultListModel<Ticket> tickets = new DefaultListModel<Ticket>();
			Iterator <Ticket>it = list.iterator();
			while (it.hasNext())
				tickets.addElement(it.next());
			this.listaElecciones = new JList<>();
			this.listaElecciones.setModel(tickets);
			scrollPane_3.setViewportView(listaElecciones);
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
	public void confirmarSeleccion() {
		lblNewLabel.setText("Empleado seleccionado , espere los resultados");
		this.listaElecciones.setVisible(false);
		this.seleccionarEmpleadorButton.setVisible(false);
	}


	public int getTabSeleccionado() {
		return tabbedPane.getSelectedIndex();
	}

	//METODOS QUE NO SE USAN
	@Override
	public void llenarDatosEmpleado(String nombre, String apellido, String email, String telefono, int edad) {
		// TODO Auto-generated method stub
	}

	@Override
	public void renderListaTicketsEmpleado(Ticket ticket) {
		// TODO Auto-generated method stub
	}
}
