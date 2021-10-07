package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.ConexBD;
import DTO.CargoFuncion;
import Vista.FormularioCargoFuncion_Crear;
import Vista.VentanaPrincipal;

public class ControlFormularioFuncion {
	private CargoFuncion funcion = new CargoFuncion();
	
	public ControlFormularioFuncion() {
		// TODO Auto-generated constructor stub
	}
	public void funcion_ventanaFormulario(VentanaPrincipal vp, FormularioCargoFuncion_Crear fcf, ConexBD conn) {
		
		
		vp.jmi_funcioncrear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(fcf.formularioFuncion.isShowing()) {
					JOptionPane.showMessageDialog(null, "La ventana Función o Cargo ya está abierto", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}else {
					vp.deskPrincipal.add(fcf.formularioFuncion);
					fcf.formularioFuncion.show();
				}
			}
		});
		fcf.btn_crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				funcion.setNombre(fcf.txt_namefunc.getText());
				funcion.setCategoria(fcf.cb_tipofuncion.getSelectedItem().toString());
				funcion.setDescrip(fcf.txt_descipfuncion.getText());
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Creado un nuevo cargo", "Función o Cargo", JOptionPane.INFORMATION_MESSAGE);
				conn.crearFuncion(vp.ventanaApp.getTitle(), funcion.getNombre(), funcion.getCategoria(), funcion.getDescrip());
				fcf.formularioFuncion.dispose();
				
				fcf.txt_namefunc.setText("");
				fcf.cb_tipofuncion.setSelectedIndex(0);
				fcf.txt_descipfuncion.setText("");
			}
		});
	}
	

}
