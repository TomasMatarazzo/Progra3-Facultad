package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
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
	private Choice choice;
	private Choice choice_1;
	private Choice choice_2;
	private Choice choice_3;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;
	public JButton crearTicketButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTickets frame = new FormTickets();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		lblCargaHoraria.setBounds(27, 108, 122, 27);
		contentPane.add(lblCargaHoraria);
		
		lblTipoPuestoLaboral = new JLabel("Tipo Puesto Laboral");
		lblTipoPuestoLaboral.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblTipoPuestoLaboral.setBounds(196, 163, 165, 27);
		contentPane.add(lblTipoPuestoLaboral);
		
		lblRangoHorario = new JLabel("Rango Horario");
		lblRangoHorario.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblRangoHorario.setBounds(27, 163, 165, 27);
		contentPane.add(lblRangoHorario);
		
		lblExperienciaPrevia = new JLabel("Experiencia previa");
		lblExperienciaPrevia.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblExperienciaPrevia.setBounds(196, 44, 165, 27);
		contentPane.add(lblExperienciaPrevia);
		
		lblEstudiosCursados = new JLabel("Estudios cursados");
		lblEstudiosCursados.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblEstudiosCursados.setBounds(196, 108, 165, 27);
		contentPane.add(lblEstudiosCursados);
		
		choice = new Choice();
		choice.setForeground(Color.BLACK);
		choice.addItem("Home Office");
		choice.addItem("Presencial");
		choice.addItem("Indistinto");
		choice.setBounds(27, 141, 124, 16);
		contentPane.add(choice);
		
		choice_1 = new Choice();
		choice_1.setBounds(196, 141, 124, 16);
		choice_1.addItem("Media");
		choice_1.addItem("Completa");
		choice_1.addItem("Extendida");
		contentPane.add(choice_1);
		
		choice_2 = new Choice();
		choice_2.setBounds(196, 79, 124, 21);
		choice_2.addItem("Jr");
		choice_2.addItem("Sr");
		choice_2.addItem("Managment");
		contentPane.add(choice_2);
		
		choice_3 = new Choice();
		choice_3.setBounds(27, 196, 124, 26);
		choice_3.addItem("Menos de 40");
		choice_3.addItem("Menos de 50");
		choice_3.addItem("Mayor a 50");
		contentPane.add(choice_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(196, 198, 124, 21);
		contentPane.add(textField_1);
		
		lblNewLabel_1 = new JLabel("Formulario de Ticket");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(75, 8, 223, 28);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(27, 79, 124, 21);
		contentPane.add(textField_2);
		
		crearTicketButton = new JButton("Crear Ticket");
		crearTicketButton.setActionCommand("CREARTICKET");
		crearTicketButton.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		crearTicketButton.setBackground(new Color(240, 240, 240));
		crearTicketButton.setBounds(121, 227, 138, 25);
		contentPane.add(crearTicketButton);
	}
}
