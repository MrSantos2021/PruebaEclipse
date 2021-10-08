package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.ConexBD;
import Vista.FormularioAddEmpresa;
import Vista.FormularioChangeEmpresa;
import Vista.FormularioLogin;
import Vista.VentanaPrincipal;

public class ControlFormularioLogin {
	
	public ControlFormularioLogin() {
		// TODO Auto-generated constructor stub
		
	}
	public void cfl_ventanaLogin(FormularioLogin fl, JFrame ventana, ConexBD conn) {
		fl.ventanaInicio.setVisible(true);
		fl.jtabLogin.setEnabledAt(1, false);
		fl.txt_empresa.setEditable(false);
		fl.cb_local.setEnabled(false);
		fl.cb_cargo.setEnabled(false);
		fl.cb_usuario.setEnabled(false);
		fl.txt_pass.setEditable(false);
		fl.btn_inicio.setEnabled(false);
		fl.ventanaInicio.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(fl.btn_conex.isEnabled()) {
					JOptionPane.showMessageDialog(null, "Cerrando el Sistema");
				}else {
					conn.desconectar();
				}
			}
			
		});	
	}
	public void cfl_ConectarBD(FormularioLogin fl, ConexBD connBd) {
		fl.btn_conex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				connBd.getConnection();
				fl.txt_empresa.setText(connBd.nombreEmpresaHistorial());
				fl.cb_local.removeAllItems();
				ArrayList<String>locales = connBd.getListLocales(fl.txt_empresa.getText());
				for(String local:locales) {
					fl.cb_local.addItem(local);
				}
				fl.cb_cargo.removeAllItems();
				ArrayList<String>cargos = connBd.getListFunciones(fl.txt_empresa.getText());
				for(String cargo:cargos) {
					fl.cb_cargo.addItem(cargo);
				}
				fl.cb_local.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						fl.cb_usuario.removeAllItems();
						ArrayList<String>empleados = connBd.listaEmpleadoxLocal(fl.txt_empresa.getText(), fl.cb_local.getSelectedItem().toString());
						for(String empleado:empleados) {
							fl.cb_usuario.addItem(empleado);
						}
					}
				});
				
				fl.btn_conex.setEnabled(false);
				fl.jtabLogin.setEnabledAt(1, true);
				fl.txt_empresa.setEditable(false);
				fl.cb_local.setEnabled(true);
				fl.cb_cargo.setEnabled(true);
				fl.cb_usuario.setEnabled(true);
				fl.txt_pass.setEditable(true);
				fl.btn_inicio.setEnabled(true);		
			}
		});
	}
	public void cfl_ingresarLog(FormularioLogin fl, VentanaPrincipal vp, ConexBD conn) {
		fl.btn_inicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempEmpresa = fl.txt_empresa.getText();
				String tempLocal = fl.cb_local.getSelectedItem().toString();
				String tempUser = fl.cb_usuario.getSelectedItem().toString();
				String tempPass = String.valueOf(fl.txt_pass.getPassword());
				if(conn.loginIngreso(tempEmpresa, tempUser, tempPass) == true) {
					fl.ventanaInicio.setVisible(false);
					vp.ventanaApp.setVisible(true);
					vp.ventanaApp.setTitle(tempEmpresa);
					LocalDateTime inicioHora = LocalDateTime.now();
					LocalDate inicioFecha = LocalDate.now();
					String tempH = inicioHora.getHour()+":"+inicioHora.getMinute()+":"+inicioHora.getSecond();
					String tempF = inicioFecha.getYear()+"-"+inicioFecha.getMonthValue()+"-"+inicioFecha.getDayOfMonth();
					conn.regHistorialEmpresa(tempEmpresa, tempLocal, tempUser, tempH, tempF);	
				}else {
					JOptionPane.showMessageDialog(null, "Clave incorrecta", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
					fl.txt_pass.setText("");
					fl.ventanaInicio.setVisible(true);
					vp.ventanaApp.setVisible(false);
				}				
			}
		});	
	}
	public void cfl_addCompany(FormularioLogin fl, FormularioAddEmpresa fae) {
		fl.btn_addEmpresa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fl.ventanaInicio.setVisible(false);
				fae.formularioAddEmpresa.setVisible(true);
			}
		});
	}
	public void cfl_changeCompany(FormularioLogin fl, FormularioChangeEmpresa fce, ConexBD conn) {
		fl.btn_changeEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fl.ventanaInicio.setVisible(false);
				fce.formularioChangeEmpresa.setVisible(true);
				fce.txt_EmpresaActual.setText(conn.nombreEmpresaHistorial());
				fce.txt_EmpresaActual.setEditable(false);
				fce.cb_Empresas.removeAllItems();
				ArrayList<String> empresas = conn.empresasNombresList();
				for(String emp:empresas) {
					fce.cb_Empresas.addItem(emp);
				}
			}
		});
	}
}