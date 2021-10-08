package Vista;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormularioPersonalAsignar {
	public JInternalFrame ventanaEmpleadoAsignar;
	public JRadioButton opcAsig, opcModif;
	public ButtonGroup opcRadio;
	public JPanel jpEmpleadoAsig;
	public JLabel lbl_user, lbl_local, lbl_cargo, lbl_pass;
	public JComboBox<String> cb_user, cb_local, cb_cargo;
	public JTextField txt_pass;
	public JButton btn_add, btn_actualizar, btn_guardar, btn_reg;
	public DefaultTableModel dtm_empleadoAsig;
	public JTable tbl_empleadoAsig;
	public JScrollPane jsp_empleadoAsig;
	
	public FormularioPersonalAsignar() {
		// TODO Auto-generated constructor stub
		mostrarVentanaAsignar();
	}
	
	public void mostrarVentanaAsignar() {
		ventanaEmpleadoAsignar = new JInternalFrame("Asignación");
		opcAsig = new JRadioButton("Asignar");
		opcAsig.setBounds(300, 10, 100, 20);
		opcModif = new JRadioButton("Modificar");
		opcModif.setBounds(400, 10, 100, 20);
		opcRadio = new ButtonGroup();
		opcRadio.add(opcAsig);
		opcRadio.add(opcModif);
		lbl_user = new JLabel("Usuario:");
		lbl_user.setBounds(10, 40, 150, 20);
		cb_user = new JComboBox<String>();
		cb_user.setBounds(10, 70, 150, 20);
		lbl_local = new JLabel("Local:");
		lbl_local.setBounds(220, 40, 150, 20);
		cb_local = new JComboBox<String>();
		cb_local.setBounds(220, 70, 150, 20);
		lbl_cargo = new JLabel("Función:");
		lbl_cargo.setBounds(410, 40, 150, 20);
		cb_cargo = new JComboBox<String>();
		cb_cargo.setBounds(410, 70, 150, 20);
		lbl_pass = new JLabel("Contraseña");
		lbl_pass.setBounds(620, 40, 150, 20);
		txt_pass = new JTextField();
		txt_pass.setBounds(620, 70, 150, 20);
		btn_add = new JButton("Asignar");
		btn_add.setBounds(250, 110, 100, 20);
		btn_actualizar = new JButton("Actualizar");
		btn_actualizar.setBounds(450, 110, 100, 20);
		
		dtm_empleadoAsig = new DefaultTableModel();
		dtm_empleadoAsig.addColumn("Usuario");
		dtm_empleadoAsig.addColumn("Local");
		dtm_empleadoAsig.addColumn("Función");
		dtm_empleadoAsig.addColumn("Contraseña:");
		
		tbl_empleadoAsig = new JTable(dtm_empleadoAsig);
		jsp_empleadoAsig = new JScrollPane(tbl_empleadoAsig);
		jsp_empleadoAsig.setBounds(10, 150, 765, 200);
		
		btn_guardar = new JButton("Guardar a la Base");
		btn_guardar.setBounds(220, 370, 150, 20);
		btn_reg = new JButton("Registro Diario");
		btn_reg.setBounds(420, 370, 150, 20);
		
		jpEmpleadoAsig = new JPanel();
		jpEmpleadoAsig.setBounds(1, 1, 785, 410);
		//jpEmpleadoAsig.setBackground(Color.CYAN);
		jpEmpleadoAsig.setLayout(null);
		jpEmpleadoAsig.add(opcAsig);
		jpEmpleadoAsig.add(opcModif);
		jpEmpleadoAsig.add(lbl_user);
		jpEmpleadoAsig.add(cb_user);
		jpEmpleadoAsig.add(lbl_local);
		jpEmpleadoAsig.add(cb_local);
		jpEmpleadoAsig.add(lbl_cargo);
		jpEmpleadoAsig.add(cb_cargo);
		jpEmpleadoAsig.add(lbl_pass);
		jpEmpleadoAsig.add(txt_pass);
		jpEmpleadoAsig.add(btn_add);
		jpEmpleadoAsig.add(btn_actualizar);
		jpEmpleadoAsig.add(jsp_empleadoAsig);
		jpEmpleadoAsig.add(btn_guardar);
		jpEmpleadoAsig.add(btn_reg);
		
		ventanaEmpleadoAsignar.setSize(800, 450);
		ventanaEmpleadoAsignar.setResizable(false);
		ventanaEmpleadoAsignar.setClosable(true);
		ventanaEmpleadoAsignar.setLayout(null);
		ventanaEmpleadoAsignar.add(jpEmpleadoAsig);
	}

}
