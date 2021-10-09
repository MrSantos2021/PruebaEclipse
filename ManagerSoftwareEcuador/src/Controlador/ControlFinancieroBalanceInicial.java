package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ConexBD;
import Vista.FormCont_BalanceIni;
import Vista.VentanaPrincipal;

public class ControlFinancieroBalanceInicial {
	public ControlFinancieroBalanceInicial() {
		// TODO Auto-generated constructor stub
	}
	public void ventana_balanceInicial(VentanaPrincipal vp, FormCont_BalanceIni balanceIni, ConexBD conn) {
		vp.jmi_balanceInic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(balanceIni.ventanaBalanceIni.isShowing()) {
					JOptionPane.showMessageDialog(null, "La ventana Balance Inicial ya está abierta");
				}else {
					vp.deskPrincipal.add(balanceIni.ventanaBalanceIni);
					balanceIni.ventanaBalanceIni.show();
					
					balanceIni.cb_ctaDebe.removeAllItems();
					ArrayList<String>ctasDebe = conn.planCtaList("Activos");
					for(String debe:ctasDebe) {
						balanceIni.cb_ctaDebe.addItem(debe);
					}
					balanceIni.cb_ctaHabe.removeAllItems();
					ArrayList<String>ctasHabe = conn.planCtaList("Pasivos");
					for(String habe:ctasHabe) {
						balanceIni.cb_ctaHabe.addItem(habe);
					}
				}
			}
		});
		balanceIni.btn_db.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tempCta = balanceIni.cb_ctaDebe.getSelectedItem().toString();
				String tempValor = balanceIni.txt_valordb.getText();
				String tempDet = balanceIni.txt_detalledb.getText();
				String[] infDebe = {tempCta, tempValor, tempDet};
				balanceIni.dtm_debe.addRow(infDebe);
				
				balanceIni.cb_ctaDebe.setSelectedIndex(0);
				balanceIni.txt_valordb.setText("");
				balanceIni.txt_detalledb.setText("");
			}
		});
		balanceIni.btn_hb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tempCtaHb = balanceIni.cb_ctaHabe.getSelectedItem().toString();
				String tempValorHb = balanceIni.txt_valorhb.getText();
				
				String[] infHabe = {tempCtaHb, tempValorHb};
				
				balanceIni.dtm_haber.addRow(infHabe);
				balanceIni.cb_ctaHabe.setSelectedIndex(0);
				balanceIni.txt_valorhb.setText("");
				balanceIni.txt_dethb.setText("");
			}
		});
		balanceIni.btn_verPat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int activos = 0;
				int pasivos = 0;
				int totalActivos = 0;
				int totalPasivos = 0;
				
				if(balanceIni.tbl_debe.getRowCount()>0) {
					for(int i=0; i<balanceIni.tbl_debe.getRowCount(); i++) {
						activos = Integer.parseInt((String) balanceIni.tbl_debe.getValueAt(i, 1));
						totalActivos += activos;
					}
				}else {
					JOptionPane.showMessageDialog(null, "No hay datos");
				}
				if(balanceIni.tbl_haber.getRowCount()>0) {
					for(int i=0; i<balanceIni.tbl_haber.getRowCount(); i++) {
						pasivos = Integer.parseInt((String) balanceIni.tbl_haber.getValueAt(i, 1));
						totalPasivos += pasivos;
					}
				}else {
					JOptionPane.showMessageDialog(null, "No hay datos");
				}
				int totalPatrimonio = totalActivos - totalPasivos;
				balanceIni.txt_valorpat.setText(String.valueOf(totalPatrimonio));
			}
		});
		balanceIni.btn_pat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tempCtaPat = balanceIni.txt_ctaPat.getText();
				String tempValorPat = balanceIni.txt_valorpat.getText();
				String[] infPat = {tempCtaPat, tempValorPat};
				balanceIni.dtm_patr.addRow(infPat);
			}
		});
		balanceIni.btn_grabar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int opc = JOptionPane.showConfirmDialog(null, "¿Están correctos los valores?", "Aviso", JOptionPane.YES_NO_OPTION);
				if(opc == JOptionPane.YES_OPTION) {
					int rowsdbs = balanceIni.tbl_debe.getRowCount();
					for(int rowdb=0; rowdb<rowsdbs; rowdb++) {
						LocalDate fechadb = LocalDate.now();
						String tempF = fechadb.getYear()+"-"+fechadb.getMonthValue()+"-"+fechadb.getDayOfMonth();
						String tempCta = (String) balanceIni.tbl_debe.getValueAt(rowdb, 0);
						String tempValor = (String) balanceIni.tbl_debe.getValueAt(rowdb, 1);
						String tempDet = (String) balanceIni.tbl_debe.getValueAt(rowdb, 2);
						
						conn.registrarLibroDiarioBalanceInicial(tempF, tempCta, tempValor, "0", tempDet);
					}
					int rowshbs = balanceIni.tbl_haber.getRowCount();
					for(int rowhb=0; rowhb<rowshbs; rowhb++) {
						LocalDate fechahb = LocalDate.now();
						String tempF = fechahb.getYear()+"-"+fechahb.getMonthValue()+"-"+fechahb.getDayOfMonth();
						String tempCta = (String) balanceIni.tbl_haber.getValueAt(rowhb, 0);
						String tempValor = (String) balanceIni.tbl_haber.getValueAt(rowhb, 1);
						String tempDet = (String) balanceIni.tbl_haber.getValueAt(rowhb, 2);
						
						conn.registrarLibroDiarioBalanceInicial(tempF, tempCta, "0", tempValor, tempDet);
					}
					int rowspats = balanceIni.tbl_patr.getRowCount();
					for(int rowpat=0; rowpat<rowspats; rowpat++) {
						LocalDate fechahb = LocalDate.now();
						String tempF = fechahb.getYear()+"-"+fechahb.getMonthValue()+"-"+fechahb.getDayOfMonth();
						String tempCta = (String) balanceIni.tbl_patr.getValueAt(rowpat, 0);
						String tempValor = (String) balanceIni.tbl_patr.getValueAt(rowpat, 1);
						String tempDet = (String) balanceIni.tbl_patr.getValueAt(rowpat, 2);
						
						conn.registrarLibroDiarioBalanceInicial(tempF, tempCta, "0", tempValor, tempDet);
					}
					balanceIni.ventanaBalanceIni.dispose();
				}
			}
		});
	}

}
