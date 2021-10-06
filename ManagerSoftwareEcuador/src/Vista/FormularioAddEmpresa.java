package Vista;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DTO.Empresa_Actividad;
import DTO.Empresa_Ambito;
import DTO.Empresa_Beneficio;
import DTO.Empresa_Capital;
import DTO.Empresa_Produccion;
import DTO.Empresa_Tamanio;
import DTO.Empresa_fjuridico;

public class FormularioAddEmpresa {
	public JFrame formularioAddEmpresa;
	public JPanel jpSuperior, jpAddBusiness;
	private JLabel lbl_newEmp, lbl_corp, lbl_nameEmp, lbl_ruc, lbl_act, lbl_tama, lbl_capital, lbl_amb, lbl_beneficio, lbl_fjuridica, lbl_produccion, lbl_socios;
	public JTextField txt_nameEmp, txt_ruc;
	public JComboBox<String> cb_empresas = new JComboBox<String>();
	public JComboBox<Empresa_Tamanio> cb_tamanio;
	public JComboBox<Empresa_Actividad> cb_actividad;
	public JComboBox<Empresa_Capital> cb_capital;
	public JComboBox<Empresa_Ambito> cb_ambito;
	public JComboBox<Empresa_Beneficio> cb_beneficio;
	public JComboBox<Empresa_fjuridico> cb_fjuridico;
	public JComboBox<Empresa_Produccion> cb_produccion;
	public JScrollPane jsp_txtSocios;
	public JTextArea txt_socios;
	public JButton btn_aceptar;
	public JCheckBox contribespc;
	private int medW = 200;
	private int medH = 20;
	
