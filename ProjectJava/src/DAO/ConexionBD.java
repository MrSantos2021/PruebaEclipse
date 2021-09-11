package DAO;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConexionBD {
	private String driver = "com.mysql.jdbc.Driver";
	private String connect = "jdbc:mysql://santos1.heliohost.us/santos1_pruebadb?useSSL=false";
	private String user = "santos1_remote";
	private String pass = "root12345";
	
	private Connection conn;
	
	private Statement st1;
	
	public ConexionBD() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection() {
		conn = null;
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(connect, user, pass);
			JOptionPane.showMessageDialog(null, "Conexión exitoso.", "Base de Datos", JOptionPane.INFORMATION_MESSAGE);
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
	
	public void registarBD(String nombre, String personaje, String arma) {
		st1 = null;
		try {
			st1 = (Statement) conn.createStatement();
			st1.executeUpdate("insert into gametbl(nombre, personaje, arma) values('"+nombre+"', '"+personaje+"', '"+arma+"');");
			st1.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
