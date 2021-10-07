package Vista;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class FormularioPersonal {
	public JInternalFrame ventanaEmpleado;
	public JTabbedPane jtb_empleado = new JTabbedPane();
	public JPanel  jp_datos, jpExperiencia, jpEstudios, jpContactos; 
	public JLabel lbl_nombre1, lbl_nombre2, lbl_apellido1, lbl_apellido2;
	public JTextField txt_nombre1, txt_nombre2, txt_apellido1, txt_apellido2;
	public JButton btn_aceptar;
	
	
	public FormularioPersonal() {
		// TODO Auto-generated constructor stub
		mostrarVentanaEmpleado();
	}
	public JPanel bloqueDatos() {
		jp_datos = new JPanel();
		jp_datos.setLayout(null);
		jp_datos.setBounds(1, 1, 400, 300);
		lbl_nombre1 = new JLabel("Primer nombre:");
		lbl_nombre1.setBounds(10, 15, 150, 20);
		txt_nombre1 = new JTextField();
		txt_nombre1.setBounds(120, 15, 150, 20);
		lbl_nombre2 = new JLabel("Segundo nombre:");
		lbl_nombre2.setBounds(300, 15, 150, 20);
		txt_nombre2 = new JTextField();
		txt_nombre2.setBounds(420, 15, 150, 20);
		lbl_apellido1 = new JLabel("Primer apellido:");
		lbl_apellido1.setBounds(10, 45, 150, 20);
		txt_apellido1 = new JTextField();
		txt_apellido1.setBounds(120, 45, 150, 20);
		lbl_apellido2 = new JLabel("Segundo apellido:");
		lbl_apellido2.setBounds(300, 45, 150, 20);
		txt_apellido2 = new JTextField();
		txt_apellido2.setBounds(420, 45, 150, 20);
		
		jp_datos.add(lbl_nombre1);
		jp_datos.add(txt_nombre1);
		jp_datos.add(lbl_nombre2);
		jp_datos.add(txt_nombre2);
		jp_datos.add(lbl_apellido1);
		jp_datos.add(txt_apellido1);
		jp_datos.add(lbl_apellido2);
		jp_datos.add(txt_apellido2);
		return jp_datos;
	}
	public JPanel bloqueExperiencia() {
		jpExperiencia = new JPanel();
		jpExperiencia.setBounds(1, 1, 300, 300);
		return jpExperiencia;
	}
	public JPanel bloqueEstudios() {
		jpEstudios =  new JPanel();
		jpEstudios.setBounds(1, 1, 300, 300);
		return jpEstudios;
		
	}
	public JPanel bloqueContactos() {
		jpContactos = new JPanel();
		jpContactos.setBounds(1, 1, 300, 300);
		btn_aceptar = new JButton("Aceptar y Grabar");
		btn_aceptar.setBounds(50, 50, 100, 20);
		jpContactos.add(btn_aceptar);
		return jpContactos;
	}
	
	public void mostrarVentanaEmpleado() {
		jtb_empleado.setBounds(1, 1, 580, 365);
		jtb_empleado.add("Datos Personales", bloqueDatos());
		jtb_empleado.add("Experiencia Laboral", bloqueExperiencia());
		jtb_empleado.add("Estudios", bloqueEstudios());
		jtb_empleado.add("Contactos",bloqueContactos());
		
		ventanaEmpleado = new JInternalFrame("Datos del empleado");
		ventanaEmpleado.setSize(590, 400);
		ventanaEmpleado.setResizable(false);
		ventanaEmpleado.setClosable(true);
		ventanaEmpleado.setLayout(null);
		ventanaEmpleado.add(jtb_empleado);	
	}

}
