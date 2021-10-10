package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ConexBD;
import DTO.Empresa;
import Vista.FormularioAddEmpresa;
import Vista.FormularioLogin;

public class ControlFormularioAddCompany {
	private Empresa empresa = new Empresa();
	
	public ControlFormularioAddCompany() {
		// TODO Auto-generated constructor stub
	}
	public void fae_ventanaFormAddEmpresa(FormularioAddEmpresa fae, FormularioLogin fl) {
		fae.opcRadio.clearSelection();
		fae.cb_empresas.setEnabled(false);
		fae.txt_nameEmp.setEnabled(false);
		fae.txt_nameEmp.setText("");
		fae.txt_ruc.setEnabled(false);
		fae.txt_ruc.setText("");
		fae.cb_actividad.setEnabled(false);
		fae.cb_actividad.setSelectedIndex(0);
		fae.cb_tamanio.setEnabled(false);
		fae.cb_tamanio.setSelectedIndex(0);
		fae.cb_capital.setEnabled(false);
		fae.cb_capital.setSelectedIndex(0);
		fae.cb_ambito.setEnabled(false);
		fae.cb_ambito.setSelectedIndex(0);
		fae.cb_beneficio.setEnabled(false);
		fae.cb_beneficio.setSelectedIndex(0);
		fae.cb_fjuridico.setEnabled(false);
		fae.cb_fjuridico.setSelectedIndex(0);
		fae.cb_produccion.setEnabled(false);
		fae.cb_produccion.setSelectedIndex(0);
		fae.txt_socios.setEnabled(false);
		fae.txt_socios.setText("");
		fae.contribespc.setEnabled(false);
		fae.contribespc.setSelected(false);
		fae.btn_aceptar.setEnabled(false);
		
		fae.formularioAddEmpresa.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				fae.opcRadio.clearSelection();
				fae.cb_empresas.setEnabled(false);
				fae.txt_nameEmp.setEnabled(false);
				fae.txt_nameEmp.setText("");
				fae.txt_ruc.setEnabled(false);
				fae.txt_ruc.setText("");
				fae.cb_actividad.setEnabled(false);
				fae.cb_actividad.setSelectedIndex(0);
				fae.cb_tamanio.setEnabled(false);
				fae.cb_tamanio.setSelectedIndex(0);
				fae.cb_capital.setEnabled(false);
				fae.cb_capital.setSelectedIndex(0);
				fae.cb_ambito.setEnabled(false);
				fae.cb_ambito.setSelectedIndex(0);
				fae.cb_beneficio.setEnabled(false);
				fae.cb_beneficio.setSelectedIndex(0);
				fae.cb_fjuridico.setEnabled(false);
				fae.cb_fjuridico.setSelectedIndex(0);
				fae.cb_produccion.setEnabled(false);
				fae.cb_produccion.setSelectedIndex(0);
				fae.txt_socios.setEnabled(false);
				fae.txt_socios.setText("");
				fae.contribespc.setEnabled(false);
				fae.contribespc.setSelected(false);
				fae.btn_aceptar.setEnabled(false);
				
				fl.ventanaInicio.setVisible(true);
				fl.jtabLogin.setSelectedIndex(0);
				fl.btn_conex.setEnabled(false);
				fl.jtabLogin.setEnabledAt(1, true);
				fl.txt_empresa.setEditable(false);
				fl.cb_local.setEnabled(true);
				fl.cb_cargo.setEnabled(true);
				fl.cb_usuario.setEnabled(true);
				fl.txt_pass.setEditable(false);
				fl.btn_inicio.setEnabled(true);		
			}
		});
	}
	public void addEmpresa(FormularioAddEmpresa fae, FormularioLogin fl, ConexBD conn) {
		fae.txt_ruc.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() >= '0' && e.getKeyChar() <='9') {
					e.consume();
				}else {
					JOptionPane.showMessageDialog(null, "Favor de ingresar solo números.", "Aviso de digitar RUC", JOptionPane.ERROR_MESSAGE);
					fae.txt_ruc.setText("");
				}
			}
		});
		fae.opcSi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fae.cb_empresas.setEnabled(false);
				fae.txt_nameEmp.setEnabled(true);
				fae.txt_ruc.setEnabled(true);
				fae.txt_ruc.setText("");
				fae.cb_actividad.setEnabled(true);
				fae.cb_tamanio.setEnabled(true);
				fae.cb_capital.setEnabled(true);
				fae.cb_ambito.setEnabled(true);
				fae.cb_beneficio.setEnabled(true);
				fae.cb_fjuridico.setEnabled(true);
				fae.cb_produccion.setEnabled(true);
				fae.txt_socios.setEnabled(true);
				fae.contribespc.setEnabled(true);
				fae.btn_aceptar.setEnabled(true);
			}
		});
		
		fae.opcNo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fae.cb_empresas.setEnabled(true);
				fae.txt_nameEmp.setEnabled(true);
				fae.txt_ruc.setEnabled(false);
				fae.cb_actividad.setEnabled(true);
				fae.cb_tamanio.setEnabled(true);
				fae.cb_capital.setEnabled(true);
				fae.cb_ambito.setEnabled(true);
				fae.cb_beneficio.setEnabled(true);
				fae.cb_fjuridico.setEnabled(true);
				fae.cb_produccion.setEnabled(true);
				fae.txt_socios.setEnabled(true);
				fae.contribespc.setEnabled(true);
				fae.btn_aceptar.setEnabled(true);
			}
		});
		
		fae.btn_aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				empresa.setEmp_nombre(fae.txt_nameEmp.getText());
				empresa.setEmp_ruc(fae.txt_ruc.getText());
				empresa.setEmp_actividad(fae.cb_actividad.getSelectedItem().toString());
				empresa.setEmp_tamanio(fae.cb_tamanio.getSelectedItem().toString());
				empresa.setEmp_capital(fae.cb_capital.getSelectedItem().toString());
				empresa.setEmp_ambito(fae.cb_ambito.getSelectedItem().toString());
				empresa.setEmp_beneficio(fae.cb_beneficio.getSelectedItem().toString());
				empresa.setEmp_fjuridico(fae.cb_fjuridico.getSelectedItem().toString());
				empresa.setEmp_produccion(fae.cb_produccion.getSelectedItem().toString());
				empresa.setEmp_socios(fae.txt_socios.getText());
				empresa.setEmp_ce(fae.contribespc.isSelected()?true:false);
				if(fae.opcSi.isSelected()) {	
					empresa.setEmp_subcorp(fae.cb_empresas.getItemCount()+1);
				}
				if(fae.opcNo.isSelected()) {
					
					empresa.setEmp_subcorp(fae.cb_empresas.getSelectedIndex()+1);
				}
				JOptionPane.showMessageDialog(null, "Has creado una nueva empresa: "+ empresa.getEmp_nombre());
				conn.registrarEmpresa(empresa.getEmp_nombre(), empresa.getEmp_ruc(), empresa.getEmp_actividad(), empresa.getEmp_tamanio(), empresa.getEmp_capital(), empresa.getEmp_ambito(), empresa.getEmp_beneficio(), empresa.getEmp_fjuridico(), empresa.getEmp_produccion(), empresa.getEmp_socios(), empresa.isEmp_ce(), empresa.getEmp_subcorp());
				conn.crearLocalDefault(empresa.getEmp_nombre());
				conn.crearFuncionDefault(empresa.getEmp_nombre());
				conn.asignacion(empresa.getEmp_nombre(), "User 1", "Local A", "Técnico", "111");
				
				fl.txt_empresa.setText(empresa.getEmp_nombre());
				ArrayList<String>locales = conn.getListLocales(empresa.getEmp_nombre());
				for(String local:locales) {
					fl.cb_local.addItem(local);
				}
				ArrayList<String>cargos = conn.getListFunciones(empresa.getEmp_nombre());
				for(String cargo:cargos) {
					fl.cb_cargo.addItem(cargo);
				}
				
				fae.formularioAddEmpresa.setVisible(false);
				fae.opcRadio.clearSelection();
				fae.cb_empresas.setEnabled(false);
				fae.txt_nameEmp.setEnabled(false);
				fae.txt_nameEmp.setText("");
				fae.txt_ruc.setEnabled(false);
				fae.txt_ruc.setText("");
				fae.cb_actividad.setEnabled(false);
				fae.cb_actividad.setSelectedIndex(0);
				fae.cb_tamanio.setEnabled(false);
				fae.cb_tamanio.setSelectedIndex(0);
				fae.cb_capital.setEnabled(false);
				fae.cb_capital.setSelectedIndex(0);
				fae.cb_ambito.setEnabled(false);
				fae.cb_ambito.setSelectedIndex(0);
				fae.cb_beneficio.setEnabled(false);
				fae.cb_beneficio.setSelectedIndex(0);
				fae.cb_fjuridico.setEnabled(false);
				fae.cb_fjuridico.setSelectedIndex(0);
				fae.cb_produccion.setEnabled(false);
				fae.cb_produccion.setSelectedIndex(0);
				fae.txt_socios.setEnabled(false);
				fae.txt_socios.setText("");
				fae.contribespc.setEnabled(false);
				fae.contribespc.setSelected(false);
				fae.btn_aceptar.setEnabled(false);
						
				fl.ventanaInicio.setVisible(true);
				fl.jtabLogin.setSelectedIndex(0);
			}
		});
	}
}
