package Vista;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal{
	public JFrame ventanaApp;
	public JDesktopPane deskPrincipal;
	public JInternalFrame internal;
		
	private JMenuBar jm_menuPrincipal = new JMenuBar();
	
	public JMenu jm_general;
	public JMenuItem jmi_local;
	
	public VentanaPrincipal() {
		// TODO Auto-generated constructor stub
		construirVentanaPrincipal();
	}
	
	
	public JMenu construirMenuGeneral() {
		jm_general = new JMenu("General");
		jmi_local = new JMenuItem("Local");
		jm_general.add(jmi_local);
		return jm_general;
	}
	
	public void construirVentanaPrincipal() {
		ventanaApp = new JFrame("Name Company");
		deskPrincipal =new JDesktopPane();
		
		jm_menuPrincipal.add(construirMenuGeneral());
		
		ventanaApp.setSize(550,400);
		ventanaApp.setVisible(false);/**/
		ventanaApp.setLocationRelativeTo(null);
		ventanaApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ventanaApp.setJMenuBar(jm_menuPrincipal);
		ventanaApp.getContentPane().add(deskPrincipal);
		
		//internal.setVisible(true);
		/*Dentro de construirVentanaPrincipal() un jinternalFrame y sus propiedades se puede evitar duplicaciones*/
		//formLocal = new FormularioLocal();
		/*
		internal = new JInternalFrame("Local");
		internal.add(jpVentana());
		internal.setBounds(10, 10, 200, 100);
		internal.setClosable(true);*/
			
	}
}
