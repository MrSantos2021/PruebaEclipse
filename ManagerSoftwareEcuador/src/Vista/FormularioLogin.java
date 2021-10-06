package Vista;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormularioLogin {
	/*Ventana Login al iniciar el sistema*/
	/*Sus atributos o componentes*/
	public JFrame ventanaInicio = new JFrame();
	public JTabbedPane jtabLogin = new JTabbedPane();
	private JPanel jpLogin, jpEmpresa, jpSupLogin, jpInfLogin;
	private JLabel lbl_empresa, lbl_cargo, lbl_pass, lbl_local,lbl_usuario, lbl_logo, lbl_addEmpresa, lbl_changeEmpresa;
	public JTextField txt_empresa = new JTextField();
	public JComboBox<String> cb_cargo = new JComboBox<String>();
	public JComboBox<String> cb_local = new JComboBox<String>();
	public JComboBox<String> cb_usuario = new JComboBox<String>();
	public JPasswordField txt_pass = new JPasswordField();
	public JButton btn_inicio, btn_conex, btn_addEmpresa, btn_changeEmpresa;
	//Las medidas de altura y anchura de los jcomponents
	private int medH = 20;
	private int medW = 150;
	
	public FormularioLogin() {
		// TODO Auto-generated constructor stub
		construirVentanaLogin();
	}
	private void construirVentanaLogin() {
		/*Pestañas de tabuladores para LOGIN y EMPRESA*/
		/*JTabbedPane*/
		jtabLogin.setBounds(1, 1, 530, 358);
		jtabLogin.add("Login", bloqueTabLogin());
		jtabLogin.add("Empresa", bloqueTabEmpresa());

		ventanaInicio.setTitle("Manager Software Ecuador");
		ventanaInicio.setSize(550,  400);//Medida predeterminada del fomrulario Login
		ventanaInicio.setLocationRelativeTo(null);//Posición por default, centro
		ventanaInicio.setResizable(false);//Denegar cambio de tamaño del formulario
		ventanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ventanaInicio.setVisible(true);//Visible la ventana
		ventanaInicio.setLayout(null);
		ventanaInicio.add(jtabLogin);
		
	}
	/*En el formulario consta de DOS pestaña: uno para login y el otro para conexión o cambios */
	private JPanel bloqueTabLogin() {
		jpLogin = new JPanel();
		jpLogin.setBounds(1, 1, 550, 400);
		jpLogin.setLayout(null);
		jpLogin.add(bloqueLogin());
		jpLogin.add(bloqueConexion());
		return jpLogin;
	}
	private JPanel bloqueTabEmpresa() {
		jpEmpresa = new JPanel();
		jpEmpresa.setLayout(null);
		
		lbl_addEmpresa = new JLabel();
		lbl_addEmpresa.setIcon(new ImageIcon("Image/addbd.png"));
		lbl_addEmpresa.setBounds(150, 80, 100, 100);
		btn_addEmpresa =new JButton("Agregar Empresa");
		btn_addEmpresa.setBounds(120, 190, medW, medH);
	
		lbl_changeEmpresa = new JLabel();
		lbl_changeEmpresa.setIcon(new ImageIcon("Image/changebd.png"));
		lbl_changeEmpresa.setBounds(320, 80, 100, 100);
		btn_changeEmpresa = new JButton("Cambiar Empresa");
		btn_changeEmpresa.setBounds(285, 190, medW, medH);
		
		jpEmpresa.add(lbl_addEmpresa);
		jpEmpresa.add(btn_addEmpresa);
		jpEmpresa.add(lbl_changeEmpresa);
		jpEmpresa.add(btn_changeEmpresa);
		
		return jpEmpresa;
		
	}
	/*Pestaña Tabulador Login, partes Superior*/
	private JPanel bloqueLogin() {
		jpSupLogin = new JPanel();
		jpSupLogin.setBorder(BorderFactory.createTitledBorder("Inicio de sesión:"));
		jpSupLogin.setBounds(1, 1, 523, 200);
		jpSupLogin.setLayout(null);
		
		//Los componentes para el bloque Superior de Login
		lbl_empresa = new JLabel("Empresa: ");
		lbl_empresa.setBounds(10, 25, medW, medH);
		txt_empresa.setBounds(105, 25, medW, medH);
		lbl_cargo = new JLabel("Cargo: ");
		lbl_cargo.setBounds(10, 65, medW, medH);
		cb_cargo.setBounds(105, 65, medW, medH);
		lbl_pass = new JLabel("Contraseña:");
		lbl_pass.setBounds(10, 105, medW, medH);
		txt_pass.setBounds(105, 105, (medW+250), medH);
		lbl_local = new JLabel("Local:");
		lbl_local.setBounds(300, 25, medW, medH);
		cb_local.setBounds(350, 25, medW, medH);
		lbl_usuario = new JLabel("Usuario: ");
		lbl_usuario.setBounds(300, 65, medW, medH);
		cb_usuario.setBounds(350, 65, medW, medH);
		btn_inicio = new JButton("Entrar");
		btn_inicio.setBounds(200, 145, medW, medH);
		//Añadiendo los componentes al Panel Superior
		jpSupLogin.add(lbl_empresa);
		jpSupLogin.add(txt_empresa);
		jpSupLogin.add(lbl_cargo);
		jpSupLogin.add(cb_cargo);
		jpSupLogin.add(lbl_pass);
		jpSupLogin.add(txt_pass);
		jpSupLogin.add(lbl_local);
		jpSupLogin.add(cb_local);
		jpSupLogin.add(lbl_usuario);
		jpSupLogin.add(cb_usuario);
		jpSupLogin.add(btn_inicio);
		return jpSupLogin;
	}
	/*Pestaña Tabulador Login, partes Inferior ->Inferior*/
	private JPanel bloqueConexion() {
		jpInfLogin = new JPanel();
		jpInfLogin.setBorder(BorderFactory.createTitledBorder("Conexión a la Base de Datos"));
		jpInfLogin.setBounds(1, 205, 535, 130);
		jpInfLogin.setLayout(null);
		
		lbl_logo = new JLabel();
		lbl_logo.setIcon(new ImageIcon("Image/bd.png"));
		lbl_logo.setBounds(230, 1, 100, 100);
		btn_conex = new JButton("Conectar BD");
		btn_conex.setBounds(200, 100, medW, medH);
		
		jpInfLogin.add(lbl_logo);
		jpInfLogin.add(btn_conex);
		return jpInfLogin;	
	}
}