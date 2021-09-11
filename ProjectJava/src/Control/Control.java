package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import DAO.ConexionBD;
import Vista.InicioFormulario;

public class Control implements ActionListener, KeyListener {
	private InicioFormulario inicio;
	private ConexionBD conex = new ConexionBD();
	public Control() {
		// TODO Auto-generated constructor stub
		inicio = new InicioFormulario();
		conex.getConnection();
		inicio.btn_grabar.addActionListener(this);
		inicio.txt_name.addKeyListener(this);
		inicio.ventanaInicio.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				conex.desconectar();
			}
		});
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == inicio.btn_grabar) {
			if(inicio.txt_name.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "¡Favor de ingresar su nombre!", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
			}else if(inicio.txt_name.getText().startsWith(" ")){
				JOptionPane.showMessageDialog(null, "¡No debe tener espacio!. Ingrese su nombre.", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,"El usuario: "+inicio.txt_name.getText()+". Ha seleccionado: "+inicio.cb_personajes.getSelectedItem().toString(),"Informando", JOptionPane.INFORMATION_MESSAGE);
				conex.registarBD(inicio.txt_name.getText(), inicio.cb_personajes.getSelectedItem().toString(), inicio.cb_armas.getSelectedItem().toString());
				inicio.txt_name.setText("");
				inicio.cb_personajes.setSelectedIndex(0);
				inicio.cb_armas.setSelectedIndex(0);
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == inicio.txt_name) {
			char c = e.getKeyChar();
			if(Character.isDigit(c) == true) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Ingresar solo letras.", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
