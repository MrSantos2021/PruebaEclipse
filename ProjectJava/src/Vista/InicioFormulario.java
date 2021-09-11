package Vista;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.Armas_Enum;
import DTO.Personajes;

public class InicioFormulario {
	public JFrame ventanaInicio;
	private JPanel panelCliente;
	private JLabel lbl_nombre, lbl_personaje, lbl_arma;
	public JTextField txt_name;
	public JComboBox<Personajes>cb_personajes;
	public JComboBox<Armas_Enum>cb_armas;
	public JButton btn_grabar;
	
	public InicioFormulario() {
		// TODO Auto-generated constructor stub
		construirVentana();
	
	}
	
	public void construirVentana() {
		panelCliente = new JPanel();
		panelCliente.setBounds(5, 5, 310, 150);
		panelCliente.setBorder(BorderFactory.createTitledBorder("Información:"));
		panelCliente.setLayout(null);
		
		lbl_nombre = new JLabel("Ingrese su nombre:");
		lbl_nombre.setBounds(10, 25, 140, 20);
		txt_name = new JTextField();
		txt_name.setBounds(170, 25, 130, 20);
		lbl_personaje = new JLabel("Seleccione su personaje: ");
		lbl_personaje.setBounds(10, 50, 160, 20);
		cb_personajes = new JComboBox<>();
		cb_personajes.setBounds(170, 50, 130, 20);
		Personajes personajes[] = Personajes.values();
		for(Personajes p:personajes) {
			cb_personajes.addItem(p);
		}
		lbl_arma = new JLabel("Seleccione el arma: ");
		lbl_arma.setBounds(10, 75, 160, 20);
		cb_armas = new JComboBox<>();
		cb_armas.setBounds(170, 75, 130, 20);
		Armas_Enum armas[] = Armas_Enum.values();
		for(Armas_Enum arm: armas) {
			cb_armas.addItem(arm);
		}
		btn_grabar = new JButton("Grabar");
		btn_grabar.setBounds(110, 120, 100, 20);
		
		
		panelCliente.add(lbl_nombre);
		panelCliente.add(txt_name);
		panelCliente.add(lbl_personaje);
		panelCliente.add(cb_personajes);
		panelCliente.add(lbl_arma);
		panelCliente.add(cb_armas);
		panelCliente.add(btn_grabar);
		
		ventanaInicio = new JFrame("Welcome Adventure Game");
		ventanaInicio.setSize(340, 200);
		ventanaInicio.setLocationRelativeTo(null);
		ventanaInicio.setResizable(false);
		ventanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaInicio.setVisible(true);
		ventanaInicio.setLayout(null);
		ventanaInicio.add(panelCliente);
	}
	

}
