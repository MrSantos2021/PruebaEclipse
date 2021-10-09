package Vista;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class FormCont_BalanceIni {
	
	public JInternalFrame ventanaBalanceIni;
	public DefaultTableModel dtm_debe, dtm_haber, dtm_patr;
	public JTable tbl_debe, tbl_haber, tbl_patr;
	public JScrollPane jsp_debe, jsp_haber, jsp_patr;
	private JPanel jpDebitar, jpAcreditar, jpPatrimonio;
	private JLabel lbl_ctadb, lblvalordb, lbldetdb, lbl_ctahb, lblvalorhb, lbldethb, lbl_ctapt, lblvalorpt, lbldetpt;
	public JComboBox<String> cb_ctaDebe, cb_ctaHabe, cb_ctaPat;
	public JTextField txt_valordb, txt_valorhb, txt_valorpat;
	public JTextArea txt_detalledb, txt_dethb, txt_detpat;
	public JButton btn_db, btn_hb, btn_pat, btn_visualizar, btn_grabar;
	
	public FormCont_BalanceIni() {
		// TODO Auto-generated constructor stub
		mostrarVentanaBalanceInicial();
	}
	public void mostrarVentanaBalanceInicial() {
		btn_visualizar = new JButton("Visualizar PDF");
		btn_visualizar.setBounds(90, 550, 160, 20);
		btn_grabar = new JButton("Grabar en el Sistema");
		btn_grabar.setBounds(290, 550, 160, 20);
		ventanaBalanceIni = new JInternalFrame("Balance Inicial");
		ventanaBalanceIni.setSize(570, 610);
		ventanaBalanceIni.setResizable(false);
		ventanaBalanceIni.setClosable(true);
		ventanaBalanceIni.setLayout(null);
		ventanaBalanceIni.add(bloqueDebitar());
		ventanaBalanceIni.add(bloqueAcreeditar());
		ventanaBalanceIni.add(bloquePatrimonio());
		ventanaBalanceIni.add(btn_visualizar);
		ventanaBalanceIni.add(btn_grabar);
	}
	public JPanel bloqueDebitar() {
		jpDebitar = new JPanel();
		jpDebitar.setBorder(BorderFactory.createTitledBorder("Debitar:"));
		jpDebitar.setSize(560, 180);
		jpDebitar.setLayout(null);
		
		dtm_debe = new DefaultTableModel();
		dtm_debe.addColumn("Cuenta");
		dtm_debe.addColumn("Valor");
		
		tbl_debe = new JTable(dtm_debe);
		tbl_debe.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jsp_debe = new JScrollPane(tbl_debe);
		jsp_debe.setBounds(325, 15, 220, 150);
		
		TableColumn tc_db = tbl_debe.getColumn("Cuenta");
		tc_db.setPreferredWidth(140);
		DefaultTableCellRenderer derech = new DefaultTableCellRenderer();
		derech.setHorizontalAlignment(JLabel.RIGHT);
		tbl_debe.getColumnModel().getColumn(1).setCellRenderer(derech);
		
		lbl_ctadb = new JLabel("Seleccione la cuenta:");
		lbl_ctadb.setBounds(10, 15, 150, 20);
		cb_ctaDebe = new JComboBox<String>();
		cb_ctaDebe.setBounds(150, 15, 150, 20);
		lblvalordb = new JLabel("Ingrese valor:");
		lblvalordb.setBounds(10, 45, 150, 20);
		txt_valordb = new JTextField();
		txt_valordb.setBounds(150, 45, 150, 20);
		lbldetdb = new JLabel("Detalle de la cuenta:");
		lbldetdb.setBounds(10, 75, 150, 20);
		txt_detalledb = new JTextArea();
		txt_detalledb.setBounds(150, 75, 150, 50);
		btn_db = new JButton("Debitar a la Tabla");
		btn_db.setBounds(80, 140, 180, 20);
		jpDebitar.add(lbl_ctadb);
		jpDebitar.add(cb_ctaDebe);
		jpDebitar.add(lblvalordb);
		jpDebitar.add(txt_valordb);
		jpDebitar.add(lbldetdb);
		jpDebitar.add(txt_detalledb);
		jpDebitar.add(btn_db);
		jpDebitar.add(jsp_debe);
		return jpDebitar;
	}
	public JPanel bloqueAcreeditar() {
		jpAcreditar = new JPanel();
		jpAcreditar.setBorder(BorderFactory.createTitledBorder("Acreditar:"));
		jpAcreditar.setBounds(1, 180, 560, 180);
		jpAcreditar.setLayout(null);
		
		dtm_haber = new DefaultTableModel();
		dtm_haber.addColumn("Cuenta");
		dtm_haber.addColumn("Valor");
		
		tbl_haber = new JTable(dtm_haber);
		tbl_haber.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jsp_haber = new JScrollPane(tbl_haber);
		jsp_haber.setBounds(325, 15, 220, 150);
		TableColumn tc_hb = tbl_haber.getColumn("Cuenta");
		tc_hb.setPreferredWidth(140);
		DefaultTableCellRenderer rightHb = new DefaultTableCellRenderer();
		rightHb.setHorizontalAlignment(JLabel.RIGHT);
		tbl_haber.getColumnModel().getColumn(1).setCellRenderer(rightHb);
		
		lbl_ctahb = new JLabel("Seleccione la cuenta:");
		lbl_ctahb.setBounds(10, 15, 150, 20);
		cb_ctaHabe = new JComboBox<String>();
		cb_ctaHabe.setBounds(150, 15, 150, 20);
		lblvalorhb = new JLabel("Ingrese valor:");
		lblvalorhb.setBounds(10, 45, 150, 20);
		txt_valorhb = new JTextField();
		txt_valorhb.setBounds(150, 45, 150, 20);
		lbldethb = new JLabel("Detalle de la cuenta:");
		lbldethb.setBounds(10, 75, 150, 20);
		txt_dethb = new JTextArea();
		txt_dethb.setBounds(150, 75, 150, 50);
		btn_hb = new JButton("Acreditar a la Tabla");
		btn_hb.setBounds(80, 140, 180, 20);
		
		jpAcreditar.add(lbl_ctahb);
		jpAcreditar.add(cb_ctaHabe);
		jpAcreditar.add(lblvalorhb);
		jpAcreditar.add(txt_valorhb);
		jpAcreditar.add(lbldethb);
		jpAcreditar.add(txt_dethb);
		jpAcreditar.add(btn_hb);
		jpAcreditar.add(jsp_haber);
		return jpAcreditar;
	}
	public JPanel bloquePatrimonio() {
		jpPatrimonio = new JPanel();
		jpPatrimonio.setBorder(BorderFactory.createTitledBorder("Patrimonio:"));
		jpPatrimonio.setBounds(1, 360, 560, 180);
		jpPatrimonio.setLayout(null);
		dtm_patr = new DefaultTableModel();
		dtm_patr.addColumn("Cuenta");
		dtm_patr.addColumn("Valor");
		
		tbl_patr = new JTable(dtm_patr);
		tbl_patr.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jsp_patr = new JScrollPane(tbl_patr);
		jsp_patr.setBounds(325, 15, 220, 150);
		
		TableColumn tc_pat = tbl_patr.getColumn("Cuenta");
		tc_pat.setPreferredWidth(140);
		DefaultTableCellRenderer rightPat = new DefaultTableCellRenderer();
		rightPat.setHorizontalAlignment(JLabel.RIGHT);
		tbl_patr.getColumnModel().getColumn(1).setCellRenderer(rightPat);
		
		
		lbl_ctapt = new JLabel("Seleccione la cuenta:");
		lbl_ctapt.setBounds(10, 15, 150, 20);
		cb_ctaPat = new JComboBox<String>();
		cb_ctaPat.setBounds(150, 15, 150, 20);
		lblvalorpt = new JLabel("Ingrese valor:");
		lblvalorpt.setBounds(10, 45, 150, 20);
		txt_valorpat = new JTextField();
		txt_valorpat.setBounds(150, 45, 150, 20);
		lbldetpt = new JLabel("Detalle de la cuenta:");
		lbldetpt.setBounds(10, 75, 150, 20);
		txt_detpat = new JTextArea();
		txt_detpat.setBounds(150, 75, 150, 50);
		btn_pat = new JButton("Ingreso al Patrimonio");
		btn_pat.setBounds(80, 140, 180, 20);
		
		jpPatrimonio.add(lbl_ctapt);
		jpPatrimonio.add(cb_ctaPat);
		jpPatrimonio.add(lblvalorpt);
		jpPatrimonio.add(txt_valorpat);
		jpPatrimonio.add(lbldetpt);
		jpPatrimonio.add(txt_detpat);
		jpPatrimonio.add(btn_pat);
		jpPatrimonio.add(jsp_patr);
		return jpPatrimonio;
	}
}
