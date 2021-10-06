package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import DAO.ConexBD;
import Vista.FormularioChangeEmpresa;
import Vista.FormularioLogin;

public class ControlFormularioChangeEmpresa {
	
	public ControlFormularioChangeEmpresa() {
		// TODO Auto-generated constructor stub
	}
	public void fce_cambiarEmpresas(FormularioChangeEmpresa fce, FormularioLogin fl, ConexBD conn) {
		fce.formularioChangeEmpresa.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				fl.ventanaInicio.setVisible(true);
				fl.jtabLogin.setSelectedIndex(0);
				
			}
		});
		fce.btn_aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fce.formularioChangeEmpresa.setVisible(false);
				fl.txt_empresa.setText(fce.cb_Empresas.getSelectedItem().toString());
				ArrayList<String>locales = conn.getListLocales(fl.txt_empresa.getText());
				for(String local:locales) {
					fl.cb_local.addItem(local);
				}
				ArrayList<String>cargos = conn.getListFunciones(fl.txt_empresa.getText());
				for(String cargo:cargos) {
					fl.cb_cargo.addItem(cargo);
				}
				fl.ventanaInicio.setVisible(true);
				fl.jtabLogin.setSelectedIndex(0);
			}
		});
	}

}
