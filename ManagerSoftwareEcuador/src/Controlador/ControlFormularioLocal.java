package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ConexBD;
import DTO.Local;
import Vista.FormularioLocal;
import Vista.VentanaPrincipal;

public class ControlFormularioLocal {
	private Local local = new Local();
	
	public ControlFormularioLocal() {
		// TODO Auto-generated constructor stub
	
	}
	public void local_ventana(VentanaPrincipal vp, FormularioLocal formLocal, ConexBD conn) {
		
		
		vp.jmi_local.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(formLocal.ventanaFormLocal.isShowing()) {
					JOptionPane.showMessageDialog(null, "La ventana LOCAL ya está abierta", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}else {
					vp.deskPrincipal.add(formLocal.ventanaFormLocal);
					formLocal.ventanaFormLocal.show();
					formLocal.bg_opciones.clearSelection();
					formLocal.txt_id.setText("");
					formLocal.cb_locales.removeAllItems();
					ArrayList<String>locales = conn.getListLocales(vp.ventanaApp.getTitle());
					for(String local:locales) {
						formLocal.cb_locales.addItem(local);
					}
					formLocal.cb_locales.setSelectedIndex(0);
					formLocal.txt_id.setEditable(false);
					formLocal.txt_id.setEnabled(true);
					formLocal.cb_tipo.setEnabled(false);
					formLocal.cb_tipo.setSelectedIndex(0);
					formLocal.txt_nombre.setEnabled(false);
					formLocal.txt_nombre.setEditable(false);
					formLocal.txt_nombre.setText("");
					formLocal.cb_prov.setEnabled(false);
					formLocal.cb_prov.setSelectedIndex(0);
					formLocal.cb_ciudad.setEnabled(false);
					formLocal.txt_dir.setEnabled(false);
					formLocal.txt_dir.setEditable(false);
					formLocal.txt_dir.setText("");
					formLocal.txt_telf1.setEnabled(false);
					formLocal.txt_telf1.setEditable(false);
					formLocal.txt_telf1.setText("");
					formLocal.txt_telf2.setEnabled(false);
					formLocal.txt_telf2.setEditable(false);
					formLocal.txt_telf2.setText("");
					formLocal.btn_aceptar.setEnabled(false);
					
					formLocal.opc_Crear.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							formLocal.cb_locales.setEnabled(false);
							formLocal.cb_locales.setSelectedIndex(0);
							int tempId = (conn.getIdLocal()+1);
							formLocal.txt_id.setText(String.valueOf(tempId));
							formLocal.txt_id.setEditable(false);
							formLocal.txt_id.setEnabled(true);
							formLocal.cb_tipo.setEnabled(true);
							formLocal.cb_tipo.setSelectedIndex(0);
							formLocal.txt_nombre.setEnabled(true);
							formLocal.txt_nombre.setEditable(true);
							formLocal.txt_nombre.setText("");
							formLocal.cb_prov.setEnabled(true);
							formLocal.cb_prov.setSelectedIndex(0);
							formLocal.cb_ciudad.setEnabled(true);
							formLocal.txt_dir.setEnabled(true);
							formLocal.txt_dir.setEditable(true);
							formLocal.txt_dir.setText("");
							formLocal.txt_telf1.setEnabled(true);
							formLocal.txt_telf1.setEditable(true);
							formLocal.txt_telf1.setText("");
							formLocal.txt_telf2.setEnabled(true);
							formLocal.txt_telf2.setEditable(true);
							formLocal.txt_telf2.setText("");
							formLocal.btn_aceptar.setEnabled(true);
						}
					});
					
					formLocal.opc_Modificar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							formLocal.cb_locales.setEnabled(true);
							formLocal.cb_locales.setSelectedIndex(0);
							formLocal.cb_locales.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									String tempEmpresa = vp.ventanaApp.getTitle();
									
