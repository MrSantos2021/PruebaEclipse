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
	
	public JMenu jm_rrhh, jm_rrhhfuncion;
	public JMenuItem jmi_funcioncrear, jmi_funcionver;
	
	public VentanaPrincipal() {
		// TODO Auto-generated constructor stub
		construirVentanaPrincipal();
	}
	
	public JMenu construirMenuRRHH() {
		jm_rrhh = new JMenu("Recursos Humanos");
		jm_rrhhfuncion = new JMenu("Funciones o Cargos");
		jmi_funcioncrear = new JMenuItem("Crear");
		jmi_funcionver = new JMenuItem("Ver funciones o cargos");
		jm_rrhhfuncion.add(jmi_funcioncrear);
		jm_rrhhfuncion.add(jmi_funcionver);
		jm_rrhh.add(jm_rrhhfuncion);
		
		return jm_rrhh;
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
		
		jm_menuPrincipal.add(construirMenuRRHH());
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
