package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
					balanceIni.cb_ctaPat.removeAllItems();
					ArrayList<String>ctasPat = conn.planCtaList("Patrimonio");
					for(String pat:ctasPat) {
						balanceIni.cb_ctaPat.addItem(pat);
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
				String[] infDebe = {tempCta, tempValor};
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
		balanceIni.btn_pat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tempCtaPat = balanceIni.cb_ctaPat.getSelectedItem().toString();
				String tempValorPat = balanceIni.txt_valorpat.getText();
				
				String[] infPat = {tempCtaPat, tempValorPat};
				balanceIni.dtm_patr.addRow(infPat);
				balanceIni.cb_ctaPat.setSelectedIndex(0);
				balanceIni.txt_valorpat.setText("");
				balanceIni.txt_detpat.setText("");
			}
		});
	}

}
