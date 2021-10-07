package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vista.FormCont_BalanceIni;
import Vista.VentanaPrincipal;

public class ControlFinancieroBalanceInicial {
	public ControlFinancieroBalanceInicial() {
		// TODO Auto-generated constructor stub
	}
	public void ventana_balanceInicial(VentanaPrincipal vp, FormCont_BalanceIni balanceIni) {
		vp.jmi_balanceInic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(balanceIni.ventanaBalanceIni.isShowing()) {
					JOptionPane.showMessageDialog(null, "La ventana Balance Inicial ya está abierta");
				}else {
					vp.deskPrincipal.add(balanceIni.ventanaBalanceIni);
					balanceIni.ventanaBalanceIni.show();
				}
			}
		});
		
	}

}
