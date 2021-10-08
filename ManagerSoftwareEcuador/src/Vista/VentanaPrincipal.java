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
	
	public JMenu jm_rrhh, jm_rrhhfuncion, jm_rrhhPersonal;
	public JMenuItem jmi_funcioncrear, jmi_funcionver, jmi_empleado, jmi_contrato, jmi_designacion;
	
	public JMenu jm_financiero;
	public JMenu jm_estadofin;
	public JMenuItem jmi_balanceInic, jmi_diarioGeneral, jmi_mayorGeneral, jmi_balanceComprobacion, jmi_hojaTrabajo, jmi_estadFinanc, jmi_estadoResultado, jmi_balanceGeneral;
	
	public VentanaPrincipal() {
		// TODO Auto-generated constructor stub
		construirVentanaPrincipal();
	}
	public JMenu construirMenuFinanciero() {
		jm_financiero = new JMenu("Financiero");
		
		jm_estadofin = new JMenu("Estados Financieros");
		jmi_balanceInic = new JMenuItem("Balance Inicial");
		jmi_diarioGeneral = new JMenuItem("Diario General");
		jmi_mayorGeneral = new JMenuItem("Mayor General");
		jmi_balanceComprobacion = new JMenuItem("Balance de Comprobación");
		jmi_hojaTrabajo = new JMenuItem("Hoja de Trabajo");
		jmi_estadFinanc = new JMenuItem("Estados Financieros");
		jmi_estadoResultado = new JMenuItem("Estados de Resultado");
		jmi_balanceGeneral = new JMenuItem("Balance General");
		jm_estadofin.add(jmi_balanceInic);
		jm_estadofin.add(jmi_diarioGeneral);
		jm_estadofin.add(jmi_mayorGeneral);
		jm_estadofin.add(jmi_balanceComprobacion);
		jm_estadofin.add(jmi_hojaTrabajo);
		jm_estadofin.add(jmi_estadFinanc);
		jm_estadofin.add(jmi_estadoResultado);
		jm_estadofin.add(jmi_balanceGeneral);
		
		jm_financiero.add(jm_estadofin);
		return jm_financiero;
	}
	
	public JMenu construirMenuRRHH() {
		jm_rrhh = new JMenu("Recursos Humanos");
		
		jm_rrhhfuncion = new JMenu("Funciones o Cargos");
		jmi_funcioncrear = new JMenuItem("Crear Cargos");
		jmi_funcionver = new JMenuItem("Ver funciones o cargos");
		jm_rrhhfuncion.add(jmi_funcioncrear);
		jm_rrhhfuncion.add(jmi_funcionver);
		
		jm_rrhhPersonal = new JMenu("Selección Personal");
		jmi_empleado = new JMenuItem("Datos del Empleado");
		jmi_contrato = new JMenuItem("Contrato y Selección");
		jmi_designacion = new JMenuItem("Asignación");
		jm_rrhhPersonal.add(jmi_empleado);
		jm_rrhhPersonal.add(jmi_contrato);
		jm_rrhhPersonal.add(jmi_designacion);
		
		jm_rrhh.add(jm_rrhhfuncion);
		jm_rrhh.add(jm_rrhhPersonal);
		
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
		
		jm_menuPrincipal.add(construirMenuFinanciero());
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
