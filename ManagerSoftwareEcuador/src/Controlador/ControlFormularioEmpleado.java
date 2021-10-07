package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.ConexBD;
import DTO.Persona_Cliente;
import Vista.FormularioPersonal;
import Vista.VentanaPrincipal;

public class ControlFormularioEmpleado {
	private Persona_Cliente empleado = new Persona_Cliente();
	
	public ControlFormularioEmpleado() {
		// TODO Auto-generated constructor stub
	}
	public void cfe_empleado(VentanaPrincipal vp, FormularioPersonal fp, ConexBD conn) {
		
		
		vp.jmi_empleado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fp.ventanaEmpleado.isShowing()) {
					JOptionPane.showMessageDialog(null, "Ya está abierta");
				}else {
					vp.deskPrincipal.add(fp.ventanaEmpleado);
					fp.ventanaEmpleado.show();
				}				
			}
		});
		
		fp.btn_aceptar.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				empleado.setNombre1(fp.txt_nombre1.getText());
				empleado.setNombre2(fp.txt_nombre2.getText());
				empleado.setApellido1(fp.txt_apellido1.getText());
				empleado.setApellido2(fp.txt_apellido2.getText());
				// TODO Auto-generated method stub
				conn.crearEmpleado(vp.ventanaApp.getTitle(), empleado.getNombre1(), empleado.getNombre2(), empleado.getApellido1(), empleado.getApellido2());
				JOptionPane.showMessageDialog(null, "Creado un nuevo empleado", "Nuevo Personal", JOptionPane.INFORMATION_MESSAGE);
				fp.ventanaEmpleado.dispose();
			}
		});
	}

}
