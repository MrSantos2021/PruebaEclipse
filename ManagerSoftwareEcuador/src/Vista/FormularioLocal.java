package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DTO.Ecuador;
import DTO.Local_Tipos;

public class FormularioLocal implements ActionListener {

	public JInternalFrame ventanaFormLocal;
	private JPanel jpOpcion;
	private JPanel jpInformation;
	public ButtonGroup bg_opciones;
	public JButton btn_aceptar;
	public JRadioButton opc_Crear;
	public JRadioButton opc_Modificar;
	public JRadioButton opc_Ver;
	private JLabel lbl_locales, lbl_id, lbl_tipo, lbl_nombre, lbl_prov, lbl_ciudad, lbl_dir, lbl_telf1, lbl_telf2;
	public JComboBox<Local_Tipos> cb_tipo;
	public JComboBox<String> cb_locales;
	public JComboBox<String> cb_prov;
	public JComboBox<String> cb_ciudad;
	public JTextField txt_id, txt_nombre, txt_telf1, txt_telf2;
	public JTextArea txt_dir;
	private JScrollPane jsp_dir;
	
	
	private Ecuador ecuador =new Ecuador();
	
	public  FormularioLocal(){
		mostrarVentanaLocal();
	}
	
	public void mostrarVentanaLocal(){
		ventanaFormLocal = new JInternalFrame();
		ventanaFormLocal.setTitle("Local:");
		ventanaFormLocal.setSize(312, 470);
		ventanaFormLocal.setResizable(false);
		ventanaFormLocal.setClosable(true);
		ventanaFormLocal.setLayout(null);
		ventanaFormLocal.add(construirPanelOpcion());
		ventanaFormLocal.add(construirPanelInformation());
	}
	
	public JPanel construirPanelOpcion() {
		jpOpcion = new JPanel();
		opc_Crear = new JRadioButton("Nuevo");
		opc_Crear.setBounds(10, 25, 100, 20);
		opc_Modificar = new JRadioButton("Modificar");
		opc_Modificar.setBounds(120, 25, 100, 20);
		opc_Ver = new JRadioButton("Ver");
		opc_Ver.setBounds(230, 25, 50, 20);
		
		bg_opciones = new ButtonGroup();
		bg_opciones.add(opc_Crear);
		bg_opciones.add(opc_Modificar);
		bg_opciones.add(opc_Ver);
		
		lbl_locales = new JLabel("Locales actuales:");
		lbl_locales.setBounds(10, 60, 100, 20);
		cb_locales = new JComboBox<String>();
		cb_locales.setBounds(120, 60, 140, 20);
		
		jpOpcion.setSize(300, 100);
		jpOpcion.setBorder(BorderFactory.createTitledBorder("Opciones:"));
		jpOpcion.setLayout(null);
		jpOpcion.add(opc_Crear);
		jpOpcion.add(opc_Modificar);
		jpOpcion.add(opc_Ver);
		jpOpcion.add(lbl_locales);
		jpOpcion.add(cb_locales);
		return jpOpcion;
	}
	public JPanel construirPanelInformation() {
		lbl_id = new JLabel("Id local:");
		lbl_id.setBounds(10, 15, 100, 20);
		txt_id = new JTextField();
		txt_id.setBounds(120, 15, 140, 20);
		lbl_tipo = new JLabel("Tipo:");
		lbl_tipo.setBounds(10, 45, 100, 20);
		cb_tipo = new JComboBox<Local_Tipos>();
		cb_tipo.setBounds(120, 45, 140, 20);
		Local_Tipos[] tipos = Local_Tipos.values();
		for(Local_Tipos tipo:tipos) {
			cb_tipo.addItem(tipo);
		}
		lbl_nombre = new JLabel("Nombre:");
		lbl_nombre.setBounds(10, 75, 100, 20);
		txt_nombre = new JTextField();
		txt_nombre.setBounds(120, 75, 140, 20);
		
		lbl_prov = new JLabel("Provincia:");
		lbl_prov.setBounds(10, 105, 100, 20);
		cb_prov = new JComboBox<String>();
		cb_prov.setBounds(120, 105, 140, 20);
		String[] provincias = ecuador.mostrarProvincias();
		for(String provincia:provincias) {
			cb_prov.addItem(provincia);
		}
		cb_prov.addActionListener(this);
		lbl_ciudad = new JLabel("Ciudad");
		lbl_ciudad.setBounds(10, 135, 100, 20);
		cb_ciudad = new JComboBox<String>();
		cb_ciudad.setBounds(120, 135, 140, 20);
		lbl_dir = new JLabel("Dirección:");
		lbl_dir.setBounds(10, 165, 100, 20);
		txt_dir = new JTextArea();
		txt_dir.setLineWrap(true);
		txt_dir.setWrapStyleWord(true);
		//txt_dir.setBounds(120, 165, 140, 60);
		jsp_dir = new JScrollPane(txt_dir);
		jsp_dir.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp_dir.setBounds(120, 165, 140, 60);
		lbl_telf1 = new JLabel("Teléfono 1:");
		lbl_telf1.setBounds(10, 235, 100, 20);
		txt_telf1 = new JTextField();
		txt_telf1.setBounds(120, 235, 140, 20);
		lbl_telf2 = new JLabel("Teléfono 2:");
		lbl_telf2.setBounds(10, 265, 100, 20);
		txt_telf2 = new JTextField();
		txt_telf2.setBounds(120, 265, 140, 20);
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(100, 295, 100, 20);
		
		jpInformation = new JPanel();
		jpInformation.setBorder(BorderFactory.createTitledBorder("Información:"));
		jpInformation.setBounds(1, 100, 300, 330);
		jpInformation.setLayout(null);
		jpInformation.add(lbl_id);
		jpInformation.add(txt_id);
		jpInformation.add(lbl_tipo);
		jpInformation.add(cb_tipo);
		jpInformation.add(lbl_nombre);
		jpInformation.add(txt_nombre);
		jpInformation.add(lbl_prov);
		jpInformation.add(cb_prov);
		jpInformation.add(lbl_ciudad);
		jpInformation.add(cb_ciudad);
		jpInformation.add(lbl_dir);
		jpInformation.add(jsp_dir);
		jpInformation.add(lbl_telf1);
		jpInformation.add(txt_telf1);
		jpInformation.add(lbl_telf2);
		jpInformation.add(txt_telf2);
		jpInformation.add(btn_aceptar);
		return jpInformation;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cb_prov) {
			int temp = ecuador.mostrarProvincias().length;
			for(int i=0; i<=temp; i++) {
				if(cb_prov.getSelectedIndex() == i) {
					cb_ciudad.removeAllItems();
					try {
						for(int j=0; j<=ecuador.cantones.length; j++) {
							cb_ciudad.addItem(ecuador.cantones[i][j]);
						}
					}catch(ArrayIndexOutOfBoundsException exception) {
						System.out.println("Error de índice");
					}	
				}
			}	
		}
		if(e.getSource() == btn_aceptar) {
			ventanaFormLocal.dispose();
		}
	}
}
