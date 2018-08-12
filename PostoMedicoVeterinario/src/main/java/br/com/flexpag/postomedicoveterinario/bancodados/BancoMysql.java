package br.com.flexpag.postomedicoveterinario.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoMysql {
	private Connection conn;
	
	public Connection conectar() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/postosaude?characterEncoding=UTF8";
		String user = "admin";
		String pass = "123456789";

		Class.forName(driver);
		this.conn = DriverManager.getConnection(url, user, pass);
		
		this.conn.setAutoCommit(false);
		
		return this.conn;
	}
	
	public Connection desconectar() throws SQLException {
		this.conn.commit();
		this.conn.close();
		
		return this.conn;
	}
}
