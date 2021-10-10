package Vista;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class FormCont_DiarioGeneral {
	public JInternalFrame ventanaDiarioGeneral;
	private JPanel jpSuperior, jpDebe, jpHaber;
	private JLabel lbl_fecha, lbl_trans, lbl_user, lbl_detalle, lbl_debe, lbl_valordb, lbl_haber, lbl_valorhb;
	public JTextField txt_trans, txt_user, txt_ctadb, txt_valordb, txt_ctahb, txt_valorhb;
	public JTextArea txt_detalle;
	public JDateChooser calendario;
	public JButton btn_debe, btn_habe, btn_dg, btn_grabar;
	public DefaultTableModel dtm_db, dtm_hb;
	public JTable tbl_db, tbl_hb;
	public JScrollPane jsp_db, jsp_hb;
	
	public FormCont_DiarioGeneral() {
		// TODO Auto-generated constructor stub
		mostrarVentanaDG();
	}
	public JPanel panelSuperior() {
		jpSuperior = new JPanel();
		jpSuperior.setBounds(1, 1, 555, 150);
		jpSuperior.setBorder(BorderFactory.createTitledBorder("Información:"));
		jpSuperior.setLayout(null);
		lbl_fecha = new JLabel("Fecha:");
		lbl_fecha.setBounds(10, 15, 150, 20);
		calendario = new JDateChooser("yyyy-MM-dd", "####-##-##", '_');
		calendario.setBounds(100, 15, 150, 20);
		lbl_trans = new JLabel("N° de transacción:");
		lbl_trans.setBounds(280, 15, 150, 20);
		txt_trans = new JTextField();
		txt_trans.setBounds(390, 15, 150, 20);
		lbl_user = new JLabel("Responsable:");
		lbl_user.setBounds(10, 45, 100, 20);
		txt_user = new JTextField();
		txt_user.setBounds(100, 45, 440, 20);
		lbl_detalle = new JLabel("Detalle:");
		lbl_detalle.setBounds(10, 75, 150, 20);
		txt_detalle = new JTextArea();
		txt_detalle.setBounds(100, 75, 440, 60);
		
		jpSuperior.add(lbl_fecha);
		jpSuperior.add(calendario);
		jpSuperior.add(lbl_trans);
		jpSuperior.add(txt_trans);
		jpSuperior.add(lbl_user);
		jpSuperior.add(txt_user);
		jpSuperior.add(lbl_detalle);
		jpSuperior.add(txt_detalle);
		return jpSuperior;
	}
	public JPanel panelDebe() {
		jpDebe = new JPanel();
		jpDebe.setBorder(BorderFactory.createTitledBorder("Debe:"));
		jpDebe.setBounds(1, 150, 555, 120);
		jpDebe.setLayout(null);
		
		lbl_debe = new JLabel("Cuenta a debitar:");
		lbl_debe.setBounds(10, 15, 150, 20);
		txt_ctadb = new JTextField();
		txt_ctadb.setBounds(120, 15, 150, 20);
		lbl_valordb = new JLabel("Valor a debitar:");
		lbl_valordb.setBounds(10, 50, 150, 20);
		txt_valordb = new JTextField();
		txt_valordb.setBounds(120, 50, 150, 20);
		btn_debe = new JButton("Debitar");
		btn_debe.setBounds(100, 85, 100, 20);
		
		dtm_db = new DefaultTableModel();
		dtm_db.addColumn("Cuenta");
		dtm_db.addColumn("Valor");
		tbl_db = new JTable(dtm_db);
		tbl_db.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jsp_db = new JScrollPane(tbl_db);
		jsp_db.setBounds(300, 15, 240, 90);
		
		jpDebe.add(lbl_debe);
		jpDebe.add(txt_ctadb);
		jpDebe.add(lbl_valordb);
		jpDebe.add(txt_valordb);
		jpDebe.add(btn_debe);
		jpDebe.add(jsp_db);
		return jpDebe;
	}
	public JPanel panelHaber() {
		jpHaber = new JPanel();
		jpHaber.setBorder(BorderFactory.createTitledBorder("Haber:"));
		jpHaber.setBounds(1, 270, 555, 120);
		jpHaber.setLayout(null);
		lbl_haber = new JLabel("Cuenta a acreditar:");
		lbl_haber.setBounds(10, 15, 150, 20);
		txt_ctahb = new JTextField();
		txt_ctahb.setBounds(120, 15, 150, 20);
		lbl_valorhb = new JLabel("Valor a acreditar:");
		lbl_valorhb.setBounds(10, 50, 150, 20);
		txt_valorhb = new JTextField();
		txt_valorhb.setBounds(120, 50, 150, 20);
		btn_habe = new JButton("Acreditar");
		btn_habe.setBounds(100, 85, 100, 20);
		//btn_habe.setToolTipText("Haber");
		dtm_hb = new DefaultTableModel();
		dtm_hb.addColumn("Cuenta");
		dtm_hb.addColumn("Valor");
		tbl_hb = new JTable(dtm_hb);
		tbl_hb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jsp_hb = new JScrollPane(tbl_hb);
		jsp_hb.setBounds(300, 15, 240, 90);
		
		jpHaber.add(lbl_haber);
		jpHaber.add(txt_ctahb);
		jpHaber.add(lbl_valorhb);
		jpHaber.add(txt_valorhb);
		jpHaber.add(btn_habe);
		jpHaber.add(jsp_hb);
		return jpHaber;
	}
	public void mostrarVentanaDG() {		
		ventanaDiarioGeneral = new JInternalFrame("Diario General");
		btn_dg = new JButton("Ver Transacciones");
		btn_dg.setBounds(100, 400, 150, 20);
		btn_grabar = new JButton("Grabar Transacción");
		btn_grabar.setBounds(300, 400, 150, 20);
		ventanaDiarioGeneral.setSize(570, 470);
		ventanaDiarioGeneral.setResizable(false);
		ventanaDiarioGeneral.setClosable(true);
		ventanaDiarioGeneral.setLayout(null);
		ventanaDiarioGeneral.add(panelSuperior());
		ventanaDiarioGeneral.add(panelDebe());
		ventanaDiarioGeneral.add(panelHaber());
		ventanaDiarioGeneral.add(btn_dg);
		ventanaDiarioGeneral.add(btn_grabar);
	}

}
