package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import modelo.Sistema;
import modelo.usuarios.Agencia;
import modelo.usuarios.Usuario;

public class VentanaSimulacionThreads extends JFrame implements IVistaSimulacion, Observer{
	
    private JPanel contentPane;
    private JButton btnComenzar;
    private JPanel panelOeste;
    private JPanel panel_Arriba;
    private JPanel panel_Centro;
    private JPanel panel;
    private PanelThread panelthread;
    private JTextField textField;
    private JScrollPane scrollPane;
	private JTextArea textArea;
	private Agencia agencia;

    
    
    public VentanaSimulacionThreads()
    {
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
	
	this.btnComenzar = new JButton("Comenzar");
	this.panel_Arriba.add(this.btnComenzar);
	this.btnComenzar.setActionCommand("Comenzar");
	
	setPreferredSize(new Dimension(300, 300));
	//setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),"Title", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
	setLayout(new BorderLayout(0, 0));
	
	this.scrollPane = new JScrollPane();
	add(this.scrollPane, BorderLayout.CENTER);
	
	this.textArea = new JTextArea();
	this.scrollPane.setViewportView(this.textArea);
	
	this.agencia = Sistema.getInstance().getAgencia();
    this.agencia.addObserver(this);

    }

    private void setBorder(CompoundBorder compoundBorder) {
		// TODO Auto-generated method stub
		
	}

	public void addActionListener(ActionListener listener)
    {
    	this.btnComenzar.addActionListener(listener);
    	
    }

	@Override
	public void actualizaLista(Iterator<Usuario> iteratorUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o==this.agencia) 
		{
		    this.textArea.append(arg+"\n");
		}
		else throw new IllegalArgumentException();
		
	}    

}