									int totalLocales = formLocal.cb_locales.getItemCount();
									for(int i=0; i<=totalLocales; i++) {
										if(formLocal.cb_locales.getSelectedIndex() == i) {
											String tempLocal = formLocal.cb_locales.getSelectedItem().toString();
											conn.allDataLocalTbl(formLocal.txt_id, formLocal.cb_tipo, formLocal.txt_nombre, formLocal.cb_prov, formLocal.cb_ciudad, formLocal.txt_dir, formLocal.txt_telf1, formLocal.txt_telf2, tempEmpresa, tempLocal);
										}
									}
								}
							});
							formLocal.txt_id.setEnabled(true);
							formLocal.txt_id.setEditable(false);
							formLocal.cb_tipo.setEnabled(true);
							formLocal.cb_tipo.setSelectedIndex(0);
							formLocal.txt_nombre.setEnabled(true);
							formLocal.txt_nombre.setEditable(true);
							formLocal.cb_prov.setEnabled(true);
							formLocal.cb_prov.setSelectedIndex(0);
							formLocal.cb_ciudad.setEnabled(true);
							formLocal.txt_dir.setEnabled(true);
							formLocal.txt_dir.setEditable(true);
							formLocal.txt_telf1.setEnabled(true);
							formLocal.txt_telf1.setEditable(true);
							formLocal.txt_telf2.setEnabled(true);
							formLocal.txt_telf2.setEditable(true);
							formLocal.btn_aceptar.setEnabled(true);
						}
					});
					
					formLocal.opc_Ver.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							formLocal.cb_locales.setEnabled(true);
							formLocal.cb_locales.setSelectedIndex(0);
							formLocal.cb_locales.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									String tempEmpresa = vp.ventanaApp.getTitle();
									
									int totalLocales = formLocal.cb_locales.getItemCount();
									for(int i=0; i<=totalLocales; i++) {
										if(formLocal.cb_locales.getSelectedIndex() == i) {
											String tempLocal = formLocal.cb_locales.getSelectedItem().toString();
											conn.allDataLocalTbl(formLocal.txt_id, formLocal.cb_tipo, formLocal.txt_nombre, formLocal.cb_prov, formLocal.cb_ciudad, formLocal.txt_dir, formLocal.txt_telf1, formLocal.txt_telf2, tempEmpresa, tempLocal);
										}
									}
								}
							});
							formLocal.txt_id.setEditable(false);
							formLocal.cb_tipo.setEnabled(true);
							formLocal.txt_nombre.setEnabled(true);
							formLocal.txt_nombre.setEditable(false);
							formLocal.cb_prov.setEnabled(true);
							formLocal.cb_prov.setSelectedIndex(0);
							formLocal.cb_ciudad.setEnabled(true);
							formLocal.txt_dir.setEnabled(true);
							formLocal.txt_dir.setEditable(false);
							formLocal.txt_telf1.setEnabled(true);
							formLocal.txt_telf1.setEditable(false);
							formLocal.txt_telf2.setEnabled(true);
							formLocal.txt_telf2.setEditable(false);
							formLocal.btn_aceptar.setEnabled(true);
						}
					});
				}
			}
		});
		formLocal.btn_aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				local.setTipoLocal(formLocal.cb_tipo.getSelectedItem().toString());
				local.setNombreLocal(formLocal.txt_nombre.getText());
				local.setProvLocal(formLocal.cb_prov.getSelectedItem().toString());
				local.setCuidadLocal(formLocal.cb_ciudad.getSelectedItem().toString());
				local.setDirLocal(formLocal.txt_dir.getText());
				local.setTelf1(formLocal.txt_telf1.getText());
				local.setTelf2(formLocal.txt_telf2.getText());
				
				if(formLocal.opc_Crear.isSelected()) {
					conn.crearLocales(vp.ventanaApp.getTitle(), local.getTipoLocal(), local.getNombreLocal(), local.getProvLocal(), local.getCuidadLocal(), local.getDirLocal(), local.getTelf1(), local.getTelf2());
					JOptionPane.showMessageDialog(null, "Has creado un nuevo LOCAL.", "Registrado", JOptionPane.INFORMATION_MESSAGE);
				}else if(formLocal.opc_Modificar.isSelected()) {
					conn.updateLocal(local.getTipoLocal(), local.getNombreLocal(), local.getProvLocal(), local.getCuidadLocal(), local.getDirLocal(), local.getTelf1(), local.getTelf2(), vp.ventanaApp.getTitle(), formLocal.cb_locales.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, "Has actualizado los datos del LOCAL");
				}else {
					formLocal.ventanaFormLocal.setVisible(false);
					JOptionPane.showMessageDialog(null, "Has revisado la información del LOCAL");
				}
				
				formLocal.ventanaFormLocal.dispose();
			}
		});
	}

	
}
