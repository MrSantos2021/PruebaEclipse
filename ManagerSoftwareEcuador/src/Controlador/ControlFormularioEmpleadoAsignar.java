package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ConexBD;
import Vista.FormularioPersonalAsignar;
import Vista.VentanaPrincipal;

public class ControlFormularioEmpleadoAsignar {
	
	public ControlFormularioEmpleadoAsignar() {
		// TODO Auto-generated constructor stub
	}
	
	public void asignar_ventanaFormulario(VentanaPrincipal vp, FormularioPersonalAsignar fpa, ConexBD conn) {
		vp.jmi_designacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(fpa.ventanaEmpleadoAsignar.isShowing()) {
					JOptionPane.showMessageDialog(null, "Doble ventana");
				}else {
					vp.deskPrincipal.add(fpa.ventanaEmpleadoAsignar);
					fpa.ventanaEmpleadoAsignar.show();
					
					fpa.opcRadio.clearSelection();
					fpa.cb_user.setEnabled(false);
					fpa.cb_user.removeAllItems();
					ArrayList<String>usuarios = conn.listaEmpleado(vp.ventanaApp.getTitle());
					for(String user:usuarios) {
						fpa.cb_user.addItem(user);
					}
					fpa.cb_local.setEnabled(false);
					fpa.cb_local.removeAllItems();
					ArrayList<String>locales = conn.getListLocales(vp.ventanaApp.getTitle());
					for(String local:locales) {
						fpa.cb_local.addItem(local);
					}
					fpa.cb_cargo.setEnabled(false);
					fpa.cb_cargo.removeAllItems();
					ArrayList<String>funciones = conn.getListFuncionesAll(vp.ventanaApp.getTitle());
					for(String funcion:funciones) {
						fpa.cb_cargo.addItem(funcion);
					}
					fpa.txt_pass.setEnabled(false);
					fpa.btn_add.setEnabled(false);
					fpa.btn_actualizar.setEnabled(false);
					fpa.btn_guardar.setEnabled(false);
					fpa.btn_reg.setEnabled(false);
				}
			}
		});
		fpa.opcAsig.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fpa.cb_user.setEnabled(true);
				fpa.cb_local.setEnabled(true);
				fpa.cb_cargo.setEnabled(true);
				fpa.txt_pass.setEnabled(true);
				fpa.btn_add.setEnabled(true);
				fpa.btn_actualizar.setEnabled(false);
				fpa.btn_guardar.setEnabled(true);
				fpa.btn_reg.setEnabled(true);
			}
		});
		fpa.opcModif.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fpa.cb_user.setEnabled(true);
				fpa.cb_local.setEnabled(true);
				fpa.cb_cargo.setEnabled(true);
				fpa.txt_pass.setEnabled(true);
				fpa.btn_add.setEnabled(false);
				fpa.btn_actualizar.setEnabled(true);
				fpa.btn_guardar.setEnabled(true);
				fpa.btn_reg.setEnabled(true);
			}
		});


	}

}
