package Vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormularioCargoFuncion_Crear {
	public JInternalFrame formularioFuncion;
	private JPanel jpFuncion;
	private JLabel lbl_namefunc, lbl_catfunc, lbl_descrip;
	public JTextField txt_namefunc;
	public JComboBox<String> cb_tipofuncion;
	public JTextArea txt_descipfuncion;
	private JScrollPane jsp_descripfuncion;
	public JButton btn_crear;
	
	
	
	public FormularioCargoFuncion_Crear() {
		// TODO Auto-generated constructor stub
		construirFormFuncion();
	}
	public void construirFormFuncion() {
		formularioFuncion = new JInternalFrame("Funciones o Cargos");
		
		formularioFuncion.setSize(315, 205);
		formularioFuncion.setResizable(false);
		formularioFuncion.setClosable(true);
		formularioFuncion.setVisible(false);
		formularioFuncion.setLayout(null);
		formularioFuncion.add(construirPanelFuncion());
	}
	public JPanel construirPanelFuncion() {
		jpFuncion = new JPanel();
		jpFuncion.setBounds(1, 1, 305, 170);
		jpFuncion.setBackground(Color.cyan);
		jpFuncion.setLayout(null);
		
		lbl_namefunc = new JLabel("Nombre del cargo:");
		lbl_namefunc.setBounds(10, 15, 150, 20);
		txt_namefunc = new JTextField();
		txt_namefunc.setBounds(150, 15, 150, 20);
		lbl_catfunc = new JLabel("Tipo o Categoría:");
		lbl_catfunc.setBounds(10, 45, 150, 20);
		cb_tipofuncion = new JComboBox<String>();
		cb_tipofuncion.addItem("Categoría A");
		cb_tipofuncion.addItem("Categoría B");
		cb_tipofuncion.addItem("Categoría C");
		cb_tipofuncion.addItem("Categoría D");
		cb_tipofuncion.setBounds(150, 45, 150, 20);
		lbl_descrip = new JLabel("Descripción del cargo:");
		lbl_descrip.setBounds(10, 75, 150, 20);
		txt_descipfuncion = new JTextArea();
		txt_descipfuncion.setLineWrap(false);
		txt_descipfuncion.setWrapStyleWord(false);
		jsp_descripfuncion = new JScrollPane(txt_descipfuncion);
		jsp_descripfuncion.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp_descripfuncion.setBounds(150, 75, 150, 60);
		btn_crear = new JButton("Crear");
		btn_crear.setBounds(100, 145, 100, 20);
		
		jpFuncion.add(lbl_namefunc);
		jpFuncion.add(txt_namefunc);
		jpFuncion.add(lbl_catfunc);
		jpFuncion.add(cb_tipofuncion);
		jpFuncion.add(lbl_descrip);
		jpFuncion.add(jsp_descripfuncion);
		jpFuncion.add(btn_crear);
		return jpFuncion;
	}
	


}