	public JRadioButton opcSi,opcNo;
	public ButtonGroup opcRadio;
	public FormularioAddEmpresa() {
		// TODO Auto-generated constructor stub
		construirVentana();
	
	}
	private void construirVentana() {
		formularioAddEmpresa = new JFrame("Registrar nueva empresa");
		
		jpSuperior = new JPanel();
		jpSuperior.setBounds(1, 1, 430, 90);
		jpSuperior.setBorder(BorderFactory.createTitledBorder("Empresa:"));
		lbl_newEmp = new JLabel("¿Nueva Empresa?");
		lbl_newEmp.setBounds(15, 20, 120, 20);
		opcSi = new JRadioButton("Si");
		opcSi.setBounds(260, 20, 50, 20);
		opcNo = new JRadioButton("No");
		opcNo.setBounds(310, 20, 50, 20);
		opcRadio = new ButtonGroup();
		opcRadio.add(opcSi);
		opcRadio.add(opcNo);
		
		lbl_corp = new JLabel("Elija para incorporar:");
		lbl_corp.setBounds(15, 50, 200, 20);
		cb_empresas.setBounds(220, 50, 200, 20);
		
		jpSuperior.setLayout(null);
		jpSuperior.add(lbl_newEmp);
		jpSuperior.add(opcSi);
		jpSuperior.add(opcNo);
		jpSuperior.add(lbl_corp);
		jpSuperior.add(cb_empresas);
		
		
		jpAddBusiness = new JPanel();
		jpAddBusiness.setBorder(BorderFactory.createTitledBorder("Datos:"));
		jpAddBusiness.setBounds(1, 90, 430, 450);
				
		lbl_nameEmp = new JLabel("Nombre de la empresa: ");
		lbl_nameEmp.setBounds(10, 20, medW, medH);
		txt_nameEmp = new JTextField();
		txt_nameEmp.setBounds(220, 20, medW, medH);
		
		lbl_ruc = new JLabel("Ingrese el R.U.C.:");
		lbl_ruc.setBounds(10, 50, medW, medH);
		txt_ruc = new JTextField();
		txt_ruc.setBounds(220, 50, medW, medH);
		
		lbl_act = new JLabel("Seleccione según su actividad: ");
		lbl_act.setBounds(10, 80, (medW+50), medH);
		cb_actividad = new JComboBox<Empresa_Actividad>();
		Empresa_Actividad[] emp_act = Empresa_Actividad.values();
		for(Empresa_Actividad ea:emp_act) {
			cb_actividad.addItem(ea);
		}
		cb_actividad.setBounds(220, 80, medW, medH);
		
		lbl_tama = new JLabel("Seleccione el tamaño de la empresa: ");
		lbl_tama.setBounds(10, 110, (medW+50), medH);
		cb_tamanio = new JComboBox<Empresa_Tamanio>();
		Empresa_Tamanio[] emp_tama = Empresa_Tamanio.values();
		for(Empresa_Tamanio et:emp_tama) {
			cb_tamanio.addItem(et);
		}
		cb_tamanio.setBounds(220, 110, medW, medH);
		
		lbl_capital = new JLabel("Seleccione según su capital:");
		lbl_capital.setBounds(10, 140, medW, medH);
		cb_capital = new JComboBox<Empresa_Capital>();
		Empresa_Capital[] emp_capi = Empresa_Capital.values();
		for(Empresa_Capital ec:emp_capi) {
			cb_capital.addItem(ec);
		}
		cb_capital.setBounds(220, 140, medW, medH);
		
		lbl_amb = new JLabel("Seleccione según su ámbito:");
		lbl_amb.setBounds(10, 170, medW, medH);
		cb_ambito = new JComboBox<Empresa_Ambito>();
		cb_ambito.setBounds(220, 170, medW, medH);
		Empresa_Ambito[] emp_amb = Empresa_Ambito.values();
		for(Empresa_Ambito ea: emp_amb) {
			cb_ambito.addItem(ea);
		}
		
		lbl_beneficio = new JLabel("Seleccione segun su beneficio:");
		lbl_beneficio.setBounds(10, 200, medW, medH);
		cb_beneficio = new JComboBox<Empresa_Beneficio>();
		cb_beneficio.setBounds(220, 200, medW, medH);
		Empresa_Beneficio[] emp_benef = Empresa_Beneficio.values();
		for(Empresa_Beneficio eb:emp_benef) {
			cb_beneficio.addItem(eb);
		}
		
		lbl_fjuridica = new JLabel("Según su función jurídica:");
		lbl_fjuridica.setBounds(10, 230, medW, medH);
		cb_fjuridico = new JComboBox<Empresa_fjuridico>();
		cb_fjuridico.setBounds(220, 230, medW, medH);
		Empresa_fjuridico[] emp_jur = Empresa_fjuridico.values();
		for(Empresa_fjuridico ej: emp_jur) {
			cb_fjuridico.addItem(ej);
		}
		
		lbl_produccion = new JLabel("Seleccione según su producción:");
		lbl_produccion.setBounds(10, 260, medW, medH);
		cb_produccion = new JComboBox<Empresa_Produccion>();
		cb_produccion.setBounds(220, 260, medW, medH);
		Empresa_Produccion[] emp_prod = Empresa_Produccion.values();
		for(Empresa_Produccion ep:emp_prod) {
			cb_produccion.addItem(ep);
		}
		
		lbl_socios = new JLabel("Ingrese el nombre del propietario o nombres de los socios: ");
		lbl_socios.setBounds(10, 290, (medW+150), medH);
		txt_socios = new JTextArea();
		//txt_socios.setBounds(5, 320, medW+220, (medH+50));
		txt_socios.setLineWrap(true);//Limitar el cuadro de TextArea
		txt_socios.setWrapStyleWord(true);
		jsp_txtSocios = new JScrollPane(txt_socios);
		jsp_txtSocios.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp_txtSocios.setBounds(5, 320, medW+220, (medH+50));
		contribespc = new JCheckBox("Contribuyente Especial");
		contribespc.setBounds(140, 390, medW, medH);
		btn_aceptar = new JButton("Agregar");
		btn_aceptar.setBounds(120, 420, medW, medH);
				
		jpAddBusiness.setLayout(null);
		jpAddBusiness.add(lbl_nameEmp);
		jpAddBusiness.add(txt_nameEmp);
		jpAddBusiness.add(lbl_ruc);
		jpAddBusiness.add(txt_ruc);
		jpAddBusiness.add(lbl_act);
		jpAddBusiness.add(cb_actividad);
		jpAddBusiness.add(lbl_tama);
		jpAddBusiness.add(cb_tamanio);
		jpAddBusiness.add(lbl_capital);
		jpAddBusiness.add(cb_capital);
		jpAddBusiness.add(lbl_amb);
		jpAddBusiness.add(cb_ambito);
		jpAddBusiness.add(lbl_beneficio);
		jpAddBusiness.add(cb_beneficio);
		jpAddBusiness.add(lbl_fjuridica);
		jpAddBusiness.add(cb_fjuridico);
		jpAddBusiness.add(lbl_produccion);
		jpAddBusiness.add(cb_produccion);
		jpAddBusiness.add(lbl_socios);
		//jpAddBusiness.add(txt_socios);
		jpAddBusiness.add(jsp_txtSocios);
		jpAddBusiness.add(contribespc);
		jpAddBusiness.add(btn_aceptar);
		
		formularioAddEmpresa.setSize(450, 580);
		formularioAddEmpresa.setLocationRelativeTo(null);
		formularioAddEmpresa.setResizable(false);
		formularioAddEmpresa.setVisible(false);
		formularioAddEmpresa.setLayout(null);
		formularioAddEmpresa.add(jpSuperior);
		formularioAddEmpresa.add(jpAddBusiness);		
	}
}
