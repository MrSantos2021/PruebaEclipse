package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DTO.Local_Tipos;


public class ConexBD {
	private String driver = "com.mysql.jdbc.Driver";
	private String connect = "jdbc:mysql://santos1.heliohost.us/santos1_pruebadb?useSSL=false";
	private String user = "santos1_remote";
	private String pass = "root12345";
	
	private Connection conn;
	private Statement state;
	
	private PreparedStatement prs;
	private ResultSet rs;
	
	public ConexBD() {
		// TODO Auto-generated constructor stub
	}
	/*Método getConnection ok*/
	public Connection getConnection() {
		conn = null;
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(connect, user, pass);
			JOptionPane.showMessageDialog(null, "Conexión exitosa con la Base de Datos.", "Base de Datos", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de conexión.", "Error de Base", JOptionPane.ERROR_MESSAGE);
		}
		return conn;
		
	}
	public void desconectar() {
		conn = null;
		JOptionPane.showMessageDialog(null, "Cerrando la Base de Datos", "Base de Datos", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/*Registrar Empresa o corporaciones------------------->OK*/
	public void registrarEmpresa(String nombre, String ruc, String act, String tam, String cap, String amb, String benef, String jur, String prod, String soc, boolean ce, int subcorp) {
		state = null;
		try {
			state = (Statement) conn.createStatement();
			state.executeUpdate("insert into empresatbl(nombre_emp, ruc_emp, act_emp, tam_emp, cap_emp, amb_emp, benef_emp, jur_emp, prod_emp, soc_emp, ce_emp, subcorp) values('"+nombre+"', '"+ruc+"', '"+act+"', '"+tam+"', '"+cap+"', '"+amb+"', '"+benef+"', '"+jur+"', '"+prod+"', '"+soc+"', "+ce+", "+subcorp+");");
			state.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	/*Al momento de crear una empresa, automáticamente se creará un local por default*/
	public void crearLocalDefault(String nombreEmp) {
		state = null;
		
		try {
			state = (Statement) conn.createStatement();
			state.executeUpdate("insert into localtbl (nombre_emp, tipoLocal, nombreLocal, provLocal, ciudadLocal, dirLocal, telf1Local, telf2Local) values('"+nombreEmp+"','Matriz', 'Local 1', 'Guayas', 'Guayaquil', 'Avenida 1 y calle 1', '2444444', '2555555');");
			state.close();	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*Al momento de crear una empresa, automáticamente se creará una FUNCION o CARGO por default*/
	public void crearFuncionDefault(String nombreEmp) {
		state = null;
		
		try {
			state = (Statement) conn.createStatement();
			state.executeUpdate("insert into funciontbl(nombre_emp, name_funcion, category_funcion, descrip_funcion) values('"+nombreEmp+"', 'Gerente', 'Categoría A', 'Desempeñar en una organización la planeación, la organización, la dirección y el control');");
			state.close();	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*Crear locales*/
	public void crearLocales(String nombre_empresa, String tipo, String nombre_local, String prov, String ciudad, String direc, String telf1, String telf2) {
		state = null;
		try {
			state = (Statement) conn.createStatement();
			state.executeUpdate("insert into localtbl (nombre_emp, tipoLocal, nombreLocal, provLocal, ciudadLocal, dirLocal, telf1Local, telf2Local) values('"+nombre_empresa+"','"+tipo+"', '"+nombre_local+"', '"+prov+"', '"+ciudad+"', '"+direc+"', '"+telf1+"', '"+telf2+"');");
			state.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*Seleciona los nombres de los locales de dicha empresa*/
	public ArrayList<String> getListLocales(String nombre) {
		ArrayList<String> locales = new ArrayList<String>();
		prs = null;
		rs = null;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select nombreLocal from localtbl where nombre_emp = '"+nombre+"';");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				locales.add(rs.getString("nombreLocal"));
			}
			prs.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return locales;	
	}
	/*Seleciona los nombres de los locales de dicha empresa POR CATEGORÍA*/
	public ArrayList<String> getListFunciones(String nombre) {
		ArrayList<String> funciones = new ArrayList<String>();
		prs = null;
		rs = null;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select name_funcion from funciontbl where nombre_emp = '"+nombre+"' and (category_funcion = 'Categoría A' or category_funcion = 'Categoría B' or category_funcion = 'Categoría C');");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				funciones.add(rs.getString("name_funcion"));
			}
			prs.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return funciones;	
	}
	/*Mostrar todas las funciones*/
	public ArrayList<String> getListFuncionesAll(String nombre) {
		ArrayList<String> funciones = new ArrayList<String>();
		prs = null;
		rs = null;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select name_funcion from funciontbl where nombre_emp = '"+nombre+"'");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				funciones.add(rs.getString("name_funcion"));
			}
			prs.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return funciones;	
	}
	/*Selecciona el último ID de LOCAL*/
	public int getIdLocal() {
		int num=0;
		prs = null;
		rs  = null;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select idLocal from localtbl order by idLocal desc limit 1;");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				num = rs.getInt("idLocal");
			}
			prs.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public void allDataLocalTbl(JTextField txtId, JComboBox<Local_Tipos> cbTipo, JTextField txtLocal, JComboBox<String> cbProv, JComboBox<String> cbCiudad, JTextArea txtDir, JTextField txtTelf1, JTextField txtTelf2, String nombre_emp, String nombre_local) {	
		prs = null;
		rs = null;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select * from localtbl where nombre_emp = '"+nombre_emp+"' and nombreLocal = '"+nombre_local+"';");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				txtId.setText(rs.getString("idLocal"));
				cbTipo.getModel().setSelectedItem(rs.getString("tipoLocal"));
				txtLocal.setText(rs.getString("nombreLocal"));
				cbProv.getModel().setSelectedItem(rs.getString("provLocal"));
				cbCiudad.getModel().setSelectedItem(rs.getString("ciudadLocal"));
				txtDir.setText(rs.getString("dirLocal"));
				txtTelf1.setText(rs.getString("telf1Local"));
				txtTelf2.setText(rs.getString("telf2Local"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void updateLocal(String tipo, String local, String prov, String ciudad, String dir, String telf1, String telf2, String empresa, String oldLocal) {
		state = null;
		try {
			state = (Statement) conn.createStatement();
			state.executeUpdate("update localtbl set tipoLocal='"+tipo+"', nombreLocal = '"+local+"', provLocal ='"+prov+"', ciudadLocal='"+ciudad+"', dirLocal='"+dir+"', telf1Local='"+telf1+"', telf2Local='"+telf2+"' where nombre_emp = '"+empresa+"' and nombreLocal='"+oldLocal+"';");
			state.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*Al momento de guardar dicha empresa se CREA TABLA de REGISTRO para dicha empresa*/
	public void crearTablaRegxId(int id) {
		state = null;
		try {
			state = (Statement) conn.createStatement();
			String sql = "create table reg_history"+id+"("+ 
					"id_history int not null auto_increment," + 
					"nombre_emp varchar(25) not null," + 
					"nombre_local varchar(25) not null," + 
					"hora_ini time not null," + 
					"fecha_ini date not null," + 
					"hora_fin time null," + 
					"fecha_fin date null," + 
					"primary key (id_history)" + 
					");";
			state.execute(sql);
			state.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*Mostrar los NOMBRES de la EMPRESAS que está en la base de datos*/
	public ArrayList<String> empresasNombresList(){
		ArrayList<String> empresas = new ArrayList<String>();
		prs = null;
		rs = null;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select nombre_emp from empresatbl;");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				empresas.add(rs.getString("nombre_emp"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empresas;
	}
	/*Mostrar el RUC de dicha EMPRESA seleccionada*/
	public String rucEmpresa(String nameEmpresa) {
		prs = null;
		rs = null;
		String empresa = null;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select ruc_emp from empresatbl where nombre_emp = '"+nameEmpresa+"';");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				empresa = rs.getString("ruc_emp");
			}
			prs.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}
	/*Al inicio del login, click BOTON conectar BASE de DATOS y directo al último registro*/
	public String nombreEmpresaHistorial() {
		prs = null;
		rs = null;
		String empresa = null;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select nombre_emp from reg_history order by id_history desc limit 1;");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				empresa = rs.getString("nombre_emp");
			}
			prs.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}
	/*Registro de INICIO de hora y fecha del inicio de la operacion de dicha empresa-----------------> OK*/
	public void regHistorialEmpresa(String nombreEmpresa, String nombreLocal, String nombreUser, String hora, String fecha) {
		state = null;
		try {
			state = (Statement) conn.createStatement();
			state.executeUpdate("insert into reg_history (nombre_emp, nombre_local, nombre_user, hora_ini, fecha_ini, hora_fin, fecha_fin) values('"+nombreEmpresa+"','"+nombreLocal+"', '"+nombreUser+"', cast('"+hora+"' as time), cast('"+fecha+"' as date), null, null);");
			state.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	/*Seleccionar el id del ultimo registro con el local repectivo para hacer el cierre*/
	public int getIdRegHistoryLast() {
		prs = null;
		rs = null;
		int idRegHist = 0;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select id_history from reg_history order by id_history desc limit 1;");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				idRegHist = rs.getInt("id_history");
			}
			prs.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return idRegHist;
	}
	/*Registro de CIERRE hora y fecha de la operación de dicha empresa*/
	public void regCierreHistorial(String hora, String fecha, String nombreEmpresa, String nombreLocal, int idRegHist) {
		state = null;
		try {
			state = (Statement) conn.createStatement();
			state.executeUpdate("update reg_history set hora_fin = cast('"+hora+"' as time), fecha_fin = cast('"+fecha+"' as date) where nombre_emp = '"+nombreEmpresa+"' and nombre_local = '"+nombreLocal+"' and id_history = "+idRegHist+";");
			state.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	//Financiero
	/*Mostrar los Activos*/
	public ArrayList<String> planCtaList(String tipoCta){
		ArrayList<String> activo = new ArrayList<String>();
		prs = null;
		rs = null;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select nameCta from planCtastbl where tipoCta = '"+tipoCta+"';");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				activo.add(rs.getString("nameCta"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return activo;
	}
	/*Registro de nueva Función o Cargo*/
	public void crearFuncion(String empresa, String funcion, String categoria, String descripcion) {
		state = null;
		try {
			state = (Statement) conn.createStatement();
			state.executeUpdate("insert into funciontbl(nombre_emp, name_funcion, category_funcion, descrip_funcion) values('"+empresa+"', '"+funcion+"', '"+categoria+"', '"+descripcion+"');");
			state.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	/*Registro de nuevo Empleado*/
	public void crearEmpleado(String nombreEmp, String nombre1, String nombre2, String apellido1, String apellido2) {
		state = null;
		
		try {
			state = (Statement) conn.createStatement();
			state.executeUpdate("insert into empleadostbl (nombre_emp, nombre1, nombre2, apellido1, apellido2) values('"+nombreEmp+"','"+nombre1+"','"+nombre2+"','"+apellido1+"','"+apellido2+"');");
			state.close();	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*Listados de empleados*/
	public ArrayList<String> listaEmpleado(String empresa){
		ArrayList<String> empleados = new ArrayList<String>();
		prs = null;
		rs = null;
		try {
			prs = (PreparedStatement) conn.prepareStatement("select concat(apellido1, \" \", nombre1) as empleado from empleadostbl where nombre_emp ='"+empresa+"';");
			prs.execute();
			rs = prs.getResultSet();
			while(rs.next()) {
				empleados.add(rs.getString("empleado"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empleados;
	}

	
}