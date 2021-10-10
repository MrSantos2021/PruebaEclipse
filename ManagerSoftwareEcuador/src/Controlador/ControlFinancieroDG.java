package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vista.FormCont_DiarioGeneral;
import Vista.VentanaPrincipal;

public class ControlFinancieroDG {
	public ControlFinancieroDG() {
		// TODO Auto-generated constructor stub
	}
	public void ventana_DiarioGeneral(VentanaPrincipal vp, FormCont_DiarioGeneral formDg) {
		vp.jmi_diarioGeneral.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(formDg.ventanaDiarioGeneral.isShowing()) {
					JOptionPane.showMessageDialog(null, "Ventana abierta");
				}else {
					vp.deskPrincipal.add(formDg.ventanaDiarioGeneral);
					formDg.ventanaDiarioGeneral.show();
				}
			}
		});
	}

}
