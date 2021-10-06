package Vista;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioChangeEmpresa {
	public JFrame formularioChangeEmpresa;
	private JPanel jpChangeEmpresa;
	private JLabel lbl_EmpresaActual, lbl_EmpresaChange;
	public JTextField txt_EmpresaActual;
	public JComboBox<String>cb_Empresas;
	public JButton btn_aceptar;
	
	public FormularioChangeEmpresa() {
		// TODO Auto-generated constructor stub
		construirFormChangeEmpresa();
	
	}
	public void construirFormChangeEmpresa() {
		formularioChangeEmpresa = new JFrame("Cambio de Empresa");
		
		lbl_EmpresaActual = new JLabel("Empresa actual: ");
		lbl_EmpresaActual.setBounds(10, 20, 100, 20);
		txt_EmpresaActual = new JTextField();
		txt_EmpresaActual.setBounds(140, 20, 140, 20);
		lbl_EmpresaChange = new JLabel("Empresa a cambiar:");
		lbl_EmpresaChange.setBounds(10, 55, 120, 20);
		cb_Empresas = new JComboBox<String>();
		cb_Empresas.setBounds(140, 55, 140, 20);
		btn_aceptar = new JButton("Cambiar");
		btn_aceptar.setBounds(100, 85, 100, 20);
		
		jpChangeEmpresa = new JPanel();
		jpChangeEmpresa.setBounds(1, 1, 290, 120);
		jpChangeEmpresa.setBorder(BorderFactory.createTitledBorder("Información"));
		jpChangeEmpresa.setLayout(null);
		jpChangeEmpresa.add(lbl_EmpresaActual);
		jpChangeEmpresa.add(txt_EmpresaActual);
		jpChangeEmpresa.add(lbl_EmpresaChange);
		jpChangeEmpresa.add(cb_Empresas);
		jpChangeEmpresa.add(btn_aceptar);
		
		formularioChangeEmpresa.setSize(310, 170);
		formularioChangeEmpresa.setLocationRelativeTo(null);
		formularioChangeEmpresa.setResizable(false);
		formularioChangeEmpresa.setVisible(false);
		formularioChangeEmpresa.setLayout(null);
		formularioChangeEmpresa.add(jpChangeEmpresa);
	}

}
