package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Sistema;
import modelo.usuarios.Empleado_Pretenso;
import modelo.usuarios.Usuario;
import util.Util;
import vista.IVistaSimulacion;


public class ControladorThreads implements ActionListener{

	 private IVistaSimulacion vista = null;

	    public ControladorThreads(IVistaSimulacion vista)
	    {
		this.vista = vista;
		this.vista.addActionListener(this);
	    
	    }

	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	    	Thread q;
	    	String comando = e.getActionCommand();
	    	if (comando.equalsIgnoreCase("Comenzar"))
	    	{
	    		for (int t = 0 ; t<Sistema.getInstance().getEmpleadores().size() ; t++) {
	    	    	q = new Thread (Sistema.getInstance().getEmpleadores().get(t));
	    	    	q.start();
	     	    }
	    		for (int t = 0 ; t<Sistema.getInstance().getEmpleadosPretensos().size() ; t++) {
	    	    	q = new Thread (Sistema.getInstance().getEmpleadosPretensos().get(t));
	    	    	q.start();
	     	    }
	    }
	   }

}
