package Controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;

import DAO.ConexBD;
import Vista.FormularioLogin;
import Vista.VentanaPrincipal;

public class ControlVentanaPrincipal {
	
	public ControlVentanaPrincipal() {
		// TODO Auto-generated constructor stub
	}
	public void vp_ventanaPrincipal(VentanaPrincipal vp, ConexBD conn, FormularioLogin fl) {
		vp.ventanaApp.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				LocalDateTime finHora = LocalDateTime.now();
				LocalDate finFecha = LocalDate.now();
				String tempfh = finHora.getHour()+":"+finHora.getMinute()+":"+finHora.getSecond();
				String tempff = finFecha.getYear()+"-"+finFecha.getMonthValue()+"-"+finFecha.getDayOfMonth();
				int tempId = conn.getIdRegHistoryLast();
				conn.regCierreHistorial(tempfh, tempff, vp.ventanaApp.getTitle(), fl.cb_local.getSelectedItem().toString(), tempId);
				conn.desconectar();
			}
		});
	}

}
