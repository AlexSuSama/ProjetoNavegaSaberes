package br.alexsusama.persisntencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.sqlite.SQLiteConfig;

public class ConnectionDB {
	public static Connection con = null;
	public String DBpath ="jdbc:sqlite:C:\\Users\\AlexSama\\eclipse-workspace\\ProjetoNavegaSaberes\\src\\db\\ProjetoNavegaDB.db";
	
	public ConnectionDB() throws SQLException{
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
		
			con = DriverManager.getConnection(DBpath,config.toProperties());
			System.out.println("conectado ao banco");
		} catch ( ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
	public Connection getConection() {
		return con;
	}
}
