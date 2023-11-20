package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoComBanco implements Database{
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=Budah";
	
	private static final String DRIVER= "com.mysql.cj.jdbc.Driver";
		
	private static final String USUARIO = "Budah";
	
	private static final String SENHA = "VitorSQLDeusVult";


	@Override
	public Connection conectar() {
		System.out.println("Conectando ao Banco de Dados");
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			Logger.getLogger(ConexaoComBanco.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;	
	}

	@Override
	public void desconectar(Connection conexao) {
		try {
			conexao.close();
		} catch (SQLException e) {
			 Logger.getLogger(ConexaoComBanco.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
}
