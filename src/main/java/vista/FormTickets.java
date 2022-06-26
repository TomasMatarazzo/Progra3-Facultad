package vista;

import modelo.constantes.Puntajes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.Color;

public class FormTickets extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCargaHoraria;
	private JLabel lblTipoPuestoLaboral;
	private JLabel lblRangoHorario;
	private JLabel lblExperienciaPrevia;
	private JLabel lblEstudiosCursados;
	private Choice estudiosForm;
	private Choice cargaHorariaaForm;
	private Choice tipoPueestoLaboral;
	private Choice edadForm;
	private JLabel lblNewLabel_1;
	private JTextField formRenumeracion;
	public JButton crearTicketButton;
	public String puesto ;
	public String renumeracion ;
	public int cargaHoraria ;
	public int  estudios ;
	public int edad ;
	public int experiencia;
	public int tipoPuesto;
	private Choice locacionForm;
	private Choice lblLocacion;
	private JLabel lblLocacion_1;
	public String locacion;
	private Choice experienciaForm;

	public FormTickets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setForeground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Renumeracion");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel.setBounds(27, 44, 124, 27);
		contentPane.add(lblNewLabel);
		
		lblCargaHoraria = new JLabel("Carga horaria");
		lblCargaHoraria.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblCargaHoraria.setBounds(172, 108, 122, 27);
		contentPane.add(lblCargaHoraria);
		
		lblTipoPuestoLaboral = new JLabel("Tipo Puesto Laboral");
		lblTipoPuestoLaboral.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblTipoPuestoLaboral.setBounds(173, 163, 165, 27);
		contentPane.add(lblTipoPuestoLaboral);
		
		lblRangoHorario = new JLabel("Rango Etario");
		lblRangoHorario.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblRangoHorario.setBounds(27, 163, 165, 27);
		contentPane.add(lblRangoHorario);
		
		lblExperienciaPrevia = new JLabel("Experiencia previa");
		lblExperienciaPrevia.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblExperienciaPrevia.setBounds(173, 44, 165, 27);
		contentPane.add(lblExperienciaPrevia);
		
		lblEstudiosCursados = new JLabel("Estudios cursados");
		lblEstudiosCursados.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblEstudiosCursados.setBounds(27, 108, 165, 27);
		contentPane.add(lblEstudiosCursados);
		
		estudiosForm = new Choice();
		estudiosForm.setForeground(Color.BLACK);
		estudiosForm.addItem("Primario");
		estudiosForm.addItem("Secundario");
		estudiosForm.addItem("Terciario");
		estudiosForm.setBounds(27, 141, 124, 16);
		contentPane.add(estudiosForm);
		
		cargaHorariaaForm = new Choice();
		cargaHorariaaForm.setForeground(Color.BLACK);
		cargaHorariaaForm.setBounds(173, 141, 124, 16);
		cargaHorariaaForm.addItem("Media");
		cargaHorariaaForm.addItem("Completa");
		cargaHorariaaForm.addItem("Extendida");
		contentPane.add(cargaHorariaaForm);
		
		tipoPueestoLaboral = new Choice();
		tipoPueestoLaboral.setForeground(Color.BLACK);
		tipoPueestoLaboral.setBounds(173, 196, 124, 21);
		tipoPueestoLaboral.addItem(Puntajes.getPuesto1());
		tipoPueestoLaboral.addItem(Puntajes.getPuesto2());
		tipoPueestoLaboral.addItem(Puntajes.getPuesto3());
		contentPane.add(tipoPueestoLaboral);
		
		edadForm = new Choice();
		edadForm.setForeground(Color.BLACK);
		edadForm.setBounds(27, 196, 124, 26);
		edadForm.addItem(Puntajes.NOMBRES_FORM_BUSQUEDA[2][0]);
		edadForm.addItem(Puntajes.NOMBRES_FORM_BUSQUEDA[2][1]);
		edadForm.addItem(Puntajes.NOMBRES_FORM_BUSQUEDA[2][2]);
		contentPane.add(edadForm);
		
		lblNewLabel_1 = new JLabel("Formulario de Ticket");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(75, 8, 223, 28);
		contentPane.add(lblNewLabel_1);
		
		formRenumeracion = new JTextField();
		formRenumeracion.setColumns(10);
		formRenumeracion.setBounds(27, 79, 124, 21);
		contentPane.add(formRenumeracion);
		
		crearTicketButton = new JButton("Crear Ticket");
		crearTicketButton.setActionCommand("CREARTICKET");
		crearTicketButton.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		crearTicketButton.setBackground(new Color(240, 240, 240));
		crearTicketButton.setBounds(121, 227, 138, 25);
		contentPane.add(crearTicketButton);
		
		locacionForm = new Choice();
		locacionForm.setForeground(Color.BLACK);
		locacionForm.setBounds(302, 141, 124, 16);
		locacionForm.addItem("HomeOffice");
		locacionForm.addItem("Presencial");
		locacionForm.addItem("Indistinto");
		contentPane.add(locacionForm);
		
		
		lblLocacion_1 = new JLabel("Locacion");
		lblLocacion_1.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblLocacion_1.setBounds(302, 108, 165, 27);
		contentPane.add(lblLocacion_1);
		
		experienciaForm = new Choice();
		experienciaForm.setForeground(Color.BLACK);
		experienciaForm.setBounds(170, 77, 124, 16);
		experienciaForm.addItem("Nada");
		experienciaForm.addItem("Media");
		experienciaForm.addItem("Mucha");
		contentPane.add(experienciaForm);
	}
	
	public void obtenerDatos() {
		 experiencia = this.experienciaForm.getSelectedIndex();
		 renumeracion = this.formRenumeracion.getText();
		 estudios =  this.estudiosForm.getSelectedIndex();
		 cargaHoraria = this.cargaHorariaaForm.getSelectedIndex();
		 edad = this.edadForm.getSelectedIndex();
		 tipoPuesto = this.tipoPueestoLaboral.getSelectedIndex();
		 locacion = this.locacionForm.getItem(this.locacionForm.getSelectedIndex());

	}
	
	public void cleanForms() {
		this.formRenumeracion.setText("");
	}
}